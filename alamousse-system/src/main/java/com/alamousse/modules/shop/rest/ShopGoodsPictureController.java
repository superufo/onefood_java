package com.alamousse.modules.shop.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.shop.domain.ShopGoodsPicture;
import com.alamousse.modules.shop.service.ShopGoodsPictureService;
import com.alamousse.modules.shop.service.dto.ShopGoodsPictureQueryCriteria;
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
* @date 2019-07-30
*/
@Api(tags = "ShopGoodsPicture管理")
@RestController
@RequestMapping("api")
public class ShopGoodsPictureController {

    @Autowired
    private ShopGoodsPictureService shopGoodsPictureService;

    @Log("查询ShopGoodsPicture")
    @ApiOperation(value = "查询ShopGoodsPicture")
    @GetMapping(value = "/shopGoodsPicture")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODSPICTURE_ALL','SHOPGOODSPICTURE_SELECT')")
    public ResponseEntity getShopGoodsPictures(ShopGoodsPictureQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(shopGoodsPictureService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ShopGoodsPicture")
    @ApiOperation(value = "新增ShopGoodsPicture")
    @PostMapping(value = "/shopGoodsPicture")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODSPICTURE_ALL','SHOPGOODSPICTURE_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ShopGoodsPicture resources){
        return new ResponseEntity(shopGoodsPictureService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ShopGoodsPicture")
    @ApiOperation(value = "修改ShopGoodsPicture")
    @PutMapping(value = "/shopGoodsPicture")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODSPICTURE_ALL','SHOPGOODSPICTURE_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ShopGoodsPicture resources){
        shopGoodsPictureService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ShopGoodsPicture")
    @ApiOperation(value = "删除ShopGoodsPicture")
    @DeleteMapping(value = "/shopGoodsPicture/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODSPICTURE_ALL','SHOPGOODSPICTURE_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        shopGoodsPictureService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}