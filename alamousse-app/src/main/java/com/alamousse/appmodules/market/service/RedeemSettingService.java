package com.alamousse.appmodules.market.service;

import com.alamousse.appmodules.market.domain.RedeemSetting;
import com.alamousse.appmodules.market.service.dto.RedeemSettingDTO;
import com.alamousse.appmodules.market.service.dto.RedeemSettingQueryCriteria;
import org.springframework.data.domain.Pageable;

//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author mike
* @date 2019-08-01
*/
//@CacheConfig(cacheNames = "redeemSetting")
public interface RedeemSettingService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(RedeemSettingQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(RedeemSettingQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    RedeemSettingDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    RedeemSettingDTO create(RedeemSetting resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(RedeemSetting resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);
}
