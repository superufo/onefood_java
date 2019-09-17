package com.alamousse.appmodules.market.service;

import com.alamousse.appmodules.market.domain.PromoteCode;
import com.alamousse.appmodules.market.service.dto.PromoteCodeDTO;
import com.alamousse.appmodules.market.service.dto.PromoteCodeQueryCriteria;
import org.springframework.data.domain.Pageable;

//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author mike
* @date 2019-08-01
*/
//@CacheConfig(cacheNames = "promoteCode")
public interface PromoteCodeService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(PromoteCodeQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(PromoteCodeQueryCriteria criteria);

    /**
     * findById
     * @param code
     * @return
     */
    //@Cacheable(key = "#p0")
    PromoteCodeDTO findById(String code);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    PromoteCodeDTO create(PromoteCode resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(PromoteCode resources);

    /**
     * delete
     * @param code
     */
    //@CacheEvict(allEntries = true)
    void delete(String code);
}
