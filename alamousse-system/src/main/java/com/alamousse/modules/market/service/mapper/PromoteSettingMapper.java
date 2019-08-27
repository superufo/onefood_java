package com.alamousse.modules.market.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.market.domain.PromoteSetting;
import com.alamousse.modules.market.service.dto.PromoteSettingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-08-01
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PromoteSettingMapper extends EntityMapper<PromoteSettingDTO, PromoteSetting> {

}