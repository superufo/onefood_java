package com.alamousse.appmodules.system.service.dto;

import com.alamousse.appmodules.system.domain.vo.ZoneVo;
import lombok.Data;

import java.io.Serializable;


/**
* @author mike
* @date 2019-07-21
*/
@Data
public class ZoneDTO implements Serializable {

    // ID
    private Integer id;

    // 类型
    private Integer type;

    // 父ID
    private Integer parentId;

    // 中文名称
    private String cname;

    // 英文名称
    private String ename;

    // 经度
    private String latitude;

    // 纬度
    private String longitude;

    // 备注
    private String remark;

    //zone 信息  上级的列表
    private ZoneVo zonevo;
}