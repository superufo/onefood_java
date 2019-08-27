package com.alamousse.modules.shop.service.dto;

import com.alamousse.annotation.Query;
import lombok.Data;
import java.math.BigDecimal;

/**
* @author jie
* @date 2019-07-20
*/
@Data
public class ShopGoodsQueryCriteria{

    // 精确
    @Query
    private String id;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer catagroryId;

    // 精确
    @Query
    private Integer shopId;

//    @Query(propName = "id", joinName = "goodsCatagrory")
//    private Integer catagroryId;

//    @Query(propName = "id", joinName = "shop")
//    private Integer shopId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String cname;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String ename;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private BigDecimal price;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer discount;

    // 精确
    @Query
    private BigDecimal point;

    // 精确
    @Query
    private Integer isPromote;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private BigDecimal promotePrice;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private BigDecimal cost;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String currency;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String unit;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String edescription;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String cdescription;
}