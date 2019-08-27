package com.alamousse.modules.order.service.mapper;

import com.alamousse.modules.order.service.dto.OrderGoodsDTO;
import com.alamousse.mapper.EntityMapper;
import com.alamousse.modules.order.domain.OrderGoods;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author mike
* @date 2019-07-27
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderGoodsMapper extends EntityMapper<OrderGoodsDTO, OrderGoods> {

}