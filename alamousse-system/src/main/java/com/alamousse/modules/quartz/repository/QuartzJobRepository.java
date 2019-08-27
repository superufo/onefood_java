package com.alamousse.modules.quartz.repository;

import com.alamousse.modules.quartz.domain.QuartzJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

/**
 * @author mike
 * @date 2019-01-07
 */
public interface QuartzJobRepository extends JpaRepository<QuartzJob,Long>, JpaSpecificationExecutor {

    /**
     * 查询启用的任务
     * @return
     */
    List<QuartzJob> findByIsPauseIsFalse();
}
