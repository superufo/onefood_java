package com.alamousse.appmodules.shop.service.impl;

import com.alamousse.appmodules.shop.domain.ShopGoods;
import com.alamousse.appmodules.shop.repository.ShopGoodsRepository;
import com.alamousse.appmodules.shop.service.ShopGoodsService;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsDTO;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsQueryCriteria;
import com.alamousse.appmodules.shop.service.mapper.ShopGoodsMapper;
import com.alamousse.utils.PageUtil;
import com.alamousse.utils.QueryHelp;
import com.alamousse.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
* @author jie
* @date 2019-07-20
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShopGoodsServiceImpl implements ShopGoodsService {

    @Autowired
    private ShopGoodsRepository shopGoodsRepository;

    @Autowired
    private ShopGoodsMapper shopGoodsMapper;

    @Override
    public Object queryAll(ShopGoodsQueryCriteria criteria, Pageable pageable){
        Page<ShopGoods> page = shopGoodsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(shopGoodsMapper::toDto));
    }

    @Override
    public Object queryAll(ShopGoodsQueryCriteria criteria){
        return shopGoodsMapper.toDto(shopGoodsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ShopGoodsDTO findById(Integer id) {
        Optional<ShopGoods> shopGoods = shopGoodsRepository.findById(id);
        ValidationUtil.isNull(shopGoods,"ShopGoods","id",id);
        return shopGoodsMapper.toDto(shopGoods.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopGoodsDTO create(ShopGoods resources) {
        //resources.setId(IdUtil.simpleUUID());
        return shopGoodsMapper.toDto(shopGoodsRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ShopGoods resources) {
        Optional<ShopGoods> optionalShopGoods = shopGoodsRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalShopGoods,"ShopGoods","id",resources.getId());
        ShopGoods shopGoods = optionalShopGoods.get();
        shopGoods.copy(resources);
        shopGoodsRepository.save(shopGoods);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        shopGoodsRepository.deleteById(id);
    }

}