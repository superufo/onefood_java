package com.alamousse.appmodules.shop.service.impl;

import com.alamousse.appmodules.shop.domain.ShopGoodsPicture;
import com.alamousse.appmodules.shop.repository.ShopGoodsPictureRepository;
import com.alamousse.appmodules.shop.service.ShopGoodsPictureService;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsPictureDTO;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsPictureQueryCriteria;
import com.alamousse.appmodules.shop.service.mapper.ShopGoodsPictureMapper;
import com.alamousse.utils.PageUtil;
import com.alamousse.utils.QueryHelp;
import com.alamousse.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

/**
* @author mike
* @date 2019-07-30
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShopGoodsPictureServiceImpl implements ShopGoodsPictureService {

    @Autowired
    private ShopGoodsPictureRepository shopGoodsPictureRepository;

    @Autowired
    private ShopGoodsPictureMapper shopGoodsPictureMapper;

    @Override
    public Object queryAll(ShopGoodsPictureQueryCriteria criteria, Pageable pageable){
        Page<ShopGoodsPicture> page = shopGoodsPictureRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(shopGoodsPictureMapper::toDto));
    }

    @Override
    public Object queryAll(ShopGoodsPictureQueryCriteria criteria){
        return shopGoodsPictureMapper.toDto(shopGoodsPictureRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ShopGoodsPictureDTO findById(Long id) {
        Optional<ShopGoodsPicture> shopGoodsPicture = shopGoodsPictureRepository.findById(id);
        ValidationUtil.isNull(shopGoodsPicture,"ShopGoodsPicture","id",id);
        return shopGoodsPictureMapper.toDto(shopGoodsPicture.get());
    }

    @Override
    public ArrayList<String> findPicByGoodsId(Integer GoodsId){
        ArrayList<String> shopGoodsList = (ArrayList<String>)shopGoodsPictureRepository.findPicByGoodsId(GoodsId);
        return shopGoodsList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopGoodsPictureDTO create(ShopGoodsPicture resources) {
        return shopGoodsPictureMapper.toDto(shopGoodsPictureRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ShopGoodsPicture resources) {
        Optional<ShopGoodsPicture> optionalShopGoodsPicture = shopGoodsPictureRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalShopGoodsPicture,"ShopGoodsPicture","id",resources.getId());
        ShopGoodsPicture shopGoodsPicture = optionalShopGoodsPicture.get();
        shopGoodsPicture.copy(resources);
        shopGoodsPictureRepository.save(shopGoodsPicture);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        shopGoodsPictureRepository.deleteById(id);
    }
}
