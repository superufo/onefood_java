package com.alamousse.modules.market.repository;

import com.alamousse.modules.market.domain.PromoteSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author mike
* @date 2019-08-01
*/
public interface PromoteSettingRepository extends JpaRepository<PromoteSetting, Integer>, JpaSpecificationExecutor {
}