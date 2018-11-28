package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import com.ccicnavi.bims.customer.api.SubcontractorService;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 分包方信息controller
 * @author: limin
 * @create: 2018-11-16 09:39
 */
@Slf4j
@RestController
@RequestMapping("/subcontractor")
public class SubcontractorController {

    @Reference(timeout = 30000)
    SubcontractorService subcontractorService;

    /**
     * @author: limin
     * @description: 查询分包方列表(分页)
     * @param: subcontractorDO
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/listSubcontractor",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listSubcontractorPage(@RequestBody PageParameter<SubcontractorDO> pageParameter){
        log.info("开始获取分包方列表 Param:" + JSON.toJSONString(pageParameter)  + " Time: " + new Date());
        try {
            PageBean<SubcontractorDO> pageBean = subcontractorService.listSubcontractorPage(pageParameter);
            if(pageBean != null){
                log.info("获取分包方列表结果：" + JSON.toJSONString(pageBean));
                return  ResultT.success(pageBean);
            }
            log.info("获取分包方列表异常");
            return ResultT.failure(ResultCode.LIST_FAILURE);
        } catch (Exception e) {
            log.error("获取分包方列表异常" + e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * @author: limin
     * @description: 新增分包方信息
     * @param: subcontractorDO
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/saveSubcontractor",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveSubcontractor(@RequestBody SubcontractorDTO subcontractorDTO){
        log.info("开始保存分包方信息 Param:" + JSON.toJSONString(subcontractorDTO)  + " Time: " + new Date());
        try {
            Integer count=subcontractorService.insertSubcontractor(subcontractorDTO);
            if(count >= 1){
                log.info("保存分包方信息结果：保存数量" + count );
                return ResultT.success();
            }
            log.info("保存分包方信息异常");
            return ResultT.failure(ResultCode.ADD_FAILURE);
        } catch (Exception e) {
            log.error("保存分包方信息异常" + e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }

    }

    /**
     * @author: limin
     * @description: 修改分包方信息
     * @param: subcontractorDO
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/updateSubcontractor",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateSubcontractor(@RequestBody SubcontractorDO subcontractorDO){
        log.info("开始更新分包方信息 Param:" + JSON.toJSONString(subcontractorDO)  + " Time: " + new Date());
        try {
            Integer count=subcontractorService.updateSubcontractor(subcontractorDO);
            if(count >= 1){
                log.info("更新分包方信息结果：更新数量" + count);
                return ResultT.success();
            }
            log.info("更新分包商信息异常");
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        } catch (Exception e) {
            log.error("更新分包商信息异常" + e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
     * @author: limin
     * @description: 删除分包方信息
     * @param: subcontractorDO
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/removeSubcontractor",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT removeSubcontractor(@RequestBody SubcontractorDTO subcontractorDTO){
        log.info("开始移除分包方信息 Param:" + JSON.toJSONString(subcontractorDTO)  + " Time: " + new Date());
        try {
            Integer count = subcontractorService.removeSubcontractor(subcontractorDTO);
            if(count >= 1){
                log.info("移除分包方信息结果：移除数量" + count);
                return ResultT.success();
            }
            log.info("移除分包方信息异常");
            return ResultT.failure(ResultCode.DELETE_FAILURE);

        } catch (Exception e) {
            log.error("移除分包方信息异常" + e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /**
     * @author: limin
     * @description: 查询分包方信息（根据主键获取）
     * @param: subcontractorDO
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/getSubcontractorList",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getSubcontractorList(@RequestBody SubcontractorDTO subcontractorDTO){
        log.info("开始获取分包方信息 Param:" + JSON.toJSONString(subcontractorDTO)  + " Time: " + new Date());
        try {
            if(StringUtils.isEmpty(subcontractorDTO.getSubcontractorUuid())){
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
            subcontractorDTO = subcontractorService.getSubcontractorList(subcontractorDTO);
            if(subcontractorDTO != null && !StringUtils.isEmpty(subcontractorDTO.getSubcontractorUuid())){
                log.info("获取分包方信息结果：" + JSON.toJSONString(subcontractorDTO));
                return ResultT.success(subcontractorDTO);
            }
            log.info("获取分包方信息异常");
            return ResultT.failure(ResultCode.GET_FAILURE);
        } catch (Exception e) {
            log.error("获取分包方信息异常" + e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

}
