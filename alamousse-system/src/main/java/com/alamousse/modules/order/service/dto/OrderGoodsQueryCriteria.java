package com.alamousse.modules.order.service.dto;

import lombok.Data;
import java.math.BigDecimal;
import com.alamousse.annotation.Query;

/**
* @author mike
* @date 2019-07-27
*/
@Data
public class OrderGoodsQueryCriteria{

    // 精确
    @Query
    private Integer id;

    // 精确
    @Query
    private Integer goodsId;

    // 精确
    @Query
    private String goodsName;

    // 精确
    @Query
    private Integer shopId;

    // 精确
    @Query
    private Integer quantity;

    // 精确
    @Query
    private BigDecimal unitPrice;

    // 精确
    @Query
    private BigDecimal price;

    // 精确
    @Query
    private BigDecimal unitPoint;

    // 精确
    @Query
    private BigDecimal point;

    // 精确
    @Query
    private String orderId;

    // 精确
    @Query
    private BigDecimal volume;

    // 精确
    @Query
    private BigDecimal weight;
}