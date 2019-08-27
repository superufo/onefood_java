package com.alamousse.appmodules.shop.service.impl;

import com.alamousse.appmodules.shop.domain.ShopGoodsCatagrory;
import com.alamousse.appmodules.shop.repository.ShopGoodsCatagroryRepository;
import com.alamousse.appmodules.shop.service.ShopGoodsCatagroryService;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsCatagroryDTO;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsCatagroryQueryCriteria;
import com.alamousse.appmodules.shop.service.dto.vo.ShopGoodsCatagroryVo;
import com.alamousse.appmodules.shop.service.mapper.ShopGoodsCatagroryMapper;
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
import java.util.List;
import java.util.Optional;

/**
* @author mike
* @date 2019-07-20
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShopGoodsCatagroryServiceImpl implements ShopGoodsCatagroryService {

    @Autowired
    private ShopGoodsCatagroryRepository shopGoodsCatagroryRepository;

    @Autowired
    private ShopGoodsCatagroryMapper shopGoodsCatagroryMapper;

    @Override
    public Object queryAll(ShopGoodsCatagroryQueryCriteria criteria, Pageable pageable){
        Page<ShopGoodsCatagrory> page = shopGoodsCatagroryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        List<ShopGoodsCatagroryDTO> shopGoodsCatagrorys = new ArrayList<>();

        for (ShopGoodsCatagrory shopGoodsCatagrory : page.getContent()) {
            ShopGoodsCatagroryVo  vo =  new  ShopGoodsCatagroryVo();
            String pcname  = shopGoodsCatagroryRepository.findCnameById(shopGoodsCatagrory.getParentId());
            vo.setPcname(pcname);
            String pname  = shopGoodsCatagroryRepository.findEnameById(shopGoodsCatagrory.getParentId());
            vo.setPname(pname);

            shopGoodsCatagrorys.add(shopGoodsCatagroryMapper.toDto(shopGoodsCatagrory,vo));
        }
        return PageUtil.toPage(shopGoodsCatagrorys,page.getTotalElements());
    }

    @Override
    public Object queryAll(ShopGoodsCatagroryQueryCriteria criteria){
        List<ShopGoodsCatagrory> page = shopGoodsCatagroryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));
        List<ShopGoodsCatagroryDTO> shopGoodsCatagrorys = new ArrayList<>();
        //添加子查询  JPA shopGoodsCatagroryRepository.findCnameById-
        for (ShopGoodsCatagrory shopGoodsCatagrory : page) {
            ShopGoodsCatagroryVo  vo ;
            vo =  new  ShopGoodsCatagroryVo();
            String pcname  = shopGoodsCatagroryRepository.findCnameById(shopGoodsCatagrory.getParentId());
            vo.setPcname(pcname);
            String pname  = shopGoodsCatagroryRepository.findEnameById(shopGoodsCatagrory.getParentId());
            vo.setPname(pname);
            shopGoodsCatagrorys.add(shopGoodsCatagroryMapper.toDto(shopGoodsCatagrory,vo));
        }
        return     shopGoodsCatagrorys;
    }

    @Override
    public ShopGoodsCatagroryDTO findById(Integer id) {
        Optional<ShopGoodsCatagrory> shopGoodsCatagrory = shopGoodsCatagroryRepository.findById(id);
        ValidationUtil.isNull(shopGoodsCatagrory,"ShopGoodsCatagrory","id",id);
        return shopGoodsCatagroryMapper.toDto(shopGoodsCatagrory.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopGoodsCatagroryDTO create(ShopGoodsCatagrory resources) {
        return shopGoodsCatagroryMapper.toDto(shopGoodsCatagroryRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ShopGoodsCatagrory resources) {
        Optional<ShopGoodsCatagrory> optionalShopGoodsCatagrory = shopGoodsCatagroryRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalShopGoodsCatagrory,"ShopGoodsCatagrory","id",resources.getId());
        ShopGoodsCatagrory shopGoodsCatagrory = optionalShopGoodsCatagrory.get();
        shopGoodsCatagrory.copy(resources);
        shopGoodsCatagroryRepository.save(shopGoodsCatagrory);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        shopGoodsCatagroryRepository.deleteById(id);
    }

    @Override
    public List<ShopGoodsCatagroryDTO> findByParentId(Integer parentId) {
        return shopGoodsCatagroryRepository.findByParentId(parentId);
    }
}