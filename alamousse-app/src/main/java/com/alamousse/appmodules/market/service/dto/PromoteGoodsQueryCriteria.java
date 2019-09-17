package com.alamousse.appmodules.market.service.dto;

import lombok.Data;
import com.alamousse.annotation.Query;

/**
* @author mike
* @date 2019-08-01
*/
@Data
public class PromoteGoodsQueryCriteria{

    // 精确
    @Query
    private Integer id;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer promoteId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer goodsId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String promoteEname;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String promoteCname;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String goodsEname;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String goodsCname;
}
