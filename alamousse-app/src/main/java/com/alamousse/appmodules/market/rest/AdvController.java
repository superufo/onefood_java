package com.alamousse.appmodules.market.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.appmodules.market.domain.Adv;
import com.alamousse.appmodules.market.service.AdvService;
import com.alamousse.appmodules.market.service.dto.AdvQueryCriteria;
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
@Api(tags = "Adv管理")
@RestController
@RequestMapping("api")
public class AdvController {

    @Autowired
    private AdvService advService;

    @Log("查询Adv")
    @ApiOperation(value = "查询Adv")
    @GetMapping(value = "/adv")
    public ResponseEntity getAdvs(AdvQueryCriteria criteria, Pageable pageable){
        //return new ResponseEntity(advService.queryAll(criteria,pageable),HttpStatus.OK);
        return new ResponseEntity(new HttpResponse(0,advService.queryAll(criteria,pageable),null),HttpStatus.OK);
    }

    @Log("新增Adv")
    @ApiOperation(value = "新增Adv")
    @PostMapping(value = "/adv")
    @PreAuthorize("hasAnyRole('ADMIN','ADV_ALL','ADV_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Adv resources){
        return new ResponseEntity(advService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Adv")
    @ApiOperation(value = "修改Adv")
    @PutMapping(value = "/adv")
    @PreAuthorize("hasAnyRole('ADMIN','ADV_ALL','ADV_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Adv resources){
        advService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Adv")
    @ApiOperation(value = "删除Adv")
    @DeleteMapping(value = "/adv/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ADV_ALL','ADV_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        advService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
