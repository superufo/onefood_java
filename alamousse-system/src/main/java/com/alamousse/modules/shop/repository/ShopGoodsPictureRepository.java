package com.alamousse.modules.shop.repository;

import com.alamousse.modules.shop.domain.ShopGoodsPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
* @author mike
* @date 2019-07-30
*/
public interface ShopGoodsPictureRepository extends JpaRepository<ShopGoodsPicture, Long>, JpaSpecificationExecutor {

    @Query(value = "delete  from shop_goods_picture where goods_id = ?1 ", nativeQuery = true)
    void deleteByGoodsId(Integer goodsId);
}
