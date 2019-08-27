package com.alamousse.modules.market.repository;

import com.alamousse.modules.market.domain.RedeemPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author mike
* @date 2019-08-01
*/
public interface RedeemPointRepository extends JpaRepository<RedeemPoint, String>, JpaSpecificationExecutor {
}