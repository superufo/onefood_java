package com.alamousse.appmodules.shop.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author mike
* @date 2019-07-30
*/
@Entity
@Data
@Table(name="shop_goods_picture")
public class ShopGoodsPicture implements Serializable {
    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Shop ID
    @Column(name = "shop_id",nullable = false)
    private Integer shopId;

    // Goods ID
    @Column(name = "goods_id",nullable = false)
    private Integer goodsId;

    // Goods ID
    @Column(name = "pic_id",nullable = false)
    private Integer picId;

    // url
    @Column(name = "url",nullable = false)
    private String url;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;

    public void copy(ShopGoodsPicture source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}