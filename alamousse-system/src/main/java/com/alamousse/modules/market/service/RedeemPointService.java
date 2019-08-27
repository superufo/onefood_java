package com.alamousse.modules.market.service;

import com.alamousse.modules.market.domain.RedeemPoint;
import com.alamousse.modules.market.service.dto.RedeemPointDTO;
import com.alamousse.modules.market.service.dto.RedeemPointQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author mike
* @date 2019-08-01
*/
//@CacheConfig(cacheNames = "redeemPoint")
public interface RedeemPointService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(RedeemPointQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(RedeemPointQueryCriteria criteria);

    /**
     * findById
     * @param code
     * @return
     */
    //@Cacheable(key = "#p0")
    RedeemPointDTO findById(String code);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    RedeemPointDTO create(RedeemPoint resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(RedeemPoint resources);

    /**
     * delete
     * @param code
     */
    //@CacheEvict(allEntries = true)
    void delete(String code);
}