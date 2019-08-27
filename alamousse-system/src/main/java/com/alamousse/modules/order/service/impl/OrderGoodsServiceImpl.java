package com.alamousse.modules.order.service.impl;

import com.alamousse.modules.order.service.dto.OrderGoodsDTO;
import com.alamousse.modules.order.service.dto.OrderGoodsQueryCriteria;
import com.alamousse.modules.order.service.mapper.OrderGoodsMapper;
import com.alamousse.modules.order.domain.OrderGoods;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.modules.order.repository.OrderGoodsRepository;
import com.alamousse.modules.order.service.OrderGoodsService;
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
public class OrderGoodsServiceImpl implements OrderGoodsService {

    @Autowired
    private OrderGoodsRepository orderGoodsRepository;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Override
    public Object queryAll(OrderGoodsQueryCriteria criteria, Pageable pageable){
        Page<OrderGoods> page = orderGoodsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(orderGoodsMapper::toDto));
    }

    @Override
    public Object queryAll(OrderGoodsQueryCriteria criteria){
        return orderGoodsMapper.toDto(orderGoodsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public OrderGoodsDTO findById(Integer id) {
        Optional<OrderGoods> orderGoods = orderGoodsRepository.findById(id);
        ValidationUtil.isNull(orderGoods,"OrderGoods","id",id);
        return orderGoodsMapper.toDto(orderGoods.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderGoodsDTO create(OrderGoods resources) {
        return orderGoodsMapper.toDto(orderGoodsRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(OrderGoods resources) {
        Optional<OrderGoods> optionalOrderGoods = orderGoodsRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalOrderGoods,"OrderGoods","id",resources.getId());
        OrderGoods orderGoods = optionalOrderGoods.get();
        orderGoods.copy(resources);
        orderGoodsRepository.save(orderGoods);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        orderGoodsRepository.deleteById(id);
    }
}