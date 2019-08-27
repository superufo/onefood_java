package com.alamousse.appmodules.system.service.dto;

import lombok.Data;

import java.io.Serializable;


/**
* @author mike
* @date 2019-07-21
*/
@Data
public class ZoneSmallDTO implements Serializable {

    // ID
    private Integer id;

    // 中文名称
    private String cname;

    // 英文名称
    private String ename;
}