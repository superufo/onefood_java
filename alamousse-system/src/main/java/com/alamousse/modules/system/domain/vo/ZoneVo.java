package com.alamousse.modules.system.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZoneVo implements Serializable {
//    private ZoneNameVo countryVo;
//
//    private ZoneNameVo proviceVo;
//
//    private ZoneNameVo cityVo;
//
//    private ZoneNameVo streetVo;

    private Integer countryId;

    private String countryCname;

    private String countryName;

    private Integer proviceId;

    private String  proviceCname;

    private String  proviceName;

    private Integer cityId;

    private String  cityCname;

    private String  cityName;

    private Integer streetId;

    private String  streetCname;

    private String  streetName;

    @Override
    public String toString() {
        return "ZoneVo{" +
                "countryId='" + countryId + '\'' +
                "countryCname='" + countryCname + '\'' +
                "countryName='" + countryName + '\'' +
                "proviceId='" + proviceId + '\'' +
                "proviceCname='" + proviceCname + '\'' +
                "proviceName='" + proviceName + '\'' +
                "cityId='" + cityId + '\'' +
                "cityCname='" + cityCname + '\'' +
                "cityName='" + cityName + '\'' +
                "streetId='" + streetId + '\'' +
                "streetCname='" + streetCname + '\'' +
                "streetName='" + streetName + '\'' +
                '}';
    }
}




