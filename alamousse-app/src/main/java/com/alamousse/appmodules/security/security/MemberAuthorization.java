package com.alamousse.appmodules.security.security;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * @author mike
 * @date 2018-11-30
 */
@Getter
@Setter
public class MemberAuthorization {
    // 0 账号登录  1 email 登录
    private Integer loginType;

    private String account;

    private String useremail;

    private String mobile;

    @NotBlank
    private String password;

    private String code;

    private String shopId;

    private String uuid = "";

    @Override
    public String toString() {
        return "{account=" + account + "shopId=" + shopId  + "useremail=" + useremail +  "mobile=" + mobile +  ", password= ******}";
    }
}
