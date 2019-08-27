package com.alamousse.modules.shop.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.io.Serializable;

/**
* @author mike
* @date 2019-07-20
*/
@Entity
@Data
@Table(name="shop_goods_catagrory")
public class ShopGoodsCatagrory implements Serializable {

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // 父ID
    @Column(name = "parent_id")
    private Integer parentId;

//    // 父ID
//    @OneToOne
//    @JoinColumn(name = "parent_id")
//    @org.hibernate.annotations.ForeignKey(name = "none")
//    private ShopGoodsCatagrory goodsCatagrory;

    // 中文名称
    @Column(name = "cname")
    private String cname;

    // 英文名称
    @Column(name = "ename")
    private String ename;

    // 备注
    @Column(name = "remark")
    private String remark;

    public void copy(ShopGoodsCatagrory source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}