package com.alamousse.modules.market.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.market.domain.PromoteGoods;
import com.alamousse.modules.market.service.PromoteGoodsService;
import com.alamousse.modules.market.service.dto.PromoteGoodsQueryCriteria;
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
* @date 2019-08-01
*/
@Api(tags = "PromoteGoods管理")
@RestController
@RequestMapping("api")
public class PromoteGoodsController {

    @Autowired
    private PromoteGoodsService promoteGoodsService;

    @Log("查询PromoteGoods")
    @ApiOperation(value = "查询PromoteGoods")
    @GetMapping(value = "/promoteGoods")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTEGOODS_ALL','PROMOTEGOODS_SELECT')")
    public ResponseEntity getPromoteGoodss(PromoteGoodsQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(promoteGoodsService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增PromoteGoods")
    @ApiOperation(value = "新增PromoteGoods")
    @PostMapping(value = "/promoteGoods")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTEGOODS_ALL','PROMOTEGOODS_CREATE')")
    public ResponseEntity create(@Validated @RequestBody PromoteGoods resources){
        return new ResponseEntity(promoteGoodsService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改PromoteGoods")
    @ApiOperation(value = "修改PromoteGoods")
    @PutMapping(value = "/promoteGoods")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTEGOODS_ALL','PROMOTEGOODS_EDIT')")
    public ResponseEntity update(@Validated @RequestBody PromoteGoods resources){
        promoteGoodsService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除PromoteGoods")
    @ApiOperation(value = "删除PromoteGoods")
    @DeleteMapping(value = "/promoteGoods/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTEGOODS_ALL','PROMOTEGOODS_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        promoteGoodsService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}