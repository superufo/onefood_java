package com.alamousse.modules.shop.service;

import com.alamousse.modules.shop.service.dto.ShopDTO;
import com.alamousse.modules.shop.service.dto.ShopQueryCriteria;
import com.alamousse.modules.shop.domain.Shop;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
* @author mike
* @date 2019-07-20
*/
//@CacheConfig(cacheNames = "shop")
public interface ShopService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(ShopQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public List<ShopDTO> queryAll(ShopQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    ShopDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    ShopDTO create(Shop resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(Shop resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);
}