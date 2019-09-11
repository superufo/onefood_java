package com.alamousse.utils;

import cn.hutool.json.JSONObject;
import com.alamousse.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 获取当前登录的用户
 * @author mike
 * @date 2019-01-17
 */
@Slf4j
public class SecurityUtils {

    public static UserDetails getUserDetails() {
        UserDetails userDetails = null;
        try {
            userDetails = (UserDetails) org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED, "登录状态过期");
        }
        return userDetails;
    }

    /**
     * 获取系统用户名称
     * @return 系统用户名称
     */
    public static String getUsername(){
        Object obj = getUserDetails();
        JSONObject json = new JSONObject(obj);
        return json.get("username", String.class);
    }

    /**
     * 获取系统用户id
     * @return 系统用户id
     */
    public static Long getUserId(){
        Object obj = getUserDetails();
        JSONObject json = new JSONObject(obj);
        return json.get("id", Long.class);
    }

    /**
     * 获取店鋪id
     * @return 店鋪id
     */
    public static Integer getShopId(){
        Object obj = getUserDetails();
        JSONObject json = new JSONObject(obj);
        System.out.print(json);
        return json.get("shopId", Integer.class);
    }
}
