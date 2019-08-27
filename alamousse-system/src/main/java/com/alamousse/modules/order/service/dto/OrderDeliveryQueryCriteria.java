package com.alamousse.modules.order.service.dto;

import lombok.Data;
import java.math.BigDecimal;
import com.alamousse.annotation.Query;

/**
* @author mike
* @date 2019-07-27
*/
@Data
public class OrderDeliveryQueryCriteria{

    // 精确
    @Query
    private String id;

    // 精确
    @Query
    private Integer shopId;

    // 精确
    @Query
    private String orderId;

    // 精确
    @Query
    private Integer mid;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String deliveryTime;

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
    private String address;

    // 精确
    @Query
    private BigDecimal price;
}