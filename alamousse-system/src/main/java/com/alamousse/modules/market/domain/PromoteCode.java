package com.alamousse.modules.market.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author mike
* @date 2019-08-01
*/
@Entity
@Data
@Table(name="promote_code")
public class PromoteCode implements Serializable {

    // Code
    @Id
    @Column(name = "code")
    private String code;

    // Promote Id   优惠卷类别ID
    @Column(name = "promote_id",nullable = false)
    private Integer promoteId;

    // Member Id 
    @Column(name = "mid",nullable = false)
    private Integer mid;

    // Shop Id
    @Column(name = "shop_id",nullable = false)
    private Integer shopId;

    // Promote Price
    @Column(name = "price")
    private BigDecimal price;

    // DIscount
    @Column(name = "discount")
    private BigDecimal discount;

    // Order Id
    @Column(name = "order_id")
    private Integer orderId;

    // Remark
    @Column(name = "remark")
    private String remark;

    // State
    @Column(name = "state")
    private Integer state;

    // Use Time
    @Column(name = "use_time")
    private Timestamp useTime;

    //  Receive Time
    @Column(name = "receive_time")
    private Timestamp receiveTime;

    public void copy(PromoteCode source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}