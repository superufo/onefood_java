package com.alamousse.appmodules.shop.service.dto;

import com.alamousse.appmodules.shop.service.dto.vo.ShopGoodsCatagroryVo;
import lombok.Data;

import java.io.Serializable;


/**
* @author mike
* @date 2019-07-20
*/
@Data
public class ShopGoodsCatagroryDTO implements Serializable {

    // id

    private Integer id;
    // 父ID
    private Integer parentId;

//    // 父ID 英文名
//    private String  pname;
//    // 父ID 中文名
//    private String  pcname;
    //父ID 英文名   父ID 中文名
    private ShopGoodsCatagroryVo shopGoodsCatagroryVo;

//    // 菜单父亲分类
//    private ShopGoodsCatagrory goodsCatagrory;

    // 中文名称
    private String cname;

    // 英文名称
    private String ename;

    // 备注
    private String remark;
}