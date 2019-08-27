package com.alamousse.modules.order.repository;

import com.alamousse.modules.order.domain.OrderDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author mike
* @date 2019-07-27
*/
public interface OrderDeliveryRepository extends JpaRepository<OrderDelivery, String>, JpaSpecificationExecutor {
}