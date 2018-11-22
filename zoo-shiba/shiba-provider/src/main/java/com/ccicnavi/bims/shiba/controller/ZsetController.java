package com.ccicnavi.bims.shiba.controller;

import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.api.ZsetTemplate;
import com.ccicnavi.bims.shiba.service.ParamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/zset")
public class ZsetController {

    @Autowired
    ZsetTemplate zsetTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultT add(@RequestBody ParamVo paramVo) {
        try {
            zsetTemplate.add(paramVo.getKey(), paramVo.getValue(), paramVo.getScore());
            return ResultT.success();
        } catch (Exception e) {
            log.error("添加set类型的缓存失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/range", method = RequestMethod.POST)
    public ResultT range(@RequestBody ParamVo paramVo) {
        try {
            Set value = zsetTemplate.range(paramVo.getKey(), paramVo.getStart(), paramVo.getEnd());
            return ResultT.success(value);
        } catch (Exception e) {
            log.error("根据key查询start-end的缓存失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultT delete(@RequestBody ParamVo paramVo) {
        try {
            zsetTemplate.delete(paramVo.getKey());
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key删除缓存失败 ", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.POST)
    public ResultT hasKey(@RequestBody ParamVo paramVo) {
        try {
            Boolean hasKey = zsetTemplate.hasKey(paramVo.getKey());
            return ResultT.success(hasKey);
        } catch (Exception e) {
            log.error("查询key缓存是否存在失败 ", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ResultT remove(@RequestBody ParamVo paramVo) {
        try {
            zsetTemplate.remove(paramVo.getKey(), paramVo.getList().toArray());
            return ResultT.success();
        } catch (Exception e) {
            log.error("values从排序集中删除 ", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/removeRange", method = RequestMethod.POST)
    public ResultT removeRange(@RequestBody ParamVo paramVo) {
        try {
            zsetTemplate.removeRange(paramVo.getKey(), paramVo.getStart(), paramVo.getEnd());
            return ResultT.success();
        } catch (Exception e) {
            log.error("删除有序集之间start和end之间的元素 ", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/size", method = RequestMethod.POST)
    public ResultT size(@RequestBody ParamVo paramVo) {
        try {
            Long size = zsetTemplate.size(paramVo.getKey());
            return ResultT.success(size);
        } catch (Exception e) {
            log.error("查询key缓存大小失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/setTime", method = RequestMethod.POST)
    public ResultT setTime(@RequestBody ParamVo paramVo) {
        try {
            zsetTemplate.expire(paramVo.getKey(), paramVo.getOutTime(), paramVo.getUnit());
            return ResultT.success();
        } catch (Exception e) {
            log.error("设置超时时间失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }
}
