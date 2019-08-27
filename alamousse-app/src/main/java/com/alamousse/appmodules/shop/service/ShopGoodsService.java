package com.alamousse.appmodules.shop.service;

import com.alamousse.appmodules.shop.domain.ShopGoods;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsDTO;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsQueryCriteria;
import org.springframework.data.domain.Pageable;

//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author jie
* @date 2019-07-20
*/
//@CacheConfig(cacheNames = "shopGoods")
public interface ShopGoodsService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(ShopGoodsQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ShopGoodsQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    ShopGoodsDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    ShopGoodsDTO create(ShopGoods resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(ShopGoods resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);
}