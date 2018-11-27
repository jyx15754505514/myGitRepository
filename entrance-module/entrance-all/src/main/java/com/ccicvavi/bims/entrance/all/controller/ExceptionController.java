package com.ccicvavi.bims.entrance.all.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

//@ControllerAdvice
//@RestController
//@RequestMapping(value = "/error")
public class ExceptionController {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public String httpRequestMethodNotSupportedException(HttpServletResponse response) {
        response.setStatus(200);
        return String.valueOf(RESPONSE_INTERFACE.errorJSONString(405, "method 方法不支持"));
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public String httpMediaTypeNotSupportedException(HttpServletResponse response) {
        response.setStatus(200);
        return String.valueOf(RESPONSE_INTERFACE.errorJSONString(415, "不支持媒体类型"));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundPage404(HttpServletResponse response) {
        response.setStatus(200);
        return String.valueOf(RESPONSE_INTERFACE.errorJSONString(404, "没有找到访问资源"));
    }

    @RequestMapping(value = "/401", produces = {"application/json;charset=UTF-8"})
    public String forbidden401(HttpServletResponse response) {
        response.setStatus(200);
        System.out.println("401");
        return String.valueOf(RESPONSE_INTERFACE.errorJSONString(401, "没有访问权限"));
    }

    @RequestMapping(value = "/403", produces = {"application/json;charset=UTF-8"})
    public String forbidden403(HttpServletResponse response) {
        response.setStatus(200);
        System.out.println("403");
        return String.valueOf(RESPONSE_INTERFACE.errorJSONString(403, "没有访问权限"));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultException(HttpServletResponse response) {
        response.setStatus(200);
        return String.valueOf(RESPONSE_INTERFACE.errorJSONString(500, "网络异常"));
    }

}
