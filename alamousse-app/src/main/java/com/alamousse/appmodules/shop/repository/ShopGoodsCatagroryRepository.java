package com.alamousse.appmodules.shop.repository;

import com.alamousse.appmodules.shop.domain.ShopGoodsCatagrory;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsCatagroryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
* @author mike
* @date 2019-07-20
*/
public interface ShopGoodsCatagroryRepository extends JpaRepository<ShopGoodsCatagrory, Integer>, JpaSpecificationExecutor {


    @Query(value = "select ename from shop_goods_catagrory where id = ?1",nativeQuery = true)
    String findEnameById(Integer id);

    @Query(value = "select cname from shop_goods_catagrory where id = ?1",nativeQuery = true)
    String findCnameById(Integer id);

    /**
     * findByPid
     * @param pid
     * @return
     */
    List<ShopGoodsCatagroryDTO> findByParentId(Integer parentId);

}