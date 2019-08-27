package com.alamousse.appmodules.shop.service.dto;

import com.alamousse.annotation.Query;
import lombok.Data;

import java.math.BigDecimal;

/**
* @author mike
* @date 2019-07-20
*/
@Data
public class ShopQueryCriteria{

    // 精确
    @Query
    private Integer id;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String ename;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String owner;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String logo;

    // 精确
    @Query
    private Integer type;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String telphone;

    // 精确
    @Query
    private Integer country;

    // 精确
    @Query
    private Integer state;

    // 精确
    @Query
    private Integer city;

    // 精确
    @Query
    private Integer provice;

    // 精确
    @Query
    private Integer street;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String address;

    // 精确
    @Query
    private BigDecimal longitude;

    // 精确
    @Query
    private BigDecimal latitude;

    // 精确
    @Query
    private String tax;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String workStart;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String workEnd;


    // 店铺级别
    @Query
    private Integer datalevel;

    // 父店
    @Query
    private Integer pid;

}