package com.alamousse.modules.system.service.mapper;

import com.alamousse.modules.system.domain.User;
import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.system.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author mike
 * @date 2019-07-23
 */
@Mapper(componentModel = "spring",uses = {RoleMapper.class, DeptMapper.class, JobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
