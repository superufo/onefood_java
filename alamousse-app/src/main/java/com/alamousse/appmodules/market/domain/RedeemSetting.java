package com.alamousse.appmodules.market.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
* @author mike
* @date 2019-08-01
*/
@Entity
@Data
@Table(name="redeem_setting")
public class RedeemSetting implements Serializable {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // Shop
    @Column(name = "shop_id",nullable = false)
    private Integer shopId;

    // Reward Point
    @Column(name = "point")
    private BigDecimal point;

    // Goods Discount
    @Column(name = "discount")
    private BigDecimal discount;

    // Link
    @Column(name = "link")
    private String link;

    // QR Code
    @Column(name = "qr_code")
    private String qrCode;

    // Remark
    @Column(name = "remark")
    private String remark;

    // Reward Condition
    @Column(name = "condition")
    private String condition;

    // Type
    @Column(name = "type")
    private Integer type;

    // Start Time
    @Column(name = "star_time")
    private Timestamp starTime;

    // End Time
    @Column(name = "end_time")
    private Timestamp endTime;

    public void copy(RedeemSetting source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
