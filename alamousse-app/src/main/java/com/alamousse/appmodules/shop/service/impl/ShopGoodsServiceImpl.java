package com.alamousse.appmodules.shop.service.impl;

import com.alamousse.appmodules.shop.domain.ShopGoods;
import com.alamousse.appmodules.shop.repository.ShopGoodsRepository;
import com.alamousse.appmodules.shop.service.ShopGoodsPictureService;
import com.alamousse.appmodules.shop.service.ShopGoodsService;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsDTO;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsQueryCriteria;
import com.alamousse.appmodules.shop.service.dto.vo.ShopGoodsCatagroryVo;
import com.alamousse.appmodules.shop.service.mapper.ShopGoodsMapper;
import com.alamousse.utils.PageUtil;
import com.alamousse.utils.QueryHelp;
import com.alamousse.utils.ValidationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
    private ShopGoodsPictureService shopGoodsPictureService;

    @Autowired
    private ShopGoodsMapper shopGoodsMapper;

    @Override
    public Object queryAll(ShopGoodsQueryCriteria criteria, Pageable pageable){
        Page<ShopGoods> page = shopGoodsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);

        List<ShopGoodsDTO> pageRes = new ArrayList<ShopGoodsDTO> ();
        for (ShopGoods it : page) {
            ShopGoodsDTO sgDto =  new  ShopGoodsDTO();
            Integer goodsId = (Integer)it.getId();
            ArrayList<String> goodsPics =  (ArrayList<String>) shopGoodsPictureService.findPicByGoodsId(goodsId);

            //对象 it 属性赋值给 对象 sgDto
            BeanUtils.copyProperties(it,sgDto);
            sgDto.setGoodsPics(goodsPics);

            pageRes.add(sgDto);
        }

        return PageUtil.toPage(pageRes,page.getTotalElements());
        //return PageUtil.toPage(page.map(shopGoodsMapper::toDto));
    }

    @Override
    public Object queryAll(ShopGoodsQueryCriteria criteria){
        List<ShopGoods>  res =  shopGoodsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));

        List<ShopGoodsDTO> listRes = new ArrayList<ShopGoodsDTO> ();
        for ( ShopGoods itq : res) {
            ShopGoodsDTO sgsDto =  new  ShopGoodsDTO();

            System.out.print(itq.getId());
            ArrayList<String> goodsPics =  (ArrayList<String>) shopGoodsPictureService.findPicByGoodsId( (Integer)itq.getId() );

            //对象 it 属性赋值给 对象 sgDto
            BeanUtils.copyProperties(itq,sgsDto);
            sgsDto.setGoodsPics(goodsPics);

            listRes.add(sgsDto);
        }

        return listRes;
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
