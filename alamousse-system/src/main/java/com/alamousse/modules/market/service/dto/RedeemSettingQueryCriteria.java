package com.alamousse.modules.market.service.dto;

import com.alamousse.annotation.Query;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
* @author mike
* @date 2019-08-01
*/
@Data
public class RedeemSettingQueryCriteria{

    // 精确
    @Query
    private Integer id;

    // 精确
    @Query
    private Integer shopId;

    // 精确
    @Query
    private BigDecimal point;

    // 精确
    @Query
    private BigDecimal discount;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String qrCode;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String ename;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String cname;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String remark;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String condition;

    // 精确
    @Query
    private Integer type;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp starTime;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp endTime;
}