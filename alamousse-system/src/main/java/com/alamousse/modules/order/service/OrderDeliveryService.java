package com.alamousse.modules.order.service;

import com.alamousse.modules.order.service.dto.OrderDeliveryDTO;
import com.alamousse.modules.order.service.dto.OrderDeliveryQueryCriteria;
import com.alamousse.modules.order.domain.OrderDelivery;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author mike
* @date 2019-07-27
*/
//@CacheConfig(cacheNames = "orderDelivery")
public interface OrderDeliveryService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(OrderDeliveryQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(OrderDeliveryQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    OrderDeliveryDTO findById(String id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    OrderDeliveryDTO create(OrderDelivery resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(OrderDelivery resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(String id);
}