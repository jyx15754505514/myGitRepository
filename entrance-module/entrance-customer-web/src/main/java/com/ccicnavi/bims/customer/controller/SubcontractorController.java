package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
     * @description: 查询分包方信息
     * @param: subcontractorDO
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/listSubcontractor",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listSubcontractorPage(@RequestBody PageParameter<SubcontractorDO> pageParameter){
        try {
            PageBean<SubcontractorDO> pageBean = null;
            pageBean = subcontractorService.listSubcontractorPage(pageParameter);
            if(pageBean != null){
                return  ResultT.success(pageBean);
            }
            return ResultT.failure(ResultCode.LIST_FAILURE);
        } catch (Exception e) {
            log.error("查询分包方信息失败",e);
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
    public ResultT saveSubcontractor(@RequestBody SubcontractorDO subcontractorDO){
        try {
            Integer count=subcontractorService.insertSubcontractor(subcontractorDO);
            if(count >= 1){
                return ResultT.success();
            }
            return ResultT.failure(ResultCode.ADD_FAILURE);
        } catch (Exception e) {
            log.error("新增分包方信息失败",e);
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
        try {
            Integer count=subcontractorService.updateSubcontractor(subcontractorDO);
            if(count == 1){
                return ResultT.success();
            }
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        } catch (Exception e) {
            log.error("修改分包方信息失败",e);
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

        try {
            Integer count = subcontractorService.removeSubcontractor(subcontractorDTO);
            if(count >= 1){
                return ResultT.success();
            }
            return ResultT.failure(ResultCode.DELETE_FAILURE);

        } catch (Exception e) {
            log.error("删除分包方信息失败",e);
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
        if(subcontractorDTO.getSubcontractorUuid() == null || "".equals(subcontractorDTO.getSubcontractorUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            subcontractorDTO = subcontractorService.getSubcontractorList(subcontractorDTO);
            if(subcontractorDTO != null && subcontractorDTO.getSubcontractorUuid() != null && !"".equals(subcontractorDTO.getSubcontractorUuid())){
                return ResultT.success(subcontractorDTO);
            }
            return ResultT.failure(ResultCode.GET_FAILURE);
        } catch (Exception e) {
            log.error("查询分包方信息失败",e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

}
