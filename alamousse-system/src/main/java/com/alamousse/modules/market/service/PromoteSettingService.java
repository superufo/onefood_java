package com.alamousse.modules.market.service;

import com.alamousse.modules.market.domain.PromoteSetting;
import com.alamousse.modules.market.service.dto.PromoteSettingDTO;
import com.alamousse.modules.market.service.dto.PromoteSettingQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author mike
* @date 2019-08-01
*/
//@CacheConfig(cacheNames = "promoteSetting")
public interface PromoteSettingService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(PromoteSettingQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(PromoteSettingQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    PromoteSettingDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    PromoteSettingDTO create(PromoteSetting resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(PromoteSetting resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);
}