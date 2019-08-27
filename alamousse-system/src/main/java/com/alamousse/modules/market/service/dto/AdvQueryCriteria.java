package com.alamousse.modules.market.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import com.alamousse.annotation.Query;

/**
* @author mike
* @date 2019-08-01
*/
@Data
public class AdvQueryCriteria{

    // 精确
    @Query
    private Integer id;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer shopId;

    // 精确
    @Query
    private Integer category;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String title;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer content;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer pic;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String link;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String remark;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp startTime;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp endTime;
}