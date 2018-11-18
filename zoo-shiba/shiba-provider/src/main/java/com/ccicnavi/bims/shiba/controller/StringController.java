package com.ccicnavi.bims.shiba.controller;

import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.service.StringTemplateImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(value = "/string")
@RestController
public class StringController {

    @Autowired
    StringTemplateImpl stringTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultT add(@RequestParam(value = "key") Object key, @RequestParam Object value) {
        try {
            stringTemplate.add(key, value);
            return ResultT.success();
        } catch (Exception e) {
            log.error("添加String类型的缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResultT get(@RequestParam(value = "key") Object key) {
        try {
            Object value = stringTemplate.get(key);
            return ResultT.success(value);
        } catch (Exception e) {
            log.error("根据key查询缓存失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResultT getSn(@RequestParam(value = "key") Object key, @RequestParam(value = "start") long start, @RequestParam(value = "end") long end) {
        try {
            Object value = stringTemplate.getSn(key, start, end);
            return ResultT.success(value);
        } catch (Exception e) {
            log.error("根据起始位置查询缓存", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResultT delete(@RequestParam(value = "key") Object key) {
        try {
            stringTemplate.delete(key);
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key删除缓存失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.GET)
    public ResultT hasKey(@RequestParam(value = "key") Object key) {
        try {
            Boolean hasKey = stringTemplate.hasKey(key);
            return ResultT.success(hasKey);
        } catch (Exception e) {
            log.error("查询key缓存是否存在失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }
}
