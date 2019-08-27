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
public class RedeemPointDTO implements Serializable {

    // Code
    private String code;

    // Redeem Id
    private Integer redeemId;

    // Redeem Ename
    private String redeemEname;

    // Redeem Cname
    private String redeemCname;

    // Member ID
    private Integer mid;

    // Shop Id
    private Integer shopId;

    // Reward Point 
    private BigDecimal point;

    // Remark
    private String remark;

    // Receive Time 获取的时间
    private Timestamp receiveTime;

    // Use Time
    private Timestamp useTime;

    // State
    private Integer state;

    // Type
    private Integer type;
}