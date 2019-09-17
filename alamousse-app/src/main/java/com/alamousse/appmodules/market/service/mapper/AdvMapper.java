package com.alamousse.appmodules.market.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.appmodules.market.domain.Adv;
import com.alamousse.appmodules.market.service.dto.AdvDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-08-01
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdvMapper extends EntityMapper<AdvDTO, Adv> {

}
