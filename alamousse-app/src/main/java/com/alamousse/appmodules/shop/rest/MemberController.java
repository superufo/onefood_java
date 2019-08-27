package com.alamousse.appmodules.shop.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.appmodules.shop.domain.Member;
import com.alamousse.appmodules.shop.service.MemberService;
import com.alamousse.appmodules.shop.service.dto.MemberDTO;
import com.alamousse.appmodules.shop.service.dto.MemberQueryCriteria;
import com.alamousse.appmodules.shop.service.dto.vo.MemberVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.alamousse.utils.SecurityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import  com.alamousse.response.HttpResponse;

/**
* @author mike
* @date 2019-07-20
*/
@Api(tags = "Member管理")
@RestController
@RequestMapping("api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Log("查询Member")
    @ApiOperation(value = "查询Member")
    @GetMapping(value = "/member")
    public ResponseEntity getMembers(MemberQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(new HttpResponse(0,memberService.queryAll(criteria,pageable),null),HttpStatus.OK);
    }

    @Log("新增Member")
    @ApiOperation(value = "新增Member")
    @PostMapping(value = "/member")
    public ResponseEntity create(@Validated @RequestBody Member resources){
        if ( Optional.ofNullable(resources.getAccount()).isPresent()==false ){
            return new ResponseEntity(new HttpResponse(1,null," The Account Can be not Empty"),HttpStatus.OK);
        }

        if ( Optional.ofNullable(resources.getUseremail()).isPresent()==false ){
            return new ResponseEntity(new HttpResponse(1,null," The Email  Can be not Empty"),HttpStatus.OK);
        }

        Member member= memberService.findMemberVoByAccount(resources.getAccount());
        if (member!=null) {
            return new ResponseEntity(new HttpResponse(1,null," The Account is Exist,Please Change Account"),HttpStatus.OK);
        }

        Member memberM= memberService.findMemberVoByMobile(resources.getMobile());
        if (memberM!=null) {
            return new ResponseEntity(new HttpResponse(1,null," The Mobile is Exist,Please Change Mobile"),HttpStatus.OK);
        }

        Member memberU = memberService.findMemberVoByUserEmail(resources.getUseremail());
        if (memberU!=null) {
            return new ResponseEntity(new HttpResponse(1,null," The UserEmail is Exist,Please Change UserEmail"),HttpStatus.OK);
        }

        MemberDTO  newMember = memberService.create(resources);
        return new ResponseEntity(new HttpResponse(0,newMember,null),HttpStatus.OK);
    }

    @Log("修改Member")
    @ApiOperation(value = "修改Member")
    @PutMapping(value = "/member")
    public ResponseEntity update(@Validated @RequestBody Member resources){
        memberService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Member")
    @ApiOperation(value = "删除Member")
    @DeleteMapping(value = "/member/{mid}")
    public ResponseEntity delete(@PathVariable Integer mid){
        memberService.delete(mid);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("查询Member")
    @ApiOperation(value = "查询Member")
    @GetMapping(value = "/member/{mid}/{account}")
    public ResponseEntity findMembersByInfo(@PathVariable Integer mid,@PathVariable String account){
        if ( account=="0" ) {
            account="";
        }

        List<MemberVo> memberVoList = new ArrayList<>();
        List<Member> memberList = memberService.findMemberVoByInfo(mid, account);
        for ( Member member : memberList ){
            MemberVo memberVo= new MemberVo();

            memberVo.setMid(member.getMid());
            memberVo.setAccount(member.getAccount());
            memberVoList.add(memberVo);
        }

        return new ResponseEntity(memberVoList,HttpStatus.OK);
    }

    private void setSearchShop(MemberQueryCriteria criteria){
        Integer shopId = SecurityUtils.getShopId();
        if ( shopId >  1 ) {
            criteria.setShopId(shopId);
        }else{
            criteria.setShopId(null);
        }
    }


}