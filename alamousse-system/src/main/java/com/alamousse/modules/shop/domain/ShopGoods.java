package com.alamousse.modules.shop.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author jie
* @date 2019-07-20
*/
@Entity
@Data
@Table(name="shop_goods")
public class ShopGoods implements Serializable {

    // ID
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 菜单分类
//    @Column(name = "catagrory_id")
//    private Integer catagroryId;

    // 店铺Id
//    @Column(name = "shop_id")
//    private long shopId;

    // 中文名称
    @Column(name = "cname")
    private String cname;

    // 英文名称
    @Column(name = "ename")
    private String ename;

    // 价格
    @Column(name = "price")
    private BigDecimal price;

    // 折扣
    @Column(name = "discount")
    private Integer discount;

    // point
    @Column(name = "point")
    private BigDecimal point;

    // 是否可用优惠卷
    @Column(name = "is_promote")
    private Integer isPromote;

    // 优惠价
    @Column(name = "promote_price")
    private BigDecimal promotePrice;

    // 成本
    @Column(name = "cost")
    private BigDecimal cost;

    // 货币名称
    @Column(name = "currency")
    private String currency;

    @OneToOne
    @JoinColumn(name = "catagrory_id")
    private ShopGoodsCatagrory goodsCatagrory;

    @OneToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    // 货币符号
    @Column(name = "unit")
    private String unit;

    // 英文描述
    @Column(name = "edescription")
    private String edescription;

    // 中文描述
    @Column(name = "cdescription")
    private String cdescription;

    //本店特色菜
    @Column(name = "is_feature")
    private Integer isFeature;

    //本店特色菜
    @Column(name = "is_hot")
    private Integer isHot;

    //本店特色菜
    @Column(name = "is_new")
    private Integer isNew;

    public void copy(ShopGoods source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }

    //public @interface Update {}
}
