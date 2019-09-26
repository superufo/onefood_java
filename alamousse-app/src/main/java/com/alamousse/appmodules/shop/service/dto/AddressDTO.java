package com.alamousse.appmodules.shop.service.dto;

import com.alamousse.appmodules.system.domain.vo.ZoneVo;
import lombok.Data;

import java.io.Serializable;


/**
* @author mike
* @date 2019-07-25
*/
@Data
public class AddressDTO implements Serializable {

    // Id
    private Long id;

    // Member Id
    private Integer mid;

    // Country
    private Integer country;

    // province
    private Integer province;

    // city
    private Integer city;

    // region
    private Integer street;

    // detail address
    private String detail;

    // is default
    private Integer isDefault;

    private String  account;

    private ZoneVo zoneVo;

    private String receiverName;

    private String receiverMobile;

    private String addressLabel;

    //private AddressVo addressVo;
}
