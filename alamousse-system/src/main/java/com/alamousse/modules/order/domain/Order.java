package com.alamousse.modules.order.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author mike
* @date 2019-07-27
*/
@Entity
@Data
@Table(name="orders")
public class Order implements Serializable {

    // ID
    @Id
    @Column(name = "id")
    private String id;

    // Shop Id
    @Column(name = "shop_id",nullable = false)
    private Integer shopId;

    // Member Id
    @Column(name = "mid")
    private Integer mid;

    // Member Acount
    @Column(name = "acount")
    private String acount;

    // Pay Type
    @Column(name = "pay_type")
    private Integer payType;

    // Pay Id
    @Column(name = "pay_id")
    private String payId;

    // Pay Time
    @Column(name = "pay_time")
    private Timestamp payTime;

    // Goods Price
    @Column(name = "goods_price")
    private BigDecimal goodsPrice;

    // Currency
    @Column(name = "currency")
    private String currency;

    // Currency
    @Column(name = "currency_symbol")
    private String currencySymbol;

    // Tax
    @Column(name = "tax")
    private BigDecimal tax;

    // Tax Price
    @Column(name = "tax_price")
    private BigDecimal taxPrice;

    // Point Price 
    @Column(name = "point_price")
    private BigDecimal pointPrice;

    // Actual Price
    @Column(name = "actual_price")
    private BigDecimal actualPrice;

    // Delivery Id
    @Column(name = "delivery_id")
    private String deliveryId;

    // Delivery Time
    @Column(name = "delivery_time")
    private String deliveryTime;

    // Delivery Price
    @Column(name = "delivery_price")
    private BigDecimal deliveryPrice;

    // Volume
    @Column(name = "volume")
    private BigDecimal volume;

    // Weight
    @Column(name = "weight")
    private BigDecimal weight;

    // Promote Price
    @Column(name = "promote_price")
    private BigDecimal promotePrice;

    // Promote Code
    @Column(name = "promote_code")
    private String promoteCode;

    // State
    @Column(name = "state")
    private Integer state;

    // Order Time
    @Column(name = "order_time")
    private Timestamp orderTime;

    public void copy(Order source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}