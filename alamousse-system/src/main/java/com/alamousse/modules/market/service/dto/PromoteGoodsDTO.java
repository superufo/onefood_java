package com.alamousse.modules.market.service.dto;

import lombok.Data;
import java.io.Serializable;


/**
* @author mike
* @date 2019-08-01
*/
@Data
public class PromoteGoodsDTO implements Serializable {

    // ID
    private Integer id;

    // Promote Id
    private Integer promoteId;

    // Goods Id
    private Integer goodsId;

    // Promote Ename
    private String promoteEname;

    // Promote Cname
    private String promoteCname;

    // Goods Ename
    private String goodsEname;

    // Goods Cname
    private String goodsCname;
}