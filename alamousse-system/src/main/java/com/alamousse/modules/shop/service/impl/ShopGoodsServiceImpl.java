package com.alamousse.modules.shop.service.impl;

import com.alamousse.modules.shop.domain.Shop;
import com.alamousse.modules.shop.domain.ShopGoods;
import com.alamousse.modules.shop.domain.ShopGoodsCatagrory;
import com.alamousse.modules.shop.repository.ShopGoodsPictureRepository;
import com.alamousse.modules.shop.repository.ShopGoodsRepository;
import com.alamousse.modules.shop.service.ShopGoodsService;
import com.alamousse.modules.shop.service.dto.ShopGoodsCatagroryDTO;
import com.alamousse.modules.shop.service.dto.ShopGoodsDTO;
import com.alamousse.modules.shop.service.mapper.ShopGoodsMapper;
import com.alamousse.utils.PageUtil;
import com.alamousse.utils.QueryHelp;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.modules.shop.service.dto.ShopGoodsQueryCriteria;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import com.alamousse.modules.shop.service.ShopService;
import com.alamousse.modules.shop.service.ShopGoodsCatagroryService;
import com.alamousse.modules.shop.service.dto.ShopDTO;
import  com.alamousse.modules.shop.service.mapper.ShopMapper;
import  com.alamousse.modules.shop.service.mapper.ShopGoodsCatagroryMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private ShopGoodsPictureRepository shopGoodsPictureRepository;

    @Autowired
    private ShopGoodsCatagroryMapper shopGoodsCatagroryMapper;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopGoodsCatagroryService shopGoodsCatagroryService;

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
    public ShopGoodsDTO create(ShopGoodsDTO resources) {
        //resources.setId(IdUtil.simpleUUID());
        //shopService.findById() new  ShopGoods();

        ShopDTO  shopDTO = shopService.findById(resources.getShopId());
        Shop shop =  shopMapper.toEntity(shopDTO);

        ShopGoodsCatagroryDTO shopGoodsCatagroryDTO =  shopGoodsCatagroryService.findById(resources.getCatagroryId());
        ShopGoodsCatagrory shopGoodsCatagrory = shopGoodsCatagroryMapper.toEntity(shopGoodsCatagroryDTO);

        ShopGoods   shopGoods = shopGoodsMapper.toEntity(resources);
        shopGoods.setGoodsCatagrory(shopGoodsCatagrory);
        shopGoods.setShop(shop);

        System.out.print(JSON.toJSONString(shopGoods));
        return shopGoodsMapper.toDto(shopGoodsRepository.save(shopGoods));
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
        //删除
        shopGoodsPictureRepository.deleteByGoodsId(id);

        shopGoodsRepository.deleteById(id);
    }

}
