package com.alamousse.appmodules.shop.service.dto;

import com.alamousse.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;

/**
* @author mike
* @date 2019-07-20
*/
@Data
public class MemberQueryCriteria{

    // 精确
    @Query
    private Integer mid;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String account;

    // 精确
    @Query
    private String firstname;

    @Query
    private Integer shopId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String lastname;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String password;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String useremail;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String mobile;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String facebook;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String google;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String image;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp birthday;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String addressId;

    // 精确
    @Query
    private Integer state;

    // 精确
    @Query
    private Integer sex;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String nickname;

    // 精确
    @Query
    private Integer groupId;

    // 精确
    @Query
    private Integer userpoint;

    // 精确
    @Query
    private Timestamp lastLoginTime;

    // 精确
    @Query
    private String lastLoginIp;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp createdAt;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp updatedAt;
}