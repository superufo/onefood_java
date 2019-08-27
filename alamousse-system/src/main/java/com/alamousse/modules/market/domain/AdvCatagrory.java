package com.alamousse.modules.market.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.io.Serializable;

/**
* @author mike
* @date 2019-08-01
*/
@Entity
@Data
@Table(name="adv_catagrory")
public class AdvCatagrory implements Serializable {

    // Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // English Name
    @Column(name = "ename")
    private String ename;

    // Chinese Name
    @Column(name = "cname")
    private String cname;

    // Position
    @Column(name = "position")
    private Integer position;

    // Shop Id
    @Column(name = "shop_id")
    private Integer shopId;

    // Width
    @Column(name = "wide")
    private Integer wide;

    // Length
    @Column(name = "length")
    private Integer length;

    // Remark
    @Column(name = "remark")
    private String remark;

    public void copy(AdvCatagrory source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}