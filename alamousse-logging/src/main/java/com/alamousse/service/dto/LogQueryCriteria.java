package com.alamousse.service.dto;

import lombok.Data;
import com.alamousse.annotation.Query;

/**
 * 日志查询类
 * @author mike
 * @date 2019-6-4 09:23:07
 */
@Data
public class LogQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String username;

    @Query
    private String logType;

    @Query(type = Query.Type.INNER_LIKE)
    private String description;
}
