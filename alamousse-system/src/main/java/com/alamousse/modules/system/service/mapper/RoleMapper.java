package com.alamousse.modules.system.service.mapper;

import com.alamousse.modules.system.domain.Role;
import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.system.service.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author mike
 * @date 2019-07-23
 */
@Mapper(componentModel = "spring", uses = {PermissionMapper.class, MenuMapper.class, DeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {

}
