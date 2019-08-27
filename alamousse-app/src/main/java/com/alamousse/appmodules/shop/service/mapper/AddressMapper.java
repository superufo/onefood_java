package com.alamousse.appmodules.shop.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.appmodules.shop.domain.Address;
import com.alamousse.appmodules.shop.service.dto.AddressDTO;
import com.alamousse.appmodules.shop.service.dto.MemberDTO;
import com.alamousse.appmodules.system.domain.vo.ZoneVo;
import com.alamousse.appmodules.system.service.mapper.ZoneMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-07-25
*/
@Mapper(componentModel = "spring",uses = {ZoneMapper.class, MemberDTO.class, MemberMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
    AddressDTO toDto(Address address, ZoneVo zoneVo);
    AddressDTO toDto(Address address, String account, ZoneVo zoneVo);
}