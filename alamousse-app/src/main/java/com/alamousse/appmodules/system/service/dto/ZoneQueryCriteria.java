package com.alamousse.appmodules.system.service.dto;

import com.alamousse.annotation.Query;
import lombok.Data;

/**
* @author mike
* @date 2019-07-21
*/
@Data
public class ZoneQueryCriteria{

    // 精确
    @Query
    private Integer id;

    // 精确
    @Query
    private Integer type;

    // 精确
    @Query
    private Integer parentId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String cname;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String ename;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String latitude;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String longitude;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String remark;
}