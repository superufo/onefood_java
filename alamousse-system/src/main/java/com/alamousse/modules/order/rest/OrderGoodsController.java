package com.alamousse.modules.order.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.order.domain.OrderGoods;
import com.alamousse.modules.order.service.OrderGoodsService;
import com.alamousse.modules.order.service.dto.OrderGoodsQueryCriteria;
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
@Api(tags = "OrderGoods管理")
@RestController
@RequestMapping("api")
public class OrderGoodsController {

    @Autowired
    private OrderGoodsService orderGoodsService;

    @Log("查询OrderGoods")
    @ApiOperation(value = "查询OrderGoods")
    @GetMapping(value = "/orderGoods")
    @PreAuthorize("hasAnyRole('ADMIN','ORDERGOODS_ALL','ORDERGOODS_SELECT')")
    public ResponseEntity getOrderGoodss(OrderGoodsQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(orderGoodsService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增OrderGoods")
    @ApiOperation(value = "新增OrderGoods")
    @PostMapping(value = "/orderGoods")
    @PreAuthorize("hasAnyRole('ADMIN','ORDERGOODS_ALL','ORDERGOODS_CREATE')")
    public ResponseEntity create(@Validated @RequestBody OrderGoods resources){
        return new ResponseEntity(orderGoodsService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改OrderGoods")
    @ApiOperation(value = "修改OrderGoods")
    @PutMapping(value = "/orderGoods")
    @PreAuthorize("hasAnyRole('ADMIN','ORDERGOODS_ALL','ORDERGOODS_EDIT')")
    public ResponseEntity update(@Validated @RequestBody OrderGoods resources){
        orderGoodsService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除OrderGoods")
    @ApiOperation(value = "删除OrderGoods")
    @DeleteMapping(value = "/orderGoods/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ORDERGOODS_ALL','ORDERGOODS_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        orderGoodsService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}