package com.alamousse.modules.order.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.order.domain.OrderDelivery;
import com.alamousse.modules.order.service.OrderDeliveryService;
import com.alamousse.modules.order.service.dto.OrderDeliveryQueryCriteria;
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
* @date 2019-07-27
*/
@Api(tags = "OrderDelivery管理")
@RestController
@RequestMapping("api")
public class OrderDeliveryController {

    @Autowired
    private OrderDeliveryService orderDeliveryService;

    @Log("查询OrderDelivery")
    @ApiOperation(value = "查询OrderDelivery")
    @GetMapping(value = "/orderDelivery")
    @PreAuthorize("hasAnyRole('ADMIN','ORDERDELIVERY_ALL','ORDERDELIVERY_SELECT')")
    public ResponseEntity getOrderDeliverys(OrderDeliveryQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(orderDeliveryService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增OrderDelivery")
    @ApiOperation(value = "新增OrderDelivery")
    @PostMapping(value = "/orderDelivery")
    @PreAuthorize("hasAnyRole('ADMIN','ORDERDELIVERY_ALL','ORDERDELIVERY_CREATE')")
    public ResponseEntity create(@Validated @RequestBody OrderDelivery resources){
        return new ResponseEntity(orderDeliveryService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改OrderDelivery")
    @ApiOperation(value = "修改OrderDelivery")
    @PutMapping(value = "/orderDelivery")
    @PreAuthorize("hasAnyRole('ADMIN','ORDERDELIVERY_ALL','ORDERDELIVERY_EDIT')")
    public ResponseEntity update(@Validated @RequestBody OrderDelivery resources){
        orderDeliveryService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除OrderDelivery")
    @ApiOperation(value = "删除OrderDelivery")
    @DeleteMapping(value = "/orderDelivery/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ORDERDELIVERY_ALL','ORDERDELIVERY_DELETE')")
    public ResponseEntity delete(@PathVariable String id){
        orderDeliveryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}