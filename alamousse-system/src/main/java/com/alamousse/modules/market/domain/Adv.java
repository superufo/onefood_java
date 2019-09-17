package com.alamousse.modules.market.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author mike
* @date 2019-08-01
*/
@Entity
@Data
@Table(name="adv")
public class Adv implements Serializable {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // Shop Id
    @Column(name = "shop_id")
    private Integer shopId;

    // Category
    @Column(name = "category")
    private Integer category;

    // Title
    @Column(name = "title")
    private String title;

    // Content
    @Column(name = "content")
    private String content;

    // PIcture
    @Column(name = "pic")
    private String pic;

    // Link
    @Column(name = "link")
    private String link;

    // remark
    @Column(name = "remark")
    private String remark;

    // Start Time
    @Column(name = "start_time")
    private Timestamp startTime;

    // End Time
    @Column(name = "end_time")
    private Timestamp endTime;

    public void copy(Adv source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
