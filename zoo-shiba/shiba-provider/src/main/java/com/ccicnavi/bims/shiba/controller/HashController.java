package com.ccicnavi.bims.shiba.controller;

import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.service.HashTemplateImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping(value = "/hash")
public class HashController {

    @Autowired
    HashTemplateImpl hashTemplate;

    @RequestMapping(value = "/putAll", method = RequestMethod.POST)
    public ResultT putAll(@RequestParam(value = "key") Object key, @RequestParam(value = "map") Map<Object, Object> map) {
        try {
            hashTemplate.putAll(key, map);
            return ResultT.success();
        } catch (Exception e) {
            log.error("添加hash类型的缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/entries", method = RequestMethod.GET)
    public ResultT entries(@RequestParam(value = "key") Object key) {
        try {
            Map<Object, Object> values = hashTemplate.entries(key);
            return ResultT.success(values);
        } catch (Exception e) {
            log.error("根据key查询缓存失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResultT delete(@RequestParam(value = "key") Object key) {
        try {
            hashTemplate.delete(key);
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key删除缓存失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.GET)
    public ResultT hasKey(@RequestParam(value = "key") Object key) {
        try {
            Boolean hasKey = hashTemplate.hasKey(key);
            return ResultT.success(hasKey);
        } catch (Exception e) {
            log.error("查询key缓存是否存在失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public ResultT put(@RequestParam(value = "key") Object key, @RequestParam(value = "mapKey") Object mapKey, @RequestParam(value = "mapValue", required = false) Object mapValue) {
        try {
            hashTemplate.put(key, mapKey, mapValue);
            return ResultT.success();
        } catch (Exception e) {
            log.error("单个添加缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResultT get(@RequestParam(value = "key") Object key, @RequestParam(value = "mapKey") Object mapKey) {
        try {
            Object mapValue = hashTemplate.get(key, mapKey);
            return ResultT.success(mapValue);
        } catch (Exception e) {
            log.error("查询key缓存中map的value值失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/size", method = RequestMethod.GET)
    public ResultT size(@RequestParam(value = "key") Object key) {
        try {
            Long size = hashTemplate.size(key);
            return ResultT.success(size);
        } catch (Exception e) {
            log.error("查询key缓存大小失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/multiGet", method = RequestMethod.GET)
    public ResultT multiGet(@RequestParam(value = "key") Object key, @RequestParam(value = "keys") List<Object> keys) {
        try {
            List list = hashTemplate.multiGet(key, keys);
            return ResultT.success(list);
        } catch (Exception e) {
            log.error("根据key查询key缓存中map的value集合", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/keys", method = RequestMethod.GET)
    public ResultT keys(@RequestParam(value = "key") Object key) {
        try {
            Set keys = hashTemplate.keys(key);
            return ResultT.success(keys);
        } catch (Exception e) {
            log.error("查询key缓存下的map的key集合", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/keys", method = RequestMethod.GET)
    public ResultT values(@RequestParam(value = "key") Object key) {
        try {
            List values = hashTemplate.values(key);
            return ResultT.success(values);
        } catch (Exception e) {
            log.error("查询key缓存下的map的values集合", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }
}
