package com.alamousse.modules.system.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.system.domain.Job;
import com.alamousse.modules.system.service.dto.JobSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobSmallMapper extends EntityMapper<JobSmallDTO, Job> {

}