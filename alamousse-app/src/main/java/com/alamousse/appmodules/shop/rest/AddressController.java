package com.alamousse.appmodules.shop.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.appmodules.shop.domain.Address;
import com.alamousse.appmodules.shop.service.AddressService;
import com.alamousse.appmodules.shop.service.dto.AddressQueryCriteria;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsQueryCriteria;
import com.alamousse.response.HttpResponse;
import com.alamousse.utils.SecurityUtils;
import com.sun.org.apache.xpath.internal.operations.String;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/address/{mid}")
    public ResponseEntity getAddresss(AddressQueryCriteria criteria, Pageable pageable,@PathVariable Integer mid){
        criteria.setMid(mid);
        return new ResponseEntity(
                                  new HttpResponse(0,addressService.queryAll(criteria,pageable),null),
                                  HttpStatus.OK);
    }

    @Log("查询Address")
    @ApiOperation(value = "查询Address")
    @GetMapping(value = "/address")
    public ResponseEntity getAddresss(AddressQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(
                new HttpResponse(0,addressService.queryAll(criteria,pageable),null),
                HttpStatus.OK);
    }

    @Log("查询Address")
    @ApiOperation(value = "查询Address")
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(
                new HttpResponse(0,addressService.findById(id),null),
                HttpStatus.OK);
    }

    @Log("查询缺省Address")
    @ApiOperation(value = "查询缺省Address")
    @GetMapping(value = "/addressdefault/{mid}")
    public ResponseEntity getDefaultAddresss(@PathVariable Integer mid){
        return new ResponseEntity(
                new HttpResponse(0,addressService.findDefaultByMid(mid),null),
                HttpStatus.OK);
    }

    @Log("新增Address")
    @ApiOperation(value = "新增Address")
    @PostMapping(value = "/address")
    public ResponseEntity create(@Validated @RequestBody Address resources){
        return new ResponseEntity(new HttpResponse(0,addressService.create(resources),null),HttpStatus.CREATED);
    }

    @Log("修改Address")
    @ApiOperation(value = "修改Address")
    @PutMapping(value = "/address")
    public ResponseEntity update(@Validated @RequestBody Address resources){
        addressService.update(resources);
        return new ResponseEntity(new HttpResponse(0,"success",null),HttpStatus.NO_CONTENT);
    }

    @Log("删除Address")
    @ApiOperation(value = "删除Address")
    @DeleteMapping(value = "/address/{id}")
    public ResponseEntity delete(@PathVariable long id){
        addressService.delete(id);
        return new ResponseEntity(new HttpResponse(0,"success",null),HttpStatus.OK);
    }

}
