package com.alamousse.modules.market.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;


/**
* @author mike
* @date 2019-08-01
*/
@Data
public class PromoteSettingDTO implements Serializable {

    // Id
    private Integer id;

    // Start Date 
    private Timestamp startDate;

    // End Date 
    private Timestamp endDate;

    // English  Name
    private String ename;

    // Chinese Name
    private String cname;

    // Shop Id
    private Integer shopId;

    // Promote Price  价格
    private BigDecimal price;

    // Discount
    private BigDecimal discount;

    // Goods
    private String goods;

    // Remark
    private String remark;

    // Goods Type    或者优惠的类目
    private String goodsType;

    // Type
    private Integer type;

    // Quantity
    private Integer quantity;
}