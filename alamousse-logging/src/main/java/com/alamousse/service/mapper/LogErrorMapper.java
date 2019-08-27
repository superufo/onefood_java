package com.alamousse.service.mapper;

import com.alamousse.domain.Log;
import com.alamousse.mapper.EntityMapper;
import com.alamousse.service.dto.LogErrorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author mike
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogErrorMapper extends EntityMapper<LogErrorDTO, Log> {

}