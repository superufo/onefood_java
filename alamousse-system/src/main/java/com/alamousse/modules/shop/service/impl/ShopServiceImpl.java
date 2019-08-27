package com.alamousse.modules.shop.service.impl;

import com.alamousse.modules.shop.domain.Shop;
import com.alamousse.modules.shop.repository.ShopRepository;
import com.alamousse.modules.shop.service.ShopService;
import com.alamousse.modules.shop.service.dto.ShopDTO;
import com.alamousse.modules.shop.service.dto.ShopQueryCriteria;
import com.alamousse.modules.system.domain.Zone;
import com.alamousse.modules.system.repository.ZoneRepository;
import com.alamousse.utils.PageUtil;
import com.alamousse.utils.QueryHelp;
import com.alamousse.utils.ValidationUtil;
import com.alamousse.modules.shop.service.mapper.ShopMapper;
import com.alamousse.modules.system.domain.vo.ZoneVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

//import cn.hutool.core.util.IdUtil;

/**
* @author mike
* @date 2019-07-20
*/
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public Object queryAll(ShopQueryCriteria criteria, Pageable pageable){
        Page<Shop> page = shopRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);

        List<Shop> shopList = page.getContent();
        ArrayList<ShopDTO> shops =  addZoneInfo(shopList);

        return PageUtil.toPage(shops,page.getTotalElements());
    }

    @Override
    public List<ShopDTO> queryAll(ShopQueryCriteria criteria){
        List<Shop> shopList = shopRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));

        ArrayList<ShopDTO> shops =  addZoneInfo(shopList);
        return     shops;
        //return shopMapper.toDto(shopRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ShopDTO findById(Integer id) {
        Optional<Shop> shop = shopRepository.findById(id);
        ValidationUtil.isNull(shop,"Shop","id",id);
        return shopMapper.toDto(shop.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopDTO create(Shop resources) {
        //使用uuid
        //resources.setId(IdUtil.simpleUUID());
        return shopMapper.toDto(shopRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Shop resources) {
        Optional<Shop> optionalShop = shopRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalShop,"Shop","id",resources.getId());
        Shop shop = optionalShop.get();
        shop.copy(resources);
        shopRepository.save(shop);
    }

    @Transactional(rollbackFor = Exception.class)
    public ArrayList<ShopDTO> addZoneInfo(List<Shop> shopList) {
        ArrayList<ShopDTO> shops = new ArrayList<>();
        for (Shop shop : shopList) {
            ZoneVo  vo =  new  ZoneVo();

            if ( shop.getCountry() > 0 ) {
               Zone zone = zoneRepository.findNameById(shop.getCountry());

               vo.setCountryId(zone.getId());
               vo.setCountryCname(zone.getCname());
               vo.setCountryName(zone.getEname());
            }

            if ( shop.getProvice() > 0 ) {
                Zone zone  = zoneRepository.findNameById(shop.getProvice());
                vo.setProviceId(zone.getId());
                vo.setProviceCname(zone.getCname());
                vo.setProviceName(zone.getEname());
            }

            if ( shop.getProvice() > 0 ) {
                Zone zone   = zoneRepository.findNameById(shop.getCity());
                vo.setCityId(zone.getId());
                vo.setCityCname(zone.getCname());
                vo.setCityName(zone.getEname());
            }

            if ( shop.getStreet() > 0 ) {
                Zone zone    = zoneRepository.findNameById(shop.getStreet());
                vo.setStreetId(zone.getId());
                vo.setStreetCname(zone.getCname());
                vo.setStreetName(zone.getEname());
            }

            ShopDTO shopDto =  shopMapper.toDto(shop,vo);
            shopDto.setZonevo(vo);

            //System.out.print(shopDto);
            shops.add(shopDto);
        }

        return shops;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        shopRepository.deleteById(id);
    }
}