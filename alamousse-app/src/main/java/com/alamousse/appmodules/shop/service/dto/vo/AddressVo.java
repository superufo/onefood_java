package com.alamousse.appmodules.shop.service.dto.vo;

import com.alamousse.appmodules.shop.service.dto.MemberDTO;
import com.alamousse.appmodules.system.domain.vo.ZoneVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class AddressVo {
    private ZoneVo zonevo;

    private MemberDTO memberInfo;
}
