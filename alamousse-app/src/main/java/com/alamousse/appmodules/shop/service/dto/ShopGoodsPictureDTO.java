package com.alamousse.appmodules.shop.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


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
