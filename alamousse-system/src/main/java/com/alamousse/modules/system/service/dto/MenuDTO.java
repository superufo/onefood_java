package com.alamousse.modules.system.service.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author mike
 * @date 2018-12-17
 */
@Data
public class MenuDTO {

    private Long id;

    private String name;

    private Long sort;

    private Boolean hidden;

    private String path;

    private String component;

    private Long pid;

    private Boolean iFrame;

    private String icon;

    private List<MenuDTO> children;

    private Timestamp createTime;
}
