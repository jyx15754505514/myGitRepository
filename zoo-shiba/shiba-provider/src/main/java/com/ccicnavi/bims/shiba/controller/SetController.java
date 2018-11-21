package com.ccicnavi.bims.shiba.controller;

import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.api.SetTemplate;
import com.ccicnavi.bims.shiba.service.ParamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping(value = "/set")
public class SetController {

    @Autowired
    SetTemplate setTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultT add(@RequestBody ParamVo paramVo) {
        try {
            setTemplate.add(paramVo.getKey(), paramVo.getList().toArray());
            return ResultT.success();
        } catch (Exception e) {
            log.error("添加set类型的缓存shib", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/members", method = RequestMethod.POST)
    public ResultT members(@RequestBody ParamVo paramVo) {
        try {
            Set value = setTemplate.members(paramVo.getKey());
            return ResultT.success(value);
        } catch (Exception e) {
            log.error("根据key查询缓存", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultT delete(@RequestBody ParamVo paramVo) {
        try {
            setTemplate.delete(paramVo.getKey());
            return ResultT.success();
        } catch (Exception e) {
            log.error("根据key删除缓存失败 ", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/hasKey", method = RequestMethod.POST)
    public ResultT hasKey(@RequestBody ParamVo paramVo) {
        try {
            Boolean hasKey = setTemplate.hasKey(paramVo.getKey());
            return ResultT.success(hasKey);
        } catch (Exception e) {
            log.error("查询key缓存是否存在失败 ", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/size", method = RequestMethod.POST)
    public ResultT size(@RequestBody ParamVo paramVo) {
        try {
            Long size = setTemplate.size(paramVo.getKey());
            return ResultT.success(size);
        } catch (Exception e) {
            log.error("查询key缓存的大小失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ResultT remove(@RequestBody ParamVo paramVo) {
        try {
            setTemplate.remove(paramVo.getKey(), paramVo.getList().toArray());
            return ResultT.success();
        } catch (Exception e) {
            log.error("删除key缓存的values元素失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/isMember", method = RequestMethod.POST)
    public ResultT isMember(@RequestBody ParamVo paramVo) {
        try {
            Boolean iMember = setTemplate.isMember(paramVo.getKey(), paramVo.getValue());
            return ResultT.success(iMember);
        } catch (Exception e) {
            log.error("判断value元素是否是集合key的成员失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/setTime", method = RequestMethod.POST)
    public ResultT setTime(@RequestBody ParamVo paramVo) {
        try {
            setTemplate.expire(paramVo.getKey(), paramVo.getOutTime(), paramVo.getUnit());
            return ResultT.success();
        } catch (Exception e) {
            log.error("设置超时时间失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }
}
