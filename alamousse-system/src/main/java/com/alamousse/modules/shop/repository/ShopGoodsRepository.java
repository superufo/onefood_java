package com.alamousse.modules.shop.repository;

import com.alamousse.modules.shop.domain.ShopGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author jie
* @date 2019-07-20
*/
public interface ShopGoodsRepository extends JpaRepository<ShopGoods, Integer>, JpaSpecificationExecutor {


}