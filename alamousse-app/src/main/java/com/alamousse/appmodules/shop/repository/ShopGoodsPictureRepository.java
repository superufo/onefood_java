package com.alamousse.appmodules.shop.repository;

import com.alamousse.appmodules.shop.domain.ShopGoodsPicture;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsCatagroryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
* @author mike
* @date 2019-07-30
*/
public interface ShopGoodsPictureRepository extends JpaRepository<ShopGoodsPicture, Long>, JpaSpecificationExecutor {
    @Query(value = "select url  from shop_goods_picture where goods_id = ?1",nativeQuery = true)
    List<String> findPicByGoodsId(Integer GoodsId);

}
