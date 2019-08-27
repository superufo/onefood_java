package com.alamousse.modules.common.repository;

import com.alamousse.modules.common.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mike
 * @date 2018-12-26
 */
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
