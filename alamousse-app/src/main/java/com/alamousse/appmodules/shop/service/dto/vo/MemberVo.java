package com.alamousse.appmodules.shop.service.dto.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 构建前端路由时用到   NON_EMPTY 属性为 空（“”） 或者为 NULL 都不序列化
 * @author mike
 * @date 2018-12-20
 */
@Data
public class MemberVo implements Serializable {
    // Id

    private Integer mid;

    // 账号
    private String account;
}
