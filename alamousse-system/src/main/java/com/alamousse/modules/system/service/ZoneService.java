package com.alamousse.modules.system.service;

import com.alamousse.modules.system.domain.Zone;
import com.alamousse.modules.system.service.dto.ZoneDTO;
import com.alamousse.modules.system.service.dto.ZoneQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author mike
* @date 2019-07-21
*/
@CacheConfig(cacheNames = "zone")
public interface ZoneService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    @Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(ZoneQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ZoneQueryCriteria criteria);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    ZoneDTO create(Zone resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Zone resources);

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    ZoneDTO findById(Integer id);

    /**
     * findByPid
     * @param pid
     * @return
     */
    @Cacheable(key = "'parentId:'+#p0")
    Zone findByParentId(Integer parentId);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Integer id);
}