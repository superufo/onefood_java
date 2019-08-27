package com.alamousse.modules.shop.rest;

import com.alamousse.aop.log.Log;
import com.alamousse.modules.shop.service.ShopService;
import com.alamousse.modules.shop.service.dto.ShopQueryCriteria;
import com.alamousse.utils.SecurityUtils;
import com.alamousse.modules.shop.domain.Shop;
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
    @PreAuthorize("hasAnyRole('ADMIN','SHOP_ALL','SHOP_SELECT')")
    public ResponseEntity getShops(ShopQueryCriteria criteria, Pageable pageable){
        this.setSearchShop(criteria);
        return new ResponseEntity(shopService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("根据ID查询Shop")
    @ApiOperation(value = "根据ID查询Shop")
    @GetMapping(value = "/shop/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','SHOP_ALL','SHOP_SELECT')")
    public ResponseEntity getShop(@PathVariable Integer id){
        return new ResponseEntity(shopService.findById(id), HttpStatus.OK);
    }

    @Log("新增Shop")
    @ApiOperation(value = "新增Shop")
    @PostMapping(value = "/shop")
    @PreAuthorize("hasAnyRole('ADMIN','SHOP_ALL','SHOP_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Shop resources){
        return new ResponseEntity(shopService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Shop")
    @ApiOperation(value = "修改Shop")
    @PutMapping(value = "/shop")
    @PreAuthorize("hasAnyRole('ADMIN','SHOP_ALL','SHOP_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Shop resources){
        shopService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Shop")
    @ApiOperation(value = "删除Shop")
    @DeleteMapping(value = "/shop/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','SHOP_ALL','SHOP_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        shopService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("根据地区查询Shop")
    @ApiOperation(value = "根据地区查询Shop")
    @GetMapping(value = "/shop/{country}/{provice}/{city}/{street}")
    @PreAuthorize("hasAnyRole('ADMIN','SHOP_ALL','SHOP_SELECT')")
    public ResponseEntity getShopByZone(ShopQueryCriteria criteria, @PathVariable Integer country, @PathVariable Integer provice,@PathVariable Integer city,@PathVariable Integer street){
        boolean ok;
        ok = true;

        //默认为0查询全部
        if ( country<1 ){
            ok = false;
        }else{
            criteria.setCountry(country);
        }

        if ( ok == true && provice>0 ) {
            criteria.setProvice(provice);
        }else{
            ok = false;
            criteria.setProvice(null);
        }

        if ( ok == true && city>0 ) {
            criteria.setCity(city);
        }else{
            ok = false;
            criteria.setCity(null);
        }

        if ( ok == true && street>0 ) {
            criteria.setStreet(street);
        }else {
            criteria.setStreet(null);
        }
        //log.info(criteria.toString());

        return new ResponseEntity(shopService.queryAll(criteria),HttpStatus.OK);
    }

    private void setSearchShop(ShopQueryCriteria criteria){
        Integer shopId = SecurityUtils.getShopId();
        if ( shopId ==  1 ) {
            criteria.setId(null);
        }else{
            criteria.setId(shopId);
        }
    }

}