package com.alamousse.modules.quartz.repository;

import com.alamousse.modules.quartz.domain.QuartzLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author mike
 * @date 2019-01-07
 */
public interface QuartzLogRepository extends JpaRepository<QuartzLog,Long>, JpaSpecificationExecutor {

}
