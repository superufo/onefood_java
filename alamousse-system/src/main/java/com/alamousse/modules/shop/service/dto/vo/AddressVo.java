package com.alamousse.modules.shop.service.dto.vo;

import com.alamousse.modules.shop.service.dto.MemberDTO;
import com.alamousse.modules.system.domain.vo.ZoneVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class AddressVo {
    private ZoneVo zonevo;

    private MemberDTO memberInfo;
}
