package com.alamousse.modules.shop.repository;

import com.alamousse.modules.shop.domain.ShopGoodsPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author mike
* @date 2019-07-30
*/
public interface ShopGoodsPictureRepository extends JpaRepository<ShopGoodsPicture, Long>, JpaSpecificationExecutor {
}