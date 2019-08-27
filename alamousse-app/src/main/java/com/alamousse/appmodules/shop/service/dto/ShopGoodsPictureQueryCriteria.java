package com.alamousse.appmodules.shop.service.dto;

import com.alamousse.annotation.Query;
import lombok.Data;

/**
* @author mike
* @date 2019-07-30
*/
@Data
public class ShopGoodsPictureQueryCriteria{

    // 精确
    @Query
    private Long id;

    // 精确
    @Query
    private Integer shopId;

    // 精确
    @Query
    private Integer goodsId;

    // 精确
    @Query
    private Integer picId;

    // url
    private String url;
}