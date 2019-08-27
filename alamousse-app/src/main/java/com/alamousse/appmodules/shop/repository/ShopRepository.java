package com.alamousse.appmodules.shop.repository;

import com.alamousse.appmodules.shop.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
* @author mike
* @date 2019-07-20
*/
public interface ShopRepository extends JpaRepository<Shop, Integer>, JpaSpecificationExecutor {

    @Query(value = "select name from shop where id = ?1",nativeQuery = true)
    String findNameById(Integer id);


}