package com.alamousse.modules.order.service.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.io.Serializable;


/**
* @author mike
* @date 2019-07-27
*/
@Data
public class OrderGoodsDTO implements Serializable {

    // Id 
    private Integer id;

    // Goods Id
    private Integer goodsId;

    // Goods Name
    private String goodsName;

    // Shop Id
    private Integer shopId;

    // Quantity
    private Integer quantity;

    // Unit Price
    private BigDecimal unitPrice;

    // Sum Price
    private BigDecimal price;

    // Unit Point
    private BigDecimal unitPoint;

    // Sum Point
    private BigDecimal point;

    // Order Id
    private String orderId;

    // volume
    private BigDecimal volume;

    // weight
    private BigDecimal weight;
}