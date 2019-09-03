package com.alamousse.appmodules.security.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.appmodules.security.security.MemberAuthenticationInfo;
import com.alamousse.appmodules.security.security.MemberAuthorization;
import com.alamousse.appmodules.security.security.JwtMember;

import com.alamousse.appmodules.security.service.JwtMemberDetailsService;
import com.alamousse.appmodules.security.utils.MemberJwtTokenUtil;
import com.alamousse.utils.EncryptUtils;
import com.alamousse.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import  com.alamousse.response.HttpResponse;

/**
 * @author mike
 * @date 2019-07-23
 * 授权、根据token获取用户详细信息
 */
@Slf4j
@RestController
@RequestMapping("auth")
public class MemberAuthenticationController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private MemberJwtTokenUtil memberJwtTokenUtil;

    @Autowired
    @Qualifier("jwtMemberDetailsService")
    private UserDetailsService userDetailsService;

    /**
     * 登录授权
     * @param authorizationUser
     * @return
     */
    @Log("用户登录")
    @PostMapping(value = "${jwt.auth.path}")
    public ResponseEntity login(@Validated @RequestBody MemberAuthorization authorizationUser){
        log.error("----------------------test---------------------------------");
        System.out.print(authorizationUser.toString());

        String useName = "";
        Integer  loginType = authorizationUser.getLoginType();
        if ( loginType==null ){
            return ResponseEntity.ok(new HttpResponse(1,null,"Please Pass Login Type"));
        }else if ( loginType==0 ) {
            useName = authorizationUser.getAccount();
            if ( useName == null){
                return ResponseEntity.ok(new HttpResponse(1,null,"Account Can not Be Null"));
            }
        }else if ( loginType==1 ) {
            useName = authorizationUser.getUseremail();
            if ( useName == null){
                return ResponseEntity.ok(new HttpResponse(1,null,"Email Can not Be Null"));
            }
        }else if ( loginType==2 ) {
            useName = authorizationUser.getMobile();
            if ( useName == null){
                return ResponseEntity.ok(new HttpResponse(1,null,"Phone Can not Be Null"));
            }
        }

        final JwtMember jwtMember = (JwtMember) userDetailsService.loadUserByUsername(useName);
        if(!jwtMember.getPassword().equals(authorizationUser.getPassword())){
            return ResponseEntity.ok(new HttpResponse(1,null,"password error"));
            //throw new AccountExpiredException("password error");
        }
        System.out.print("-----------------------------------------");
        System.out.print(jwtMember.getShopId());
        System.out.print("\n---------\n");
        System.out.print(authorizationUser.getShopId());
        System.out.print("-----------------------------------------");
        if( !jwtMember.getShopId().toString().equals(authorizationUser.getShopId())){
            return ResponseEntity.ok(new HttpResponse(1,null,"the member is not  in the shop"));
            //throw new AccountExpiredException("password error");
        }

        if(!jwtMember.isEnabled()){
            return ResponseEntity.ok(new HttpResponse(1,null,"Account is prohibit,Please Contack Manager"));
            //throw new AccountExpiredException("Account is prohibit,Please Contack Manager");
        }

        // 生成令牌
        final String token = memberJwtTokenUtil.generateToken(jwtMember);

        // 返回 token
        return new ResponseEntity(new HttpResponse(0,new MemberAuthenticationInfo(token, jwtMember),null), HttpStatus.OK);
        //return ResponseEntity.ok(new MemberAuthenticationInfo(token, jwtMember));
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping(value = "${jwt.auth.account}")
    public ResponseEntity getUserInfo(){
        JwtMember jwtMember = (JwtMember)userDetailsService.loadUserByUsername(SecurityUtils.getUsername());
        return ResponseEntity.ok(new HttpResponse(0,jwtMember,null));
        //return ResponseEntity.ok(jwtMember);
    }

}
