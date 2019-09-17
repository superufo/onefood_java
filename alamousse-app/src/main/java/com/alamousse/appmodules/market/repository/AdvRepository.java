package com.alamousse.appmodules.market.repository;

import com.alamousse.appmodules.market.domain.Adv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author mike
* @date 2019-08-01
*/
public interface AdvRepository extends JpaRepository<Adv, Integer>, JpaSpecificationExecutor {
}
