package com.alamousse.modules.market.service.dto;

import lombok.Data;
import java.io.Serializable;


/**
* @author mike
* @date 2019-08-01
*/
@Data
public class AdvCatagroryDTO implements Serializable {

    // Id
    private Integer id;

    // English Name
    private String ename;

    // Chinese Name
    private String cname;

    // Position
    private Integer position;

    // Shop Id
    private Integer shopId;

    // Width
    private Integer wide;

    // Length
    private Integer length;

    // Remark
    private String remark;
}