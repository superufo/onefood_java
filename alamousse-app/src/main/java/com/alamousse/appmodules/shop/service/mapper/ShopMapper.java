package com.alamousse.appmodules.shop.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.appmodules.shop.domain.Shop;
import com.alamousse.appmodules.shop.service.dto.ShopDTO;
import com.alamousse.appmodules.system.domain.vo.ZoneVo;
import com.alamousse.appmodules.system.service.mapper.ZoneMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-07-20
*/
@Mapper(componentModel = "spring",uses = {ZoneMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShopMapper extends EntityMapper<ShopDTO, Shop> {
    //@Mapping(source = "ZoneVo", target = "zoneVo")
    ShopDTO toDto(Shop shop, ZoneVo zoneVo);
}