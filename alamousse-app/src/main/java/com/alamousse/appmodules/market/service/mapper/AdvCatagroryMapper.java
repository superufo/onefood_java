package com.alamousse.appmodules.market.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.appmodules.market.domain.AdvCatagrory;
import com.alamousse.appmodules.market.service.dto.AdvCatagroryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-08-01
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdvCatagroryMapper extends EntityMapper<AdvCatagroryDTO, AdvCatagrory> {

}
