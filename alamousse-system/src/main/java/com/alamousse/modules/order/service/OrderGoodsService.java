package com.alamousse.modules.order.service;

import com.alamousse.modules.order.service.dto.OrderGoodsDTO;
import com.alamousse.modules.order.service.dto.OrderGoodsQueryCriteria;
import com.alamousse.modules.order.domain.OrderGoods;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author mike
* @date 2019-07-27
*/
//@CacheConfig(cacheNames = "orderGoods")
public interface OrderGoodsService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(OrderGoodsQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(OrderGoodsQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    OrderGoodsDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    OrderGoodsDTO create(OrderGoods resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(OrderGoods resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);
}