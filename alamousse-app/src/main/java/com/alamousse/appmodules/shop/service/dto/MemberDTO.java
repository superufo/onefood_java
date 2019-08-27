package com.alamousse.appmodules.shop.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
* @author mike
* @date 2019-07-20
*/
@Data
public class MemberDTO implements Serializable {

//    // Id
//    private Integer id;

    // mId
    private Integer mid;

    // 账号
    private String account;

    // 姓
    private String firstname;

    // 名
    private String lastname;

    // 密码
    private String password;

    private Integer shopId;

    // email
    private String useremail;

    // 手机
    private String mobile;

    // Facebook
    private String facebook;

    // google 账号
    private String google;

    // 头像
    private String image;

    // 生日
    private Timestamp birthday;

    // 地址
    private String addressId;

    // 状态
    private Integer state;

    // 性别
    private Integer sex;

    // 昵称
    private String nickname;

    // 组Id
    private Integer groupId;

    // 总的奖赏
    private Integer userpoint;

    // 最后登录时间
    private Timestamp lastLoginTime;

    // 最后登录Ip
    private String lastLoginIp;

    // 系统创建时间
    private Timestamp createdAt;

    // 系统更新时间
    private Timestamp updatedAt;

    private Date lastPasswordResetTime;
}