package com.alamousse.appmodules.shop.service.dto;

import com.alamousse.appmodules.shop.domain.Shop;
import com.alamousse.appmodules.shop.domain.ShopGoodsCatagrory;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
* @author jie
* @date 2019-07-20
*/
@Data
public class ShopGoodsDTO implements Serializable {

    // ID
    private Integer id;

    // 菜单分类
    private Integer catagroryId;

    // 店铺Id
    private Integer shopId;

    // 菜单分类
    private ShopGoodsCatagrory goodsCatagrory;

    // 菜单分类
    private ArrayList<String> goodsPics;

    // 店铺Id
    private Shop shop;

    // 中文名称
    private String cname;

    // 英文名称
    private String ename;

    // 价格
    private BigDecimal price;

    // 折扣
    private Integer discount;

    // point
    private BigDecimal point;

    // 是否可用优惠卷
    private Integer isPromote;

    // 优惠价
    private BigDecimal promotePrice;

    // 成本
    private BigDecimal cost;

    // 货币名称
    private String currency;

    // 货币符号
    private String unit;

    // 英文描述
    private String edescription;

    // 中文描述
    private String cdescription;

    //本店特色菜
    private Integer isFeature;

    //本店特色菜
    private Integer isHot;

    //本店特色菜
    private Integer isNew;
}
