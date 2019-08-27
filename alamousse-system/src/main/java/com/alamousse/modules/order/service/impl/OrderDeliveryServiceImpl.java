package com.alamousse.modules.order.service.impl;

import com.alamousse.modules.order.service.dto.OrderDeliveryDTO;
import com.alamousse.modules.order.service.dto.OrderDeliveryQueryCriteria;
import com.alamousse.modules.order.service.mapper.OrderDeliveryMapper;
import com.alamousse.modules.order.domain.OrderDelivery;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.modules.order.repository.OrderDeliveryRepository;
import com.alamousse.modules.order.service.OrderDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.alamousse.utils.PageUtil;
import com.alamousse.utils.QueryHelp;

/**
* @author mike
* @date 2019-07-27
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderDeliveryServiceImpl implements OrderDeliveryService {

    @Autowired
    private OrderDeliveryRepository orderDeliveryRepository;

    @Autowired
    private OrderDeliveryMapper orderDeliveryMapper;

    @Override
    public Object queryAll(OrderDeliveryQueryCriteria criteria, Pageable pageable){
        Page<OrderDelivery> page = orderDeliveryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(orderDeliveryMapper::toDto));
    }

    @Override
    public Object queryAll(OrderDeliveryQueryCriteria criteria){
        return orderDeliveryMapper.toDto(orderDeliveryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public OrderDeliveryDTO findById(String id) {
        Optional<OrderDelivery> orderDelivery = orderDeliveryRepository.findById(id);
        ValidationUtil.isNull(orderDelivery,"OrderDelivery","id",id);
        return orderDeliveryMapper.toDto(orderDelivery.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDeliveryDTO create(OrderDelivery resources) {
        //resources.setId(IdUtil.simpleUUID());
        return orderDeliveryMapper.toDto(orderDeliveryRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(OrderDelivery resources) {
        Optional<OrderDelivery> optionalOrderDelivery = orderDeliveryRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalOrderDelivery,"OrderDelivery","id",resources.getId());
        OrderDelivery orderDelivery = optionalOrderDelivery.get();
        orderDelivery.copy(resources);
        orderDeliveryRepository.save(orderDelivery);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        orderDeliveryRepository.deleteById(id);
    }
}