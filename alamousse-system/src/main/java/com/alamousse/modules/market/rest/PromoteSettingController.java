package com.alamousse.modules.market.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.market.domain.PromoteSetting;
import com.alamousse.modules.market.service.PromoteSettingService;
import com.alamousse.modules.market.service.dto.PromoteSettingQueryCriteria;
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
@Api(tags = "PromoteSetting管理")
@RestController
@RequestMapping("api")
public class PromoteSettingController {

    @Autowired
    private PromoteSettingService promoteSettingService;

    @Log("查询PromoteSetting")
    @ApiOperation(value = "查询PromoteSetting")
    @GetMapping(value = "/promoteSetting")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTESETTING_ALL','PROMOTESETTING_SELECT')")
    public ResponseEntity getPromoteSettings(PromoteSettingQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(promoteSettingService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增PromoteSetting")
    @ApiOperation(value = "新增PromoteSetting")
    @PostMapping(value = "/promoteSetting")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTESETTING_ALL','PROMOTESETTING_CREATE')")
    public ResponseEntity create(@Validated @RequestBody PromoteSetting resources){
        return new ResponseEntity(promoteSettingService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改PromoteSetting")
    @ApiOperation(value = "修改PromoteSetting")
    @PutMapping(value = "/promoteSetting")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTESETTING_ALL','PROMOTESETTING_EDIT')")
    public ResponseEntity update(@Validated @RequestBody PromoteSetting resources){
        promoteSettingService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除PromoteSetting")
    @ApiOperation(value = "删除PromoteSetting")
    @DeleteMapping(value = "/promoteSetting/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTESETTING_ALL','PROMOTESETTING_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        promoteSettingService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}