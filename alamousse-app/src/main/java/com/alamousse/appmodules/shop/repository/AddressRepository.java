package com.alamousse.appmodules.shop.repository;

import com.alamousse.appmodules.shop.domain.Address;
import com.alamousse.appmodules.shop.service.dto.AddressDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

/**
* @author mike
* @date 2019-07-25
*/
public interface AddressRepository extends JpaRepository<Address, Long>, JpaSpecificationExecutor {

    @Query(value = "select *  from address where mid = ?1",nativeQuery = true)
    ArrayList<Address> findInfoByMid(Integer mid);

    @Query(value = "select *  from address where is_default=1 And  mid = ?1  limit 1",nativeQuery = true)
    Address findDefaultByMid(Integer mid);

}
