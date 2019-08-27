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
public class PromoteSettingQueryCriteria{

    // 精确
    @Query
    private Integer id;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp startDate;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp endDate;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String ename;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String cname;

    // 精确
    @Query
    private Integer shopId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private BigDecimal price;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private BigDecimal discount;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp goods;

    // 精确
    @Query
    private String remark;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String goodsType;

    // 精确
    @Query
    private Integer type;

    // 精确
    @Query
    private Integer quantity;
}