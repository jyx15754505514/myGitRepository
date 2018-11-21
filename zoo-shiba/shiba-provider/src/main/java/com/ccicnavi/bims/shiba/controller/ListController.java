package com.ccicnavi.bims.shiba.controller;

import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.api.ListTemplate;
import com.ccicnavi.bims.shiba.service.ParamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/list")
public class ListController {

    @Autowired
    ListTemplate listTemplate;

    @RequestMapping(value = "/rightPush", method = RequestMethod.POST)
    public ResultT rightPush(@RequestBody ParamVo paramVo) {
        try {
            listTemplate.rightPush(paramVo.getKey(), paramVo.getValue());
            return ResultT.success();
        } catch (Exception e) {
            log.error("单个添加list类型的缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/rightPushAll", method = RequestMethod.POST)
    public ResultT rightPushAll(@RequestBody ParamVo paramVo) {
        try {
            listTemplate.rightPushAll(paramVo.getKey(), paramVo.getList().toArray());
            return ResultT.success();
        } catch (Exception e) {
            log.error("多个添加list类型的缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultT delete(@RequestBody ParamVo paramVo) {
        try {
            listTemplate.delete(paramVo.getKey());
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key删除缓存失败 ", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.POST)
    public ResultT hasKey(@RequestBody ParamVo paramVo) {
        try {
            Boolean hasKey = listTemplate.hasKey(paramVo.getKey());
            return ResultT.success(hasKey);
        } catch (Exception e) {
            log.error("查询key缓存是否存在失败 ", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/range", method = RequestMethod.POST)
    public ResultT range(@RequestBody ParamVo paramVo) {
        try {
            List value = listTemplate.range(paramVo.getKey(), paramVo.getStart(), paramVo.getEnd());
            return ResultT.success(value);
        } catch (Exception e) {
            log.error("根据始末位置查询key缓存失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/size", method = RequestMethod.POST)
    public ResultT size(@RequestBody ParamVo paramVo) {
        try {
            Long size = listTemplate.size(paramVo.getKey());
            return ResultT.success(size);
        } catch (Exception e) {
            log.error("查询key缓存的大小失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ResultT index(@RequestBody ParamVo paramVo) {
        try {
            Object value = listTemplate.index(paramVo.getKey(), paramVo.getStart());
            return ResultT.success(value);
        } catch (Exception e) {
            log.error("根据下角标查询key", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/setTime", method = RequestMethod.POST)
    public ResultT setTime(@RequestBody ParamVo paramVo) {
        try {
            listTemplate.expire(paramVo.getKey(), paramVo.getOutTime(), paramVo.getUnit());
            return ResultT.success();
        } catch (Exception e) {
            log.error("设置超时时间失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }
}
