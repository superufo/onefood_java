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
@Table(name="promote_setting")
public class PromoteSetting implements Serializable {

    // Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // Start Date
    @Column(name = "start_date",nullable = false)
    private Timestamp startDate;

    // End Date
    @Column(name = "end_date",nullable = false)
    private Timestamp endDate;

    // English  Name
    @Column(name = "ename")
    private String ename;

    // Chinese Name
    @Column(name = "cname")
    private String cname;

    // Shop Id
    @Column(name = "shop_id")
    private Integer shopId;

    // Promote Price  价格
    @Column(name = "price")
    private BigDecimal price;

    // Discount
    @Column(name = "discount")
    private BigDecimal discount;

    // Goods
    @Column(name = "goods")
    private String goods;

    // Remark
    @Column(name = "remark")
    private String remark;

    // Goods Type    或者优惠的类目
    @Column(name = "goods_type")
    private String goodsType;

    // Type
    @Column(name = "type")
    private Integer type;

    // Quantity
    @Column(name = "quantity")
    private Integer quantity;

    public void copy(PromoteSetting source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
