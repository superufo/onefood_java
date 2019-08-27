package com.alamousse.appmodules.system.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
* @author mike
* @date 2019-07-21
*/
@Entity
@Data
@Table(name="zone")
public class Zone implements Serializable {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // 类型
    @Column(name = "type")
    private Integer type;

    // 父ID
    @Column(name = "parent_id")
    private Integer parentId;

    // 中文名称
    @Column(name = "cname")
    private String cname;

    // 英文名称
    @Column(name = "ename")
    private String ename;

    // 经度
    @Column(name = "latitude")
    private String latitude;

    // 纬度
    @Column(name = "longitude")
    private String longitude;

    // 备注
    @Column(name = "remark")
    private String remark;

    public void copy(Zone source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }

    @Override
    public String toString() {
        return "Zone{" +
                "Id='" + id + '\'' +
                "cname='" + cname + '\'' +
                "parentId='" + parentId + '\'' +
                "ename='" + ename + '\'' +
                "type='" + type + '\'' +
                '}';
    }

}