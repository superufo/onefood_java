package com.alamousse.modules.shop.domain;


import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author mike
* @date 2019-07-20
*/
@Entity
@Data
@Table(name="shop")
public class Shop implements Serializable {

    // 店铺Id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 店名
    @Column(name = "name")
    private String name;

    // 英文店名
    @Column(name = "ename")
    private String ename;

    // 店主
    @Column(name = "owner")
    private String owner;

    // logo
    @Column(name = "logo")
    private String logo;

    // 菜肴类型
    @Column(name = "type")
    private Integer type;

    // 电话号码
    @Column(name = "telphone")
    private String telphone;

    // 国家
    @Column(name = "country")
    private Integer country;

    // 省份
    @Column(name = "provice")
    private Integer provice;

    // 状态
    @Column(name = "state")
    private Integer state;

    // 城市
    @Column(name = "city")
    private Integer city;

    // 街道
    @Column(name = "street")
    private Integer street;

    // 详细地址
    @Column(name = "address")
    private String address;

    // 经度
    @Column(name = "longitude")
    private BigDecimal longitude;

    // 纬度
    @Column(name = "latitude")
    private BigDecimal latitude;

    // 税收
    @Column(name = "tax")
    private String tax;

    // 营业开始时间
    @Column(name = "work_start")
    private String workStart;

    // 营业结束时间
    @Column(name = "work_end")
    private String workEnd;

    // 介绍
    @Column(name = "introduce")
    private String introduce;

    // 店铺创建时间
    @Column(name = "created_at")
    private Timestamp createdAt;

    // 系统创建时间
    @Column(name = "create_date")
    private Timestamp createDate;

    // 系统更新时间
    @Column(name = "update_at")
    private Timestamp updateAt;

    // 店铺级别
    @Column(name = "datalevel")
    private Integer datalevel;

    // 父店
    @Column(name = "pid")
    private Integer pid;

    public void copy(Shop source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}