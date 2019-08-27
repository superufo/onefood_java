package com.alamousse.modules.market.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.market.domain.PromoteCode;
import com.alamousse.modules.market.service.PromoteCodeService;
import com.alamousse.modules.market.service.dto.PromoteCodeQueryCriteria;
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
@Api(tags = "PromoteCode管理")
@RestController
@RequestMapping("api")
public class PromoteCodeController {

    @Autowired
    private PromoteCodeService promoteCodeService;

    @Log("查询PromoteCode")
    @ApiOperation(value = "查询PromoteCode")
    @GetMapping(value = "/promoteCode")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTECODE_ALL','PROMOTECODE_SELECT')")
    public ResponseEntity getPromoteCodes(PromoteCodeQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(promoteCodeService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增PromoteCode")
    @ApiOperation(value = "新增PromoteCode")
    @PostMapping(value = "/promoteCode")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTECODE_ALL','PROMOTECODE_CREATE')")
    public ResponseEntity create(@Validated @RequestBody PromoteCode resources){
        return new ResponseEntity(promoteCodeService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改PromoteCode")
    @ApiOperation(value = "修改PromoteCode")
    @PutMapping(value = "/promoteCode")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTECODE_ALL','PROMOTECODE_EDIT')")
    public ResponseEntity update(@Validated @RequestBody PromoteCode resources){
        promoteCodeService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除PromoteCode")
    @ApiOperation(value = "删除PromoteCode")
    @DeleteMapping(value = "/promoteCode/{code}")
    @PreAuthorize("hasAnyRole('ADMIN','PROMOTECODE_ALL','PROMOTECODE_DELETE')")
    public ResponseEntity delete(@PathVariable String code){
        promoteCodeService.delete(code);
        return new ResponseEntity(HttpStatus.OK);
    }
}