package com.alamousse.modules.market.service;

import com.alamousse.modules.market.domain.PromoteGoods;
import com.alamousse.modules.market.service.dto.PromoteGoodsDTO;
import com.alamousse.modules.market.service.dto.PromoteGoodsQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author mike
* @date 2019-08-01
*/
//@CacheConfig(cacheNames = "promoteGoods")
public interface PromoteGoodsService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(PromoteGoodsQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(PromoteGoodsQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    PromoteGoodsDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    PromoteGoodsDTO create(PromoteGoods resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(PromoteGoods resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);
}