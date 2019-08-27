package com.alamousse.modules.system.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.system.domain.Dict;
import com.alamousse.modules.system.service.dto.DictDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends EntityMapper<DictDTO, Dict> {

}