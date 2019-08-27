package com.alamousse.modules.order.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author mike
* @date 2019-07-27
*/
@Entity
@Data
@Table(name="order_delivery")
public class OrderDelivery implements Serializable {

    // Id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    // Shop Id
    @Column(name = "shop_id")
    private Integer shopId;

    // Order Id
    @Column(name = "order_id")
    private String orderId;

    // Member Id
    @Column(name = "mid")
    private Integer mid;

    @Column(name = "account")
    private String account;

    // Delivery Time
    @Column(name = "delivery_time")
    private String deliveryTime;

    // Country
    @Column(name = "country")
    private String country;

    // Province
    @Column(name = "province")
    private String province;

    // City
    @Column(name = "city")
    private String city;

    // Address
    @Column(name = "address")
    private String address;

    // Price
    @Column(name = "price")
    private BigDecimal price;

    public void copy(OrderDelivery source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}