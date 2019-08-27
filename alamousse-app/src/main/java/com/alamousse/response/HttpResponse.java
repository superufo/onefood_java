package com.alamousse.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;

@Data
public  class HttpResponse {
    // 0 成功 1 失败
    private   Integer  status;

    // 0 成功时候的数据
    private   Object   data;

    //1 失败 失败时候的提示
    private   String   message;

    public HttpResponse(Integer status,Object data, String message) {
        this.data  = data;
        this.status= status;
        this.message= message;
    }
//    public HttpResponse(@Nullable T body, Integer  status,  HttpStatus status) {
//        ResponseEntity(@Nullable T body, HttpStatus status)
//    }
}
