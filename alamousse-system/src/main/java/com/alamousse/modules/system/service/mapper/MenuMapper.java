package com.alamousse.modules.system.service.mapper;

import com.alamousse.modules.system.domain.Menu;
import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.system.service.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author mike
 * @date 2018-12-17
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {

}
