package com.alamousse.modules.market.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.alamousse.annotation.Query;

/**
* @author mike
* @date 2019-08-01
*/
@Data
public class RedeemPointQueryCriteria{

    // 精确
    @Query
    private String code;

    // 精确
    @Query
    private Integer redeemId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String redeemEname;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String redeemCname;

    // 精确
    @Query
    private Integer mid;

    // 精确
    @Query
    private Integer shopId;

    // 精确
    @Query
    private BigDecimal point;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String remark;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp receiveTime;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp useTime;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer state;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer type;
}