package com.alamousse.appmodules.system.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.appmodules.system.domain.Zone;
import com.alamousse.appmodules.system.domain.vo.ZoneVo;
import com.alamousse.appmodules.system.service.dto.ZoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-07-21
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ZoneMapper extends EntityMapper<ZoneDTO, Zone> {

    ZoneDTO toDto(Zone zone, ZoneVo zoneVo);
}