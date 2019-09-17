package com.alamousse.appmodules.market.domain;

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
@Table(name="promote_goods")
public class PromoteGoods implements Serializable {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // Promote Id
    @Column(name = "promote_id")
    private Integer promoteId;

    // Goods Id
    @Column(name = "goods_id")
    private Integer goodsId;

    // Promote Ename
    @Column(name = "promote_ename")
    private String promoteEname;

    // Promote Cname
    @Column(name = "promote_cname")
    private String promoteCname;

    // Goods Ename
    @Column(name = "goods_ename")
    private String goodsEname;

    // Goods Cname
    @Column(name = "goods_cname")
    private String goodsCname;

    public void copy(PromoteGoods source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
