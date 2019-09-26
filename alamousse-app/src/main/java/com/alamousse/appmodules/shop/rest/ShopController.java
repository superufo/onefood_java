package com.alamousse.appmodules.shop.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.appmodules.shop.domain.Shop;
import com.alamousse.appmodules.shop.service.ShopService;
import com.alamousse.appmodules.shop.service.dto.ShopQueryCriteria;
import com.alamousse.response.HttpResponse;
import com.alamousse.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author mike
* @date 2019-07-20
*/
@Slf4j
@Api(tags = "Shop管理")
@RestController
@RequestMapping("api")
public class ShopController {

    @Autowired
    private ShopService shopService;

    private ShopQueryCriteria criteriaShop = new  ShopQueryCriteria();

    @Log("查询Shop")
    @ApiOperation(value = "查询Shop")
    @GetMapping(value = "/shop")
    public ResponseEntity getShops(ShopQueryCriteria criteria, Pageable pageable){
        this.setSearchShop(criteria);
        //return new ResponseEntity(shopService.queryAll(criteria,pageable),HttpStatus.OK);
        return new ResponseEntity(new HttpResponse(0,shopService.queryAll(criteria,pageable),null),HttpStatus.OK);
    }

    @Log("根据ID查询Shop")
    @ApiOperation(value = "根据ID查询Shop")
    @GetMapping(value = "/shop/{id}")
    public ResponseEntity getShop(@PathVariable Integer id){
        //return new ResponseEntity(shopService.findById(id), HttpStatus.OK)
        return new ResponseEntity(new HttpResponse(0,shopService.findById(id),null),HttpStatus.OK);
    }

    private void setSearchShop(ShopQueryCriteria criteria){
        if (criteria.getId()==null ) {
            Integer shopId = SecurityUtils.getShopId();
            if (shopId == 1) {
                criteria.setId(null);
            } else {
                criteria.setId(shopId);
            }
        }
    }

}
