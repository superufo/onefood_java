package com.alamousse.modules.shop.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.io.Serializable;

/**
* @author mike
* @date 2019-07-25
*/
@Entity
@Data
@Table(name="address")
public class Address implements Serializable {

    // Id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Member Id
    @Column(name = "mid")
    private Integer mid;

    // Country
    @Column(name = "country")
    private Integer country;

    // province
    @Column(name = "province")
    private Integer province;

    // city
    @Column(name = "city")
    private Integer city;

    // region
    @Column(name = "street")
    private Integer street;

    // detail address
    @Column(name = "detail")
    private String detail;

    // is default
    @Column(name = "is_default")
    private Integer isDefault;

    public void copy(Address source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}