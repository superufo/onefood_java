package com.alamousse.appmodules.market.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.alamousse.annotation.Query;

/**
* @author mike
* @date 2019-08-01
*/
@Data
public class PromoteCodeQueryCriteria{

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String code;

    // 精确
    @Query
    private Integer promoteId;

    // 精确
    @Query
    private Integer mid;

    // 精确
    @Query
    private Integer shopId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private BigDecimal price;

    // 精确
    @Query
    private BigDecimal discount;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer orderId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String remark;

    // 精确
    @Query
    private Integer state;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp useTime;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp receiveTime;
}
