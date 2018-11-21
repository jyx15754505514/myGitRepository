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
@RequestMapping("system")
@Slf4j
public class SerialnumController {
    @Reference(url = "dubbo://127.0.0.1:20881", timeout = 10000)
    private SerialnumService serialnumService;

    /**
     * 分页查询业务编码生成规则
     *
     * @return com.ccicnavi.bims.common.ResultT
     * @Author CongZhiYuan
     * @Date 2018/11/21 23:11
     * @Param [pageParameter]
     **/
    @GetMapping(value = "listSerialnumCfg")
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
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }
    /**
     * 获取业务编码生成规则
     *
     * @return com.ccicnavi.bims.common.ResultT
     * @Author CongZhiYuan
     * @Date 2018/11/21 23:23
     * @Param serialnumCfgDTO
     **/
    @PostMapping(value = "getSerialnumCfg")
    public ResultT getSerialnumCfg(@RequestBody SerialQueryDTO serialQueryDTO) {
        try {
            SerialnumCfgDTO dto = serialnumService.getSerialnumCfg(serialQueryDTO);
            return ResultT.success("添加业务编码生成规则成功");
        } catch (Exception e) {
            log.error("添加业务编码生成规则失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
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
    @PostMapping(value = "addSerialnumCfg")
    public ResultT addSerialnumCfg(@RequestBody SerialnumCfgDTO serialnumCfgDTO) {
        try {
            serialnumService.addSerialnumCfg(serialnumCfgDTO);
            return ResultT.success("添加业务编码生成规则成功");
        } catch (Exception e) {
            log.error("添加业务编码生成规则失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
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
    @PostMapping(value = "updateSerialnumCfg")
    public ResultT updateSerialnumCfg(@RequestBody SerialnumCfgDTO serialnumCfgDTO) {
        try {
            serialnumService.updateSerialnumCfg(serialnumCfgDTO);
            return ResultT.success("修改业务编码生成规则成功");
        } catch (Exception e) {
            log.error("修改业务编码生成规则失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
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
    @DeleteMapping(value = "deleteSerialnumCfg")
    public ResultT deleteSerialnumCfg(@RequestParam(value="sncUuid") String sncUuid) {
        try {
            serialnumService.deleteSerialnumCfg(sncUuid);
            return ResultT.success("删除业务编码生成规则成功");
        } catch (Exception e) {
            log.error("删除业务编码生成规则失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }
}
