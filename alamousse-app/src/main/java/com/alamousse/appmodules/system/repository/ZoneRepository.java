package com.alamousse.appmodules.system.repository;

import com.alamousse.appmodules.system.domain.Zone;
import com.alamousse.appmodules.system.domain.vo.ZoneNameVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

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