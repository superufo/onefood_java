package com.alamousse.modules.shop.repository;

import com.alamousse.modules.shop.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author mike
* @date 2019-07-25
*/
public interface AddressRepository extends JpaRepository<Address, Long>, JpaSpecificationExecutor {

}