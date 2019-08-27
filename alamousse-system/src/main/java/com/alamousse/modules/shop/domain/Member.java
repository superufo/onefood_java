package com.alamousse.modules.shop.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;
import java.util.Date;

/**
* @author mike
* @date 2019-07-20
*/
@Entity
@Data
@Table(name="member")
public class Member implements Serializable {
    // Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid")
    private Integer mid;

    // 账号
    @Column(name = "account")
    private String account;

    // 姓
    @Column(name = "firstname")
    private String firstname;

    // 名
    @Column(name = "lastname")
    private String lastname;

    // 密码
    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "shop_id")
    private Integer shopId;

    // email
    @Column(name = "useremail")
    private String useremail;

    // 手机
    @Column(name = "mobile")
    private String mobile;

    // Facebook
    @Column(name = "facebook")
    private String facebook;

    // google 账号
    @Column(name = "google")
    private String google;

    // 头像
    @Column(name = "image")
    private String image;

    // 生日
    @Column(name = "birthday")
    private Timestamp birthday;

    // 地址
    @Column(name = "address_id")
    private String addressId;

    // 状态
    @Column(name = "state")
    private Integer state;

    // 性别
    @Column(name = "sex")
    private Integer sex;

    // 昵称
    @Column(name = "nickname")
    private String nickname;

    // 组Id
    @Column(name = "group_id")
    private Integer groupId;

    // 总的奖赏
    @Column(name = "userpoint")
    private Integer userpoint;

    // 最后登录时间
    @Column(name = "last_login_time")
    private Timestamp lastLoginTime;

    // 最后登录Ip
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    // 系统创建时间
    @Column(name = "created_at")
    private Timestamp createdAt;

    // 系统更新时间
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "last_password_reset_time")
    private Date lastPasswordResetTime;

    public void copy(Member source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}