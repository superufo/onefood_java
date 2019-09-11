package com.alamousse.modules.shop.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.shop.domain.ShopGoods;
import com.alamousse.modules.shop.service.ShopGoodsService;
import com.alamousse.modules.shop.service.dto.ShopGoodsDTO;
import com.alamousse.modules.shop.service.dto.ShopGoodsQueryCriteria;
import com.alamousse.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

/**
* @author jie
* @date 2019-07-20
*/
@Api(tags = "ShopGoods管理")
@RestController
@RequestMapping("api")
public class ShopGoodsController {

    @Autowired
    private ShopGoodsService shopGoodsService;

    //private ShopGoodsQueryCriteria criteriaShop = new  ShopGoodsQueryCriteria();

    @Log("查询ShopGoods")
    @ApiOperation(value = "查询ShopGoods")
    @GetMapping(value = "/shopGoods")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODS_ALL','SHOPGOODS_SELECT')")
    public ResponseEntity getShopGoods(ShopGoodsQueryCriteria criteria, Pageable pageable){
        this.setSearchShop(criteria);
        return new ResponseEntity(shopGoodsService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增ShopGoods")
    @ApiOperation(value = "新增ShopGoods")
    @PostMapping(value = "/shopGoods")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODS_ALL','SHOPGOODS_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ShopGoodsDTO resources){
        return new ResponseEntity(shopGoodsService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ShopGoods")
    @ApiOperation(value = "修改ShopGoods")
    @PutMapping(value = "/shopGoods")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODS_ALL','SHOPGOODS_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ShopGoods resources){
        shopGoodsService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ShopGoods")
    @ApiOperation(value = "删除ShopGoods")
    @DeleteMapping(value = "/shopGoods/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','SHOPGOODS_ALL','SHOPGOODS_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        shopGoodsService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    private void setSearchShop(ShopGoodsQueryCriteria criteria){
        Integer shopId = SecurityUtils.getShopId();
        if (shopId !=  1 ) {
            criteria.setShopId(shopId);
        }else{
            criteria.setShopId(null);
        }
    }
}
