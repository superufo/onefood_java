package com.alamousse.modules.system.repository;

import com.alamousse.modules.system.domain.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.alamousse.modules.system.domain.vo.ZoneNameVo;

/**
* @author mike
* @date 2019-07-21
*/
public interface ZoneRepository extends JpaRepository<Zone, Integer>, JpaSpecificationExecutor {

   @Query(value = "select id,cname,ename from zone where id = ?1",nativeQuery = true)
   ZoneNameVo findEnameById(Integer id);

   Zone findNameById(Integer id);

    /**
     * findByPid
     * @param pid
     * @return
     */
   @Query(value = "select *  from zone where parent_id = ?1  Limit 1",nativeQuery = true)
   Zone findByParentId(Integer parentId);
}