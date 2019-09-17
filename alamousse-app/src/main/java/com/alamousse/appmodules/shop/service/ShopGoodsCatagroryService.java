package com.alamousse.appmodules.shop.service;

import com.alamousse.appmodules.shop.domain.ShopGoodsCatagrory;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsCatagroryDTO;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsCatagroryQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
* @author mike
* @date 2019-07-20
*/
//@CacheConfig(cacheNames = "shopGoodsCatagrory")
public interface ShopGoodsCatagroryService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    ////@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(ShopGoodsCatagroryQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    ////@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ShopGoodsCatagroryQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    ShopGoodsCatagroryDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    ShopGoodsCatagroryDTO create(ShopGoodsCatagrory resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(ShopGoodsCatagrory resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);

    /**
     * findByPid
     * @param pid
     * @return
     */
    //@Cacheable(key = "'parentId:'+#p0")
    List<ShopGoodsCatagroryDTO> findByParentId(Integer pid);
}
