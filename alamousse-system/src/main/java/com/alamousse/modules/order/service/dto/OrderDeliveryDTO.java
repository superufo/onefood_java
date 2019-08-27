package com.alamousse.modules.order.service.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.io.Serializable;


/**
* @author mike
* @date 2019-07-27
*/
@Data
public class OrderDeliveryDTO implements Serializable {

    // Id
    private String id;

    // Shop Id
    private Integer shopId;

    // Order Id
    private String orderId;

    // Member Id
    private Integer mid;

    // Member account
    private String account;

    // Delivery Time
    private String deliveryTime;

    // Country
    private String country;

    // Province
    private String province;

    // City
    private String city;

    // Address
    private String address;

    // Price
    private BigDecimal price;
}