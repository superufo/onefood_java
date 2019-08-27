package com.alamousse.modules.order.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.order.domain.Order;
import com.alamousse.modules.order.service.dto.OrderQueryCriteria;
import com.alamousse.modules.order.service.OrderService;
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
@Api(tags = "Order管理")
@RestController
@RequestMapping("api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Log("查询Order")
    @ApiOperation(value = "查询Order")
    @GetMapping(value = "/order")
    @PreAuthorize("hasAnyRole('ADMIN','ORDER_ALL','ORDER_SELECT')")
    public ResponseEntity getOrders(OrderQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(orderService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增Order")
    @ApiOperation(value = "新增Order")
    @PostMapping(value = "/order")
    @PreAuthorize("hasAnyRole('ADMIN','ORDER_ALL','ORDER_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Order resources){
        return new ResponseEntity(orderService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Order")
    @ApiOperation(value = "修改Order")
    @PutMapping(value = "/order")
    @PreAuthorize("hasAnyRole('ADMIN','ORDER_ALL','ORDER_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Order resources){
        orderService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Order")
    @ApiOperation(value = "删除Order")
    @DeleteMapping(value = "/order/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ORDER_ALL','ORDER_DELETE')")
    public ResponseEntity delete(@PathVariable String id){
        orderService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}