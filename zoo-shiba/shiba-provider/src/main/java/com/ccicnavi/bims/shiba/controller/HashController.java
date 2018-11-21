package com.ccicnavi.bims.shiba.controller;

import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.api.HashTemplate;
import com.ccicnavi.bims.shiba.service.ParamVo;
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
    HashTemplate hashTemplate;

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public ResultT put(@RequestBody ParamVo paramVo) {
        try {
            hashTemplate.put(paramVo.getKey(), paramVo.getMapKey(), paramVo.getValue());
            return ResultT.success();
        } catch (Exception e) {
            log.error("单个添加缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/putAll", method = RequestMethod.POST)
    public ResultT putAll(@RequestBody ParamVo paramVo) {
        try {
            hashTemplate.putAll(paramVo.getKey(), paramVo.getMap());
            return ResultT.success();
        } catch (Exception e) {
            log.error("添加hash类型的缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/entries", method = RequestMethod.POST)
    public ResultT entries(@RequestBody ParamVo paramVo) {
        try {
            Map<Object, Object> values = hashTemplate.entries(paramVo.getKey());
            return ResultT.success(values);
        } catch (Exception e) {
            log.error("根据key查询缓存失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultT delete(@RequestBody ParamVo paramVo) {
        try {
            hashTemplate.delete(paramVo.getKey());
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key删除缓存失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/deleteMap", method = RequestMethod.POST)
    public ResultT deleteMap(@RequestBody ParamVo paramVo) {
        try {
            hashTemplate.deleteMap(paramVo.getKey(), paramVo.getList().toArray());
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key删除缓存失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.POST)
    public ResultT hasKey(@RequestBody ParamVo paramVo) {
        try {
            Boolean hasKey = hashTemplate.hasKey(paramVo.getKey());
            return ResultT.success(hasKey);
        } catch (Exception e) {
            log.error("查询key缓存是否存在失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResultT get(@RequestBody ParamVo paramVo) {
        try {
            Object mapValue = hashTemplate.get(paramVo.getKey(), paramVo.getMapKey());
            return ResultT.success(mapValue);
        } catch (Exception e) {
            log.error("查询key缓存中map的value值失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/size", method = RequestMethod.POST)
    public ResultT size(@RequestBody ParamVo paramVo) {
        try {
            Long size = hashTemplate.size(paramVo.getKey());
            return ResultT.success(size);
        } catch (Exception e) {
            log.error("查询key缓存大小失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/multiGet", method = RequestMethod.POST)
    public ResultT multiGet(@RequestBody ParamVo paramVo) {
        try {
            List mapKeyList = hashTemplate.multiGet(paramVo.getKey(), paramVo.getList());
            return ResultT.success(mapKeyList);
        } catch (Exception e) {
            log.error("根据key查询key缓存中map的value集合", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/keys", method = RequestMethod.POST)
    public ResultT keys(@RequestBody ParamVo paramVo) {
        try {
            Set keys = hashTemplate.keys(paramVo.getKey());
            return ResultT.success(keys);
        } catch (Exception e) {
            log.error("查询key缓存下的map的key集合", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/values", method = RequestMethod.POST)
    public ResultT values(@RequestBody ParamVo paramVo) {
        try {
            List values = hashTemplate.values(paramVo.getKey());
            return ResultT.success(values);
        } catch (Exception e) {
            log.error("查询key缓存下的map的values集合", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/setTime", method = RequestMethod.POST)
    public ResultT setTime(@RequestBody ParamVo paramVo) {
        try {
            hashTemplate.expire(paramVo.getKey(), paramVo.getOutTime(), paramVo.getUnit());
            return ResultT.success();
        } catch (Exception e) {
            log.error("设置超时时间失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }
}
