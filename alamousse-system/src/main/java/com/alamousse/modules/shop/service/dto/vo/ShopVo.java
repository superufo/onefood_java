package com.alamousse.modules.shop.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;

import com.alamousse.modules.system.domain.vo.ZoneVo;

/**
 * @author mike
 * @date 2019-07-20
 */
@Data
public class ShopVo implements Serializable {

    // 店铺Id
    private String id;

    // 店名
    private String name;

    // 英文店名
    private String ename;

    // 店主
    private String owner;

    // logo
    private String logo;

    // 菜肴类型
    private Integer type;

    // 电话号码
    private String telphone;

    // 国家
    private Integer country;

    //省份
    private Integer provice;

    // 状态
    private Integer state;

    // 城市
    private Integer city;

    // 街道
    private Integer street;

    // 详细地址
    private String address;

    // 经度
    private BigDecimal longitude;

    // 纬度
    private BigDecimal latitude;

    // 税收
    private String tax;

    // 营业开始时间
    private String workStart;

    // 营业结束时间
    private String workEnd;

    // 介绍
    private String introduce;

    // 店铺创建时间
    private Timestamp createdAt;

    // 系统创建时间
    private Timestamp createDate;

    // 系统更新时间
    private Timestamp updateAt;

    // 店铺级别
    private Integer datalevel;

    // 父店
    private Integer pid;

    //zone 信息
    private ZoneVo  zonevo;

    @Override
    public String toString() {
        return "ShopDTO{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "ename='" + ename + '\'' +
                "zonevo='" + zonevo + '\'' +
                '}';
    }
}
