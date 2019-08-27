package com.alamousse.appmodules.shop.service.mapper;

import com.alamousse.mapper.EntityMapper;
import com.alamousse.appmodules.shop.domain.ShopGoodsCatagrory;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsCatagroryDTO;
import com.alamousse.appmodules.shop.service.dto.vo.ShopGoodsCatagroryVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

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