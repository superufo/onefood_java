package com.alamousse.modules.shop.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.shop.service.dto.ShopGoodsCatagroryDTO;
import com.alamousse.modules.shop.domain.ShopGoodsCatagrory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.alamousse.modules.shop.service.dto.vo.ShopGoodsCatagroryVo;

/**
* @author mike
* @date 2019-07-20
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShopGoodsCatagroryMapper extends EntityMapper<ShopGoodsCatagroryDTO, ShopGoodsCatagrory> {
    /*@Mapping(source = "pname", target = "pname")
    ShopGoodsCatagroryDTO toDto(ShopGoodsCatagrory shopGoodsCatagrory,String pname);*/

    ShopGoodsCatagroryDTO toDto(ShopGoodsCatagrory shopGoodsCatagrory, ShopGoodsCatagroryVo shopGoodsCatagroryVo);

}