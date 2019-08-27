package com.alamousse.modules.shop.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author mike
* @date 2019-07-30
*/
@Data
public class ShopGoodsPictureDTO implements Serializable {

    // ID
    private Long id;

    // Shop ID
    private Integer shopId;

    // Goods ID
    private Integer goodsId;

    // picId
    private Integer picId;

    // url
    private String url;

    private Timestamp createTime;

    private Timestamp updateTime;
}