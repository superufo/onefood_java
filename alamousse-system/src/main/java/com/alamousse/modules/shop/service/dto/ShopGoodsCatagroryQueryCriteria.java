package com.alamousse.modules.shop.service.dto;

import com.alamousse.annotation.Query;
import lombok.Data;

/**
* @author mike
* @date 2019-07-20
*/
@Data
public class ShopGoodsCatagroryQueryCriteria{

    // 精确
    @Query
    private Integer id;

    // 精确
    @Query
    private Integer parentId;

//    @Query(propName = "parent_id", joinName = "goodsCatagrory")
//    private Integer catagroryId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String cname;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String ename;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String remark;
}