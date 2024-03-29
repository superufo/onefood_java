package com.alamousse.appmodules.shop.service.dto;

import com.alamousse.annotation.Query;
import lombok.Data;

/**
* @author mike
* @date 2019-07-25
*/
@Data
public class AddressQueryCriteria{

    // 精确
    @Query
    private String id;

    // 精确
    @Query
    private Integer mid;

    // 精确
    @Query
    private String country;

    // 精确
    @Query
    private String province;

    // 精确
    @Query
    private String city;

    // 精确
    @Query
    private String street;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String detail;

    // 精确
    @Query
    private Integer isDefault;
}