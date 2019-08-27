package com.alamousse.modules.shop.service.dto.vo;

import lombok.Data;
import java.io.Serializable;

@Data
public class ShopGoodsCatagroryVo implements Serializable {
    // 父ID 英文名
    private String  pname;

    // 父ID 中文名
    private String  pcname;
}
