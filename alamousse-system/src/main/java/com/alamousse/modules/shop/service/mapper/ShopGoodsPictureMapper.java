package com.alamousse.modules.shop.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.shop.domain.ShopGoodsPicture;
import com.alamousse.modules.shop.service.dto.ShopGoodsPictureDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-07-30
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShopGoodsPictureMapper extends EntityMapper<ShopGoodsPictureDTO, ShopGoodsPicture> {

}