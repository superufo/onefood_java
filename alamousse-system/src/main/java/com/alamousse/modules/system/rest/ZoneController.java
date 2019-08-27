package com.alamousse.modules.system.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.system.domain.Zone;
import com.alamousse.modules.system.service.dto.ZoneQueryCriteria;
import com.alamousse.modules.system.service.ZoneService;
import lombok.extern.slf4j.Slf4j;
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
* @date 2019-07-21
*/
@Api(tags = "Zone管理")
@RestController
@Slf4j
@RequestMapping("api")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @Log("查询Zone")
    @ApiOperation(value = "查询Zone")
    @GetMapping(value = "/zone")
    @PreAuthorize("hasAnyRole('ADMIN','ZONE_ALL','ZONE_SELECT')")
    public ResponseEntity getZones(ZoneQueryCriteria criteria, Pageable pageable){
        //List<ZoneDTO> zoneDTOList = zoneService.queryAll(criteria);
        //return new ResponseEntity(zoneService.queryAll(zoneDTOList),HttpStatus.OK);
        return new ResponseEntity(zoneService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增Zone")
    @ApiOperation(value = "新增Zone")
    @PostMapping(value = "/zone")
    @PreAuthorize("hasAnyRole('ADMIN','ZONE_ALL','ZONE_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Zone resources){
        return new ResponseEntity(zoneService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Zone")
    @ApiOperation(value = "修改Zone")
    @PutMapping(value = "/zone")
    @PreAuthorize("hasAnyRole('ADMIN','ZONE_ALL','ZONE_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Zone resources){
        zoneService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("查询国家")
    @ApiOperation(value = "查询国家")
    @GetMapping(value = "/zone/getCountry")
    @PreAuthorize("hasAnyRole('ADMIN','ZONE_ALL','ZONE_SELECT')")
    public ResponseEntity getCountry(ZoneQueryCriteria criteria){
        criteria.setType(1);
        return new ResponseEntity(zoneService.queryAll(criteria),HttpStatus.OK);
    }

    @Log("查询省份")
    @ApiOperation(value = "查询省份")
    @GetMapping(value = "/zone/getProvince/{countryId}")
    @PreAuthorize("hasAnyRole('ADMIN','ZONE_ALL','ZONE_SELECT')")
    public ResponseEntity getProvince(ZoneQueryCriteria criteria,@PathVariable Integer countryId){
        criteria.setType(2);
        criteria.setParentId(countryId);
        return new ResponseEntity(zoneService.queryAll(criteria),HttpStatus.OK);
    }

    @Log("查询城市")
    @ApiOperation(value = "查询城市")
    @GetMapping(value = "/zone/getCity/{provinceID}")
    @PreAuthorize("hasAnyRole('ADMIN','ZONE_ALL','ZONE_SELECT')")
    public ResponseEntity getCity(ZoneQueryCriteria criteria,@PathVariable Integer provinceID){
        criteria.setType(3);
        criteria.setParentId(provinceID);
        return new ResponseEntity(zoneService.queryAll(criteria),HttpStatus.OK);
    }

    @Log("查询城市区域")
    @ApiOperation(value = "查询城市区域")
    @GetMapping(value = "/zone/getDistrict/{cityId}")
    @PreAuthorize("hasAnyRole('ADMIN','ZONE_ALL','ZONE_SELECT')")
    public ResponseEntity getDistrict(ZoneQueryCriteria criteria,@PathVariable Integer cityId){
        criteria.setType(4);
        criteria.setParentId(cityId);
        return new ResponseEntity(zoneService.queryAll(criteria),HttpStatus.OK);
    }

    @Log("按类型查询")
    @ApiOperation(value = "按类型查询")
    @GetMapping(value = "/zone/getZoneByType/{pid}")
    @PreAuthorize("hasAnyRole('ADMIN','ZONE_ALL','ZONE_SELECT')")
    public ResponseEntity getZoneByType(ZoneQueryCriteria criteria, @PathVariable Integer pid){
        criteria.setParentId(pid);
        return new ResponseEntity(zoneService.queryAll(criteria),HttpStatus.OK);
    }

    //只能够删除 城市和 区域一级的.
    @Log("删除Zone")
    @ApiOperation(value = "删除Zone")
    @DeleteMapping(value = "/zone/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ZONE_ALL','ZONE_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        zoneService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}