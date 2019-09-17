package com.alamousse.appmodules.market.domain;

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
@Table(name="redeem_point")
public class RedeemPoint implements Serializable {

    // Code
    @Id
    @Column(name = "code")
    private String code;

    // Redeem Id
    @Column(name = "redeem_id")
    private Integer redeemId;

    // Redeem Ename
    @Column(name = "redeem_ename")
    private String redeemEname;

    // Redeem Cname
    @Column(name = "redeem_cname")
    private String redeemCname;

    // Member ID
    @Column(name = "mid")
    private Integer mid;

    // Shop Id
    @Column(name = "shop_id")
    private Integer shopId;

    // Reward Point
    @Column(name = "point")
    private BigDecimal point;

    // Remark
    @Column(name = "remark")
    private String remark;

    // Receive Time 获取的时间
    @Column(name = "receive_time")
    private Timestamp receiveTime;

    // Use Time
    @Column(name = "use_time")
    private Timestamp useTime;

    // State
    @Column(name = "state")
    private Integer state;

    // Type
    @Column(name = "type")
    private Integer type;

    public void copy(RedeemPoint source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
