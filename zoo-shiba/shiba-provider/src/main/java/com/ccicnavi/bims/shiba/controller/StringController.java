package com.ccicnavi.bims.shiba.controller;

import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.api.StringTemplate;
import com.ccicnavi.bims.shiba.service.ParamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(value = "/string")
@RestController
public class StringController {

    @Autowired
    StringTemplate stringTemplate;

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public ResultT set(@RequestBody ParamVo paramVo) {
        try {
            stringTemplate.set(paramVo.getKey(), paramVo.getValue());
            return ResultT.success();
        } catch (Exception e) {
            log.error("添加String类型的缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/setTime", method = RequestMethod.POST)
    public ResultT setTime(@RequestBody ParamVo paramVo) {
        try {
            stringTemplate.setTime(paramVo.getKey(), paramVo.getValue(), paramVo.getOutTime(), paramVo.getUnit());
            return ResultT.success();
        } catch (Exception e) {
            log.error("设置超时时间失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResultT get(@RequestBody ParamVo paramVo) {
        try {
            Object value = stringTemplate.get(paramVo.getKey());
            return ResultT.success(value);
        } catch (Exception e) {
            log.error("根据key查询缓存失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/getSn", method = RequestMethod.POST)
    public ResultT getSn(@RequestBody ParamVo paramVo) {
        try {
            Object value = stringTemplate.getSn(paramVo.getKey(), paramVo.getStart(), paramVo.getEnd());
            return ResultT.success(value);
        } catch (Exception e) {
            log.error("根据起始位置查询缓存", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultT delete(@RequestBody ParamVo paramVo) {
        try {
            stringTemplate.delete(paramVo.getKey());
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key删除缓存失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.POST)
    public ResultT hasKey(@RequestBody ParamVo paramVo) {
        try {
            Boolean hasKey = stringTemplate.hasKey(paramVo.getKey());
            return ResultT.success(hasKey);
        } catch (Exception e) {
            log.error("查询key缓存是否存在失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/size", method = RequestMethod.POST)
    public ResultT size(@RequestBody ParamVo paramVo) {
        try {
            Long size = stringTemplate.size(paramVo.getKey());
            return ResultT.success(size);
        } catch (Exception e) {
            log.error("查询key缓存大小失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/getAndSet", method = RequestMethod.POST)
    public ResultT getAndSet(@RequestBody ParamVo paramVo) {
        try {
            Object values = stringTemplate.getAndSet(paramVo.getKey(), paramVo.getValue());
            return ResultT.success(values);
        } catch (Exception e) {
            log.error("获取原来key键对应的值并重新赋新值", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }
}
