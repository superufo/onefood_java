package com.alamousse.modules.market.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.market.domain.AdvCatagrory;
import com.alamousse.modules.market.service.dto.AdvCatagroryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-08-01
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdvCatagroryMapper extends EntityMapper<AdvCatagroryDTO, AdvCatagrory> {

}