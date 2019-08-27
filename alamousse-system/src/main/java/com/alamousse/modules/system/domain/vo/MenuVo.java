package com.alamousse.modules.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 构建前端路由时用到   NON_EMPTY 属性为 空（“”） 或者为 NULL 都不序列化
 * @author mike
 * @date 2018-12-20
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuVo implements Serializable {

    private String name;

    private String path;

    private String redirect;

    private String component;

    private Boolean alwaysShow;

    private MenuMetaVo meta;

    private Boolean hidden;

    private List<MenuVo> children;
}
