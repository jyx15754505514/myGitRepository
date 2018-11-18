package com.ccicnavi.bims.shiba.controller;

import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.service.SetTemplateImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping(value = "/set")
public class SetController {

    @Autowired
    SetTemplateImpl setTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultT add(@RequestParam(value = "key") Object key, @RequestBody Object... value) {
        try {
            setTemplate.add(key, value);
            return ResultT.success();
        } catch (Exception e) {
            log.error("添加set类型的缓存shib", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/range", method = RequestMethod.GET)
    public ResultT members(@RequestParam(value = "key") Object key) {
        try {
            Set value = setTemplate.members(key);
            return ResultT.success(value);
        } catch (Exception e) {
            log.error("根据key查询缓存", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResultT delete(@RequestParam(value = "key") Object key) {
        try {
            setTemplate.delete(key);
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key删除缓存失败 ", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.GET)
    public ResultT hasKey(@RequestParam(value = "key") Object key) {
        try {
            Boolean hasKey = setTemplate.hasKey(key);
            return ResultT.success(hasKey);
        } catch (Exception e) {
            log.error("查询key缓存是否存在失败 ", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/size", method = RequestMethod.GET)
    public ResultT size(@RequestParam(value = "key") Object key) {
        try {
            Long size = setTemplate.size(key);
            return ResultT.success(size);
        } catch (Exception e) {
            log.error("查询key缓存的大小失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ResultT size(@RequestParam(value = "key") Object key, @RequestBody Object... values) {
        try {
            setTemplate.remove(key, values);
            return ResultT.success();
        } catch (Exception e) {
            log.error("删除key缓存的values元素", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }
}
