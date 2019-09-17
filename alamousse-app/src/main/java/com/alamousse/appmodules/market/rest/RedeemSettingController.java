package com.alamousse.appmodules.market.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.appmodules.market.domain.RedeemSetting;
import com.alamousse.appmodules.market.service.RedeemSettingService;
import com.alamousse.appmodules.market.service.dto.RedeemSettingQueryCriteria;
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
* @date 2019-08-01
*/
@Api(tags = "RedeemSetting管理")
@RestController
@RequestMapping("api")
public class RedeemSettingController {

    @Autowired
    private RedeemSettingService redeemSettingService;

    @Log("查询RedeemSetting")
    @ApiOperation(value = "查询RedeemSetting")
    @GetMapping(value = "/redeemSetting")
    public ResponseEntity getRedeemSettings(RedeemSettingQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(redeemSettingService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增RedeemSetting")
    @ApiOperation(value = "新增RedeemSetting")
    @PostMapping(value = "/redeemSetting")
    @PreAuthorize("hasAnyRole('ADMIN','REDEEMSETTING_ALL','REDEEMSETTING_CREATE')")
    public ResponseEntity create(@Validated @RequestBody RedeemSetting resources){
        return new ResponseEntity(redeemSettingService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改RedeemSetting")
    @ApiOperation(value = "修改RedeemSetting")
    @PutMapping(value = "/redeemSetting")
    @PreAuthorize("hasAnyRole('ADMIN','REDEEMSETTING_ALL','REDEEMSETTING_EDIT')")
    public ResponseEntity update(@Validated @RequestBody RedeemSetting resources){
        redeemSettingService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除RedeemSetting")
    @ApiOperation(value = "删除RedeemSetting")
    @DeleteMapping(value = "/redeemSetting/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','REDEEMSETTING_ALL','REDEEMSETTING_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        redeemSettingService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
