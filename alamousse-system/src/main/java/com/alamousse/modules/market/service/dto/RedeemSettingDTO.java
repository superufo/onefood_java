package com.alamousse.modules.market.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
* @author mike
* @date 2019-08-01
*/
@Data
public class RedeemSettingDTO implements Serializable {

    // ID
    private Integer id;

    // Shop
    private Integer shopId;

    // Reward Point
    private BigDecimal point;

    // Goods Discount
    private String ename;

    private String cname;

    // Link
    private String link;

    // QR Code
    private String qrCode;

    // Remark
    private String remark;

    // Reward Condition
    private String condition;

    // Type
    private Integer type;

    // Start Time
    private Timestamp starTime;

    // End Time
    private Timestamp endTime;
}