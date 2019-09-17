package com.alamousse.appmodules.market.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.appmodules.market.domain.RedeemPoint;
import com.alamousse.appmodules.market.service.RedeemPointService;
import com.alamousse.appmodules.market.service.dto.RedeemPointQueryCriteria;
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
@Api(tags = "RedeemPoint管理")
@RestController
@RequestMapping("api")
public class RedeemPointController {

    @Autowired
    private RedeemPointService redeemPointService;

    @Log("查询RedeemPoint")
    @ApiOperation(value = "查询RedeemPoint")
    @GetMapping(value = "/redeemPoint")
    public ResponseEntity getRedeemPoints(RedeemPointQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(redeemPointService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增RedeemPoint")
    @ApiOperation(value = "新增RedeemPoint")
    @PostMapping(value = "/redeemPoint")
    @PreAuthorize("hasAnyRole('ADMIN','REDEEMPOINT_ALL','REDEEMPOINT_CREATE')")
    public ResponseEntity create(@Validated @RequestBody RedeemPoint resources){
        return new ResponseEntity(redeemPointService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改RedeemPoint")
    @ApiOperation(value = "修改RedeemPoint")
    @PutMapping(value = "/redeemPoint")
    @PreAuthorize("hasAnyRole('ADMIN','REDEEMPOINT_ALL','REDEEMPOINT_EDIT')")
    public ResponseEntity update(@Validated @RequestBody RedeemPoint resources){
        redeemPointService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除RedeemPoint")
    @ApiOperation(value = "删除RedeemPoint")
    @DeleteMapping(value = "/redeemPoint/{code}")
    @PreAuthorize("hasAnyRole('ADMIN','REDEEMPOINT_ALL','REDEEMPOINT_DELETE')")
    public ResponseEntity delete(@PathVariable String code){
        redeemPointService.delete(code);
        return new ResponseEntity(HttpStatus.OK);
    }
}
