package com.alamousse.modules.system.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZoneNameVo implements Serializable {
    private Integer  id;

    private String  cname;

    private String  ename;

    @Override
    public String toString() {
        return "ZoneNameVo{" +
                "id='" + id + '\'' +
                "cname='" + cname + '\'' +
                "ename='" + ename + '\'' +
                '}';
    }

}