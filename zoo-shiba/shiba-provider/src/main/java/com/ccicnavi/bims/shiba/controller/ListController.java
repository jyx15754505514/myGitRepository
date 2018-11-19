package com.ccicnavi.bims.shiba.controller;

import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.service.ListTemplateImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/list")
public class ListController {

    @Autowired
    ListTemplateImpl listTemplate;

    @RequestMapping(value = "/rightPush", method = RequestMethod.POST)
    public ResultT rightPush(@RequestParam(value = "key") Object key, @RequestParam(value = "list") Object value) {
        try {
            listTemplate.rightPush(key, value);
            return ResultT.success();
        } catch (Exception e) {
            log.error("单个添加list类型的缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/rightPushAll", method = RequestMethod.POST)
    public ResultT rightPushAll(@RequestParam(value = "key") Object key, @RequestBody Object... object) {
        try {
            listTemplate.rightPushAll(key, object);
            return ResultT.success();
        } catch (Exception e) {
            log.error("多个添加list类型的缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultT delete(@RequestParam(value = "key") Object key) {
        try {
            listTemplate.delete(key);
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key删除缓存失败 ", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.GET)
    public ResultT hasKey(@RequestParam(value = "key") Object key) {
        try {
            Boolean hasKey = listTemplate.hasKey(key);
            return ResultT.success(hasKey);
        } catch (Exception e) {
            log.error("查询key缓存是否存在失败 ", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/range", method = RequestMethod.GET)
    public ResultT range(@RequestParam(value = "key") Object key, @RequestParam(value = "start") long start, @RequestParam(value = "end") long end) {
        try {
            List value = listTemplate.range(key, start, end);
            return ResultT.success(value);
        } catch (Exception e) {
            log.error("根据始末位置查询key缓存失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/size", method = RequestMethod.GET)
    public ResultT size(@RequestParam(value = "key") Object key) {
        try {
            Long size = listTemplate.size(key);
            return ResultT.success(size);
        } catch (Exception e) {
            log.error("查询key缓存的大小失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ResultT index(@RequestParam(value = "key") Object key, @RequestParam(value = "index") long index) {
        try {
            Object value = listTemplate.index(key, index);
            return ResultT.success(value);
        } catch (Exception e) {
            log.error("根据下角标查询key", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }
}
