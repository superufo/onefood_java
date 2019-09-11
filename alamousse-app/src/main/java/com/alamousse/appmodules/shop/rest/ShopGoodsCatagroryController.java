package com.alamousse.appmodules.shop.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.appmodules.shop.domain.ShopGoodsCatagrory;
import com.alamousse.appmodules.shop.service.ShopGoodsCatagroryService;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsCatagroryDTO;
import com.alamousse.appmodules.shop.service.dto.ShopGoodsCatagroryQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity getShopGoodsCatagrorys(ShopGoodsCatagroryQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(shopGoodsCatagroryService.queryAll(criteria,pageable),HttpStatus.OK);
    }


    @Log("根据Id查询ShopGoodsCatagrory")
    @ApiOperation(value = "根据Id查询ShopGoodsCatagrory")
    @GetMapping(value = "/shopGoodsCatagrory/{pid}")
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

    //只能够删除 城市和 区域一级的.
    @Log("删除ShopGoodsCatagrory")
    @ApiOperation(value = "删除ShopGoodsCatagrory")
    @DeleteMapping(value = "/shopGoodsCatagrory/{id}")
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
