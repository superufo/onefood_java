package com.alamousse.modules.system.service.mapper;

import com.alamousse.modules.system.service.dto.ZoneSmallDTO;
import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.system.domain.Zone;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author mike
 * @date 2019-07-21
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ZoneSmallMapper extends EntityMapper<ZoneSmallDTO, Zone> {

}