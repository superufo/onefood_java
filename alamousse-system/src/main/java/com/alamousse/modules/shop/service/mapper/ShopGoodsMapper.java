package com.alamousse.modules.shop.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.shop.domain.ShopGoods;
import com.alamousse.modules.shop.service.dto.ShopGoodsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-07-20
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShopGoodsMapper extends EntityMapper<ShopGoodsDTO, ShopGoods> {

}