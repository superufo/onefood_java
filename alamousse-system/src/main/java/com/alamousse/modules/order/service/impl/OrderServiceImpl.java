package com.alamousse.modules.order.service.impl;

import com.alamousse.modules.order.service.dto.OrderDTO;
import com.alamousse.modules.order.service.dto.OrderQueryCriteria;
import com.alamousse.modules.order.service.mapper.OrderMapper;
import com.alamousse.modules.order.domain.Order;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.modules.order.repository.OrderRepository;
import com.alamousse.modules.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import cn.hutool.core.util.IdUtil;
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
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Object queryAll(OrderQueryCriteria criteria, Pageable pageable){
        Page<Order> page = orderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(orderMapper::toDto));
    }

    @Override
    public Object queryAll(OrderQueryCriteria criteria){
        return orderMapper.toDto(orderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public OrderDTO findById(String id) {
        Optional<Order> order = orderRepository.findById(id);
        ValidationUtil.isNull(order,"Order","id",id);
        return orderMapper.toDto(order.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDTO create(Order resources) {
        resources.setId(IdUtil.simpleUUID()); 
        return orderMapper.toDto(orderRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Order resources) {
        Optional<Order> optionalOrder = orderRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalOrder,"Order","id",resources.getId());
        Order order = optionalOrder.get();
        order.copy(resources);
        orderRepository.save(order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        orderRepository.deleteById(id);
    }
}