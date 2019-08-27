package com.alamousse.modules.order.service.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.alamousse.annotation.Query;

/**
* @author mike
* @date 2019-07-27
*/
@Data
public class OrderQueryCriteria{

    // 精确
    @Query(type = Query.Type.INNER_LIKE)
    private String id;

    // 精确
    @Query
    private Integer shopId;

    // 精确
    @Query
    private Integer mid;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String acount;

    // 精确
    @Query
    private Integer payType;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String payId;

    // 精确
    @Query
    private Timestamp payTime;

    // 精确
    @Query
    private BigDecimal goodsPrice;

    // 精确
    @Query
    private String currency;

    // 精确
    @Query
    private String currencySymbol;

    // 精确
    @Query
    private BigDecimal tax;

    // 精确
    @Query
    private BigDecimal taxPrice;

    // 精确
    @Query
    private BigDecimal pointPrice;

    // 精确
    @Query
    private BigDecimal actualPrice;

    // 精确
    @Query
    private String deliveryId;

    // 精确
    @Query
    private String deliveryTime;

    // 精确
    @Query
    private BigDecimal deliveryPrice;

    // 精确
    @Query
    private BigDecimal volume;

    // 精确
    @Query
    private BigDecimal weight;

    // 精确
    @Query
    private BigDecimal promotePrice;

    // 精确
    @Query
    private String promoteCode;

    // 精确
    @Query
    private Integer state;

    // 精确
    @Query
    private Timestamp orderTime;
}