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
@Table(name="order_goods")
public class OrderGoods implements Serializable {

    // Id 
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Goods Id
    @Column(name = "goods_id")
    private Integer goodsId;

    // Goods Name
    @Column(name = "goods_name")
    private String goodsName;

    // Shop Id
    @Column(name = "shop_id")
    private Integer shopId;

    // quantity
    @Column(name = "quantity")
    private Integer quantity;

    // Unit Price
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    // Sum Price
    @Column(name = "price")
    private BigDecimal price;

    // Unit Point
    @Column(name = "unit_point")
    private BigDecimal unitPoint;

    // Sum Point
    @Column(name = "point")
    private BigDecimal point;

    // Order Id
    @Column(name = "order_id")
    private String orderId;

    // volume
    @Column(name = "volume")
    private BigDecimal volume;

    // weight
    @Column(name = "weight")
    private BigDecimal weight;

    public void copy(OrderGoods source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}