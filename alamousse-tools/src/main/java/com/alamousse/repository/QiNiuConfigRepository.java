package com.alamousse.repository;

import com.alamousse.domain.QiniuConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mike
 * @date 2018-12-31
 */
public interface QiNiuConfigRepository extends JpaRepository<QiniuConfig,Long> {
}
