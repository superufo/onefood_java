package com.alamousse.modules.order.service.dto;

import lombok.Data;
import sun.security.timestamp.Timestamper;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;


/**
* @author mike
* @date 2019-07-27
*/
@Data
public class OrderDTO implements Serializable {

    // ID
    private String id;

    // Shop Id
    private Integer shopId;

    // Member Id
    private Integer mid;

    // Member Acount
    private String acount;

    // Pay Type
    private Integer payType;

    // Pay Id
    private String payId;

    // Pay Time
    private Timestamp payTime;

    // Goods Price
    private BigDecimal goodsPrice;

    // Currency
    private String currency;

    // Currency
    private String currencySymbol;

    // Tax
    private BigDecimal tax;

    // Tax Price
    private BigDecimal taxPrice;

    // Point Price 
    private BigDecimal pointPrice;

    // Actual Price
    private BigDecimal actualPrice;

    // Delivery Id
    private String deliveryId;

    // Delivery Time
    private String deliveryTime;

    // Delivery Price
    private BigDecimal deliveryPrice;

    // Volume
    private BigDecimal volume;

    // Weight
    private BigDecimal weight;

    // Promote Price
    private BigDecimal promotePrice;

    // Promote Code
    private String promoteCode;

    // State
    private Integer state;

    // Order Time
    private Timestamp orderTime;
}