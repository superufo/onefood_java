package com.alamousse.modules.market.service;

import com.alamousse.modules.market.domain.AdvCatagrory;
import com.alamousse.modules.market.service.dto.AdvCatagroryDTO;
import com.alamousse.modules.market.service.dto.AdvCatagroryQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author mike
* @date 2019-08-01
*/
//@CacheConfig(cacheNames = "advCatagrory")
public interface AdvCatagroryService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(AdvCatagroryQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AdvCatagroryQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    AdvCatagroryDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    AdvCatagroryDTO create(AdvCatagrory resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(AdvCatagrory resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);
}