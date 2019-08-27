package com.alamousse.modules.system.service.mapper;

import com.alamousse.modules.system.domain.Permission;
import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.system.service.dto.PermissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author mike
 * @date 2019-07-23
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {

}
