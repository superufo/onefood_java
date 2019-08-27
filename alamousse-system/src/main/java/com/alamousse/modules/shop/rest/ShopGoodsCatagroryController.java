package com.alamousse.modules.shop.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.shop.service.ShopGoodsCatagroryService;
import com.alamousse.modules.shop.service.dto.ShopGoodsCatagroryDTO;
import com.alamousse.modules.shop.service.dto.ShopGoodsCatagroryQueryCriteria;
import com.alamousse.modules.shop.domain.ShopGoodsCatagrory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import java.util.List;

/**
* @author mike
* @date 2019-07-20
*/
@Api(tags = "ShopGoodsCatagrory管理")
@RestController
@RequestMapping("api")
public class ShopGoodsCatagroryController {

    @Autowired
    private ShopGoodsCatagroryService shopGoodsCatagroryService;

    @Log("查询ShopGoodsCatagrory")
    @ApiOperation(value = "查询ShopGoodsCatagrory")
    @GetMapping(value = "/shopGoodsCatagrory")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODSCATAGRORY_ALL','SHOPGOODSCATAGRORY_SELECT')")
    public ResponseEntity getShopGoodsCatagrorys(ShopGoodsCatagroryQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(shopGoodsCatagroryService.queryAll(criteria,pageable),HttpStatus.OK);
    }


    @Log("根据Id查询ShopGoodsCatagrory")
    @ApiOperation(value = "根据Id查询ShopGoodsCatagrory")
    @GetMapping(value = "/shopGoodsCatagrory/{pid}")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODSCATAGRORY_ALL','SHOPGOODSCATAGRORY_SELECT')")
    public ResponseEntity getShopGoodsCatagrorys(ShopGoodsCatagroryQueryCriteria criteria,@PathVariable Integer pid){
        if (pid>0) {
           // criteria.setCatagroryId(pid);
            criteria.setParentId(pid);
        }else {
            //criteria.setCatagroryId(null);
            criteria.setParentId(0);
        }
        return new ResponseEntity(shopGoodsCatagroryService.queryAll(criteria),HttpStatus.OK);
    }


    @Log("新增ShopGoodsCatagrory")
    @ApiOperation(value = "新增ShopGoodsCatagrory")
    @PostMapping(value = "/shopGoodsCatagrory")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODSCATAGRORY_ALL','SHOPGOODSCATAGRORY_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ShopGoodsCatagrory resources){
        return new ResponseEntity(shopGoodsCatagroryService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ShopGoodsCatagrory")
    @ApiOperation(value = "修改ShopGoodsCatagrory")
    @PutMapping(value = "/shopGoodsCatagrory")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODSCATAGRORY_ALL','SHOPGOODSCATAGRORY_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ShopGoodsCatagrory resources){
        shopGoodsCatagroryService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //只能够删除 城市和 区域一级的.
    @Log("删除ShopGoodsCatagrory")
    @ApiOperation(value = "删除ShopGoodsCatagrory")
    @DeleteMapping(value = "/shopGoodsCatagrory/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODSCATAGRORY_ALL','SHOPGOODSCATAGRORY_DELETE')")
    public ResponseEntity  delete(@PathVariable Integer id){
        List<ShopGoodsCatagroryDTO> zoneList = shopGoodsCatagroryService.findByParentId(id);

        // 特殊情况，对级联删除进行处理
        for (ShopGoodsCatagroryDTO shopGoodsCatagrory : zoneList) {
            shopGoodsCatagroryService.delete(shopGoodsCatagrory.getId());
        }
        shopGoodsCatagroryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}