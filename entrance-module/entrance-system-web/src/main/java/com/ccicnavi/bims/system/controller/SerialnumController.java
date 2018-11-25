package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.pojo.SerialQueryDTO;
import com.ccicnavi.bims.system.pojo.SerialnumCfgDO;
import com.ccicnavi.bims.system.pojo.SerialnumCfgDTO;
import com.ccicnavi.bims.system.service.api.RoleService;
import com.ccicnavi.bims.system.service.api.SerialnumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/21 22:30
 * @Description: 业务编码规则管理
 */
@RestController
@RequestMapping("/serialnum")
@Slf4j
public class SerialnumController {
    @Reference
    private SerialnumService serialnumService;

    /**
     * 分页查询业务编码生成规则
     *
     * @return com.ccicnavi.bims.common.ResultT
     * @Author CongZhiYuan
     * @Date 2018/11/21 23:11
     * @Param [pageParameter]
     **/
    @RequestMapping(value = "/listSerialnumCfg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listSerialnumCfg(@RequestBody PageParameter<SerialnumCfgDO> pageParameter) {
        try {
            PageBean<SerialnumCfgDO> serialnumCfgList = serialnumService.listSerialnumCfg(pageParameter);
            if(serialnumCfgList != null) {
                log.info("查询成功", JSONObject.toJSONString(serialnumCfgList));
                return ResultT.success(serialnumCfgList);
            }
        } catch (Exception e) {
            log.error("查询角色列表失败", e);
        }
        return ResultT.failure(ResultCode.SERIAL_CFG_GET_FAILURE);
    }
    /**
     * 获取业务编码生成规则
     *
     * @return com.ccicnavi.bims.common.ResultT
     * @Author CongZhiYuan
     * @Date 2018/11/21 23:23
     * @Param serialnumCfgDTO
     **/
    @RequestMapping(value = "/getSerialnumCfg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getSerialnumCfg(@RequestBody SerialQueryDTO serialQueryDTO) {
        try {
            SerialnumCfgDTO dto = serialnumService.getSerialnumCfg(serialQueryDTO);
            return ResultT.success(dto);
        } catch (Exception e) {
            log.error("查询业务编码规则失败", e);
            return ResultT.failure(ResultCode.SERIAL_CFG_GET_FAILURE);
        }
    }
    /**
     * 添加业务编码生成规则
     *
     * @return com.ccicnavi.bims.common.ResultT
     * @Author CongZhiYuan
     * @Date 2018/11/21 23:15
     * @Param
     **/
    @RequestMapping(value = "/addSerialnumCfg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT addSerialnumCfg(@RequestBody SerialnumCfgDTO serialnumCfgDTO) {
        try {
            serialnumService.addSerialnumCfg(serialnumCfgDTO);
            return ResultT.success("添加业务编码生成规则成功");
        } catch (Exception e) {
            log.error("添加业务编码生成规则失败", e);
            return ResultT.failure(ResultCode.SERIAL_CFG_ADD_FAILURE);
        }
    }
    /**
     * 添加业务编码生成规则
     *
     * @return com.ccicnavi.bims.common.ResultT
     * @Author CongZhiYuan
     * @Date 2018/11/21 23:15
     * @Param
     **/
    @RequestMapping(value = "/updateSerialnumCfg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateSerialnumCfg(@RequestBody SerialnumCfgDTO serialnumCfgDTO) {
        try {
            serialnumService.updateSerialnumCfg(serialnumCfgDTO);
            return ResultT.success("修改业务编码生成规则成功");
        } catch (Exception e) {
            log.error("修改业务编码生成规则失败", e);
            return ResultT.failure(ResultCode.SERIAL_CFG_MODIFY_FAILURE);
        }
    }
    /**
     * 添加业务编码生成规则
     *
     * @return com.ccicnavi.bims.common.ResultT
     * @Author CongZhiYuan
     * @Date 2018/11/21 23:15
     * @Param
     **/
    @RequestMapping(value = "/deleteSerialnumCfg", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public ResultT deleteSerialnumCfg(@RequestParam(value="sncUuid") String sncUuid) {
        try {
            serialnumService.deleteSerialnumCfg(sncUuid);
            return ResultT.success("删除业务编码生成规则成功");
        } catch (Exception e) {
            log.error("删除业务编码生成规则失败", e);
            return ResultT.failure(ResultCode.SERIAL_CFG_REMOVE_FAILURE);
        }
    }
}
