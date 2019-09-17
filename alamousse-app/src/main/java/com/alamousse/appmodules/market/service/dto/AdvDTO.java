package com.alamousse.appmodules.market.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author mike
* @date 2019-08-01
*/
@Data
public class AdvDTO implements Serializable {

    // ID
    private Integer id;

    // Shop Id
    private Integer shopId;

    // Category
    private Integer category;

    // Title
    private String title;

    // Content
    private String content;

    // PIcture
    private String pic;

    // Link
    private String link;

    // remark
    private String remark;

    // Start Time
    private Timestamp startTime;

    // End Time
    private Timestamp endTime;
}
