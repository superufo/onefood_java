package com.alamousse.modules.shop.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.shop.domain.Shop;
import com.alamousse.modules.shop.service.dto.ShopDTO;
import com.alamousse.modules.system.service.mapper.ZoneMapper;
import com.alamousse.modules.system.domain.vo.ZoneVo;
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