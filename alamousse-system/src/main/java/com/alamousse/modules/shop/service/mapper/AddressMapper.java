package com.alamousse.modules.shop.service.mapper;

import com.alamousse.modules.shop.service.dto.AddressDTO;
import com.alamousse.modules.system.service.mapper.ZoneMapper;
import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.shop.domain.Address;
import com.alamousse.modules.shop.service.dto.MemberDTO;

import com.alamousse.modules.system.domain.vo.ZoneVo;

import org.mapstruct.Mapper;

import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-07-25
*/
@Mapper(componentModel = "spring",uses = {ZoneMapper.class, MemberDTO.class, MemberMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
    AddressDTO toDto(Address address, ZoneVo zoneVo);
    AddressDTO toDto(Address address, String account,ZoneVo zoneVo);
}