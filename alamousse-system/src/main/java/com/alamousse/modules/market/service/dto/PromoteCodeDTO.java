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
public class PromoteCodeDTO implements Serializable {

    // Code
    private String code;

    // Promote Id   优惠卷类别ID
    private Integer promoteId;

    // Member Id 
    private Integer mid;

    // Shop Id
    private Integer shopId;

    // Promote Price
    private BigDecimal price;

    // DIscount
    private BigDecimal discount;

    // Order Id
    private Integer orderId;

    // Remark
    private String remark;

    // State
    private Integer state;

    // Use Time
    private Timestamp useTime;

    //  Receive Time
    private Timestamp receiveTime;
}