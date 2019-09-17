package com.alamousse.appmodules.market.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.appmodules.market.domain.AdvCatagrory;
import com.alamousse.appmodules.market.service.AdvCatagroryService;
import com.alamousse.appmodules.market.service.dto.AdvCatagroryQueryCriteria;
import com.alamousse.response.HttpResponse;
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
@Api(tags = "AdvCatagrory管理")
@RestController
@RequestMapping("api")
public class AdvCatagroryController {

    @Autowired
    private AdvCatagroryService advCatagroryService;

    @Log("查询AdvCatagrory")
    @ApiOperation(value = "查询AdvCatagrory")
    @GetMapping(value = "/advCatagrory")
    public ResponseEntity getAdvCatagrorys(AdvCatagroryQueryCriteria criteria, Pageable pageable){
        //return new ResponseEntity(advCatagroryService.queryAll(criteria,pageable),HttpStatus.OK);

        return new ResponseEntity(new HttpResponse(0,advCatagroryService.queryAll(criteria,pageable),null),HttpStatus.OK);
    }

    @Log("新增AdvCatagrory")
    @ApiOperation(value = "新增AdvCatagrory")
    @PostMapping(value = "/advCatagrory")
    public ResponseEntity create(@Validated @RequestBody AdvCatagrory resources){
        return new ResponseEntity(advCatagroryService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改AdvCatagrory")
    @ApiOperation(value = "修改AdvCatagrory")
    @PutMapping(value = "/advCatagrory")
    public ResponseEntity update(@Validated @RequestBody AdvCatagrory resources){
        advCatagroryService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除AdvCatagrory")
    @ApiOperation(value = "删除AdvCatagrory")
    @DeleteMapping(value = "/advCatagrory/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        advCatagroryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
