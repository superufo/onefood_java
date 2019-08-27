package com.alamousse.modules.shop.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.shop.service.MemberService;
import com.alamousse.modules.shop.service.dto.MemberQueryCriteria;
import com.alamousse.modules.shop.service.dto.vo.MemberVo;
import com.alamousse.modules.shop.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import java.util.ArrayList;
import java.util.List;

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
    @PreAuthorize("hasAnyRole('ADMIN','MEMBER_ALL','MEMBER_SELECT')")
    public ResponseEntity getMembers(MemberQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(memberService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增Member")
    @ApiOperation(value = "新增Member")
    @PostMapping(value = "/member")
    @PreAuthorize("hasAnyRole('ADMIN','MEMBER_ALL','MEMBER_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Member resources){
        return new ResponseEntity(memberService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Member")
    @ApiOperation(value = "修改Member")
    @PutMapping(value = "/member")
    @PreAuthorize("hasAnyRole('ADMIN','MEMBER_ALL','MEMBER_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Member resources){
        memberService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Member")
    @ApiOperation(value = "删除Member")
    @DeleteMapping(value = "/member/{mid}")
    @PreAuthorize("hasAnyRole('ADMIN','MEMBER_ALL','MEMBER_DELETE')")
    public ResponseEntity delete(@PathVariable Integer mid){
        memberService.delete(mid);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("查询Member")
    @ApiOperation(value = "查询Member")
    @GetMapping(value = "/member/{mid}/{account}")
    @PreAuthorize("hasAnyRole('ADMIN','MEMBER_ALL','MEMBER_DELETE')")
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


}