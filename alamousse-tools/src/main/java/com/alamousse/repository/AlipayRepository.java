package com.alamousse.repository;

import com.alamousse.domain.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mike
 * @date 2018-12-31
 */
public interface AlipayRepository extends JpaRepository<AlipayConfig,Long> {
}
