package com.alamousse.modules.shop.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.shop.domain.Address;
import com.alamousse.modules.shop.service.AddressService;
import com.alamousse.modules.shop.service.dto.AddressQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

/**
* @author mike
* @date 2019-07-25
*/
@Api(tags = "Address管理")
@RestController
@RequestMapping("api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Log("查询Address")
    @ApiOperation(value = "查询Address")
    @GetMapping(value = "/address")
    @PreAuthorize("hasAnyRole('ADMIN','ADDRESS_ALL','ADDRESS_SELECT')")
    public ResponseEntity getAddresss(AddressQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(addressService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增Address")
    @ApiOperation(value = "新增Address")
    @PostMapping(value = "/address")
    @PreAuthorize("hasAnyRole('ADMIN','ADDRESS_ALL','ADDRESS_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Address resources){
        return new ResponseEntity(addressService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Address")
    @ApiOperation(value = "修改Address")
    @PutMapping(value = "/address")
    @PreAuthorize("hasAnyRole('ADMIN','ADDRESS_ALL','ADDRESS_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Address resources){
        addressService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Address")
    @ApiOperation(value = "删除Address")
    @DeleteMapping(value = "/address/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ADDRESS_ALL','ADDRESS_DELETE')")
    public ResponseEntity delete(@PathVariable long id){
        addressService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}