package com.alamousse.modules.shop.service;

import com.alamousse.modules.shop.service.dto.ShopGoodsPictureDTO;
import com.alamousse.modules.shop.domain.ShopGoodsPicture;
import com.alamousse.modules.shop.service.dto.ShopGoodsPictureQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author mike
* @date 2019-07-30
*/
//@CacheConfig(cacheNames = "shopGoodsPicture")
public interface ShopGoodsPictureService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(ShopGoodsPictureQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ShopGoodsPictureQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    ShopGoodsPictureDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    ShopGoodsPictureDTO create(ShopGoodsPicture resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(ShopGoodsPicture resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Long id);
}