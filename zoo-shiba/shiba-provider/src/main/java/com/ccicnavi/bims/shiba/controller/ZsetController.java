package com.ccicnavi.bims.shiba.controller;

import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.service.ZsetTemplateImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/zset")
public class ZsetController {

    @Autowired
    ZsetTemplateImpl zsetTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultT add(@RequestParam(value = "key") Object key, @RequestParam(value = "value") Object value, @RequestParam(value = "score") double score) {
        try {
            zsetTemplate.add(key, value, score);
            return ResultT.success();
        } catch (Exception e) {
            log.error("添加set类型的缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResultT range(@RequestParam(value = "key") Object key, @RequestParam(value = "start") long start, @RequestParam(value = "end") long end) {
        try {
            Set value = zsetTemplate.range(key, start, end);
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key查询start-end的缓存失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResultT delete(@RequestParam(value = "key") Object key) {
        try {
            zsetTemplate.delete(key);
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key删除缓存失败 ", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.GET)
    public ResultT hasKey(@RequestParam(value = "key") Object key) {
        try {
            Boolean hasKey = zsetTemplate.hasKey(key);
            return ResultT.success(hasKey);
        } catch (Exception e) {
            log.error("查询key缓存是否存在失败 ", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.POST)
    public ResultT remove(@RequestParam(value = "key") Object key, @RequestBody Object... value) {
        try {
            zsetTemplate.remove(key, value);
            return ResultT.success();
        } catch (Exception e) {
            log.error("values从排序集中删除 ", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.POST)
    public ResultT removeRange(@RequestParam(value = "key") Object key, @RequestParam(value = "start") long start, @RequestParam(value = "end") long end) {
        try {
            zsetTemplate.remove(key, start, end);
            return ResultT.success();
        } catch (Exception e) {
            log.error("删除有序集之间start和end之间的元素 ", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }
}
