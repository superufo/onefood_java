package com.alamousse.appmodules.security.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author mike
 * @date 2019-07-23
 * 返回token
 */
@Getter
@AllArgsConstructor
public class MemberAuthenticationInfo implements Serializable {

    private final String token;

    private final JwtMember jwtMember;
}
