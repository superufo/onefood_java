package com.alamousse.appmodules.security.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Data
@Getter
@AllArgsConstructor
public class JwtMember implements UserDetails {
    // mId
    private Integer mid;

    // 账号  account
    private String username;

    // email
    private String useremail;

    // 手机
    private String mobile;

    private Integer shopId;

    // 密码
    private String password;

    // google 账号
    private String google;

    // Facebook
    private String facebook;

    // 姓
    private String firstname;

    // 名
    private String lastname;

    // 头像
    private String image;

    // 地址
    private String addressId;

    // 状态
    //private Integer state;
    private boolean enabled;

    // 性别
    private Integer sex;

    // 总的奖赏
    private Integer userpoint;

//    @JsonIgnore
//    // 生日
//    private Timestamp birthday;
//
//    // 昵称
//    private String nickname;
//
//    // 组Id
//    private Integer groupId;
//
//    // 最后登录时间
//    private Timestamp lastLoginTime;
//
//    // 最后登录Ip
//    private String lastLoginIp;
//
//    // 系统创建时间
//    private Timestamp createdAt;
//
//    // 系统更新时间
//    private Timestamp updatedAt;

    @JsonIgnore
    private final Date lastPasswordResetDate;

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
