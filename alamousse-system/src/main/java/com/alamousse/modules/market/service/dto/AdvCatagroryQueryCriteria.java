package com.alamousse.modules.market.service.dto;

import lombok.Data;
import com.alamousse.annotation.Query;

/**
* @author mike
* @date 2019-08-01
*/
@Data
public class AdvCatagroryQueryCriteria{

    // 精确
    @Query
    private Integer id;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String ename;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String cname;

    // 精确
    @Query
    private Integer position;

    // 精确
    @Query
    private Integer shopId;

    // 精确
    @Query
    private Integer wide;

    // 精确
    @Query
    private Integer length;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String remark;
}