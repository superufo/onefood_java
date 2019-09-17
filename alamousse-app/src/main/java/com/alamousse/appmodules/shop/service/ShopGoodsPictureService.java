package com.alamousse.appmodules.shop.service;

import com.alamousse.appmodules.shop.domain.ShopGoodsPicture;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsPictureDTO;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsPictureQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

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


    List<String> findPicByGoodsId(Integer GoodsId);

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
