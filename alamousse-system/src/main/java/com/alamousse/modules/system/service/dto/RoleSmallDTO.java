package com.alamousse.modules.system.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author mike
 * @date 2019-07-23
 */
@Data
public class RoleSmallDTO implements Serializable {

    private Long id;

    private String name;

    private Integer level;

    private String dataScope;
}
