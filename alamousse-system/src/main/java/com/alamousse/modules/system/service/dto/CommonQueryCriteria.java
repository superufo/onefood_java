package com.alamousse.modules.system.service.dto;

import lombok.Data;
import com.alamousse.annotation.Query;

/**
 * 公共查询类
 */
@Data
public class CommonQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query
    private Integer shopId;

}
