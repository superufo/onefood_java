package com.alamousse.modules.order.repository;

import com.alamousse.modules.order.domain.OrderGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author mike
* @date 2019-07-27
*/
public interface OrderGoodsRepository extends JpaRepository<OrderGoods, Integer>, JpaSpecificationExecutor {
}