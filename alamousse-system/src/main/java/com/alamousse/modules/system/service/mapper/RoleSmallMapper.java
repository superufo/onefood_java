package com.alamousse.modules.system.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.system.domain.Role;
import com.alamousse.modules.system.service.dto.RoleSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author mike
 * @date 2019-5-23
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleSmallMapper extends EntityMapper<RoleSmallDTO, Role> {

}
