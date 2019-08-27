package com.alamousse.modules.system.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.system.domain.DictDetail;
import com.alamousse.modules.system.service.dto.DictDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends EntityMapper<DictDetailDTO, DictDetail> {

}