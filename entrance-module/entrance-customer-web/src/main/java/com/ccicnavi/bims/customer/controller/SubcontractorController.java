package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import com.ccicnavi.bims.customer.api.SubcontractorService;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
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
 * @author: WangYingLing
 * @create: 2018-11-16 09:39
 */

@RestController
@RequestMapping("/subcontractor")
public class SubcontractorController {

    private final static Logger log= LoggerFactory.getLogger(SubcontractorController.class);

    @Reference(timeout = 30000)
    SubcontractorService subcontractorService;

    /**
     * @author: WangYingLing
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
     * @author: WangYingLing
     * @description: 新增分包方信息
     * @param: subcontractorDO
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/saveSubcontractor",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveSubcontractor(@RequestBody SubcontractorDO subcontractorDO){
        int count=0;
        try {
            count=subcontractorService.insertSubcontractor(subcontractorDO);
            if(count>0){
                return ResultT.success(count);
            }
        } catch (Exception e) {
            log.error("新增分包方信息失败",e);
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /**
     * @author: WangYingLing
     * @description: 修改分包方信息
     * @param: java.lang.String
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/updateSubcontractor",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateSubcontractor(@RequestBody SubcontractorDO subcontractorDO){
        int count=0;
        try {
            count=subcontractorService.updateSubcontractor(subcontractorDO);
            return ResultT.success(count);
        } catch (Exception e) {
            log.error("修改分包方信息失败",e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
     * @author: WangYingLing
     * @description: 删除分包方信息
     * @param: subcontractorDO
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/removeSubcontractor",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT removeSubcontractor(@RequestBody SubcontractorDTO subcontractorDTO){
        int count=0;
        try {
            count=subcontractorService.removeSubcontractor(subcontractorDTO);
            return ResultT.success(count);
        } catch (Exception e) {
            log.error("删除分包方信息失败",e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /**
     * @author: WangYingLing
     * @description: 查询分包方信息（根据主键获取）
     * @param: subcontractorDORequstBody
     * @return: com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/getSubcontractorList",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getSubcontractor(@RequestBody SubcontractorDTO subcontractorDTO){
        try {
            subcontractorDTO = subcontractorService.getSubcontractorList(subcontractorDTO);
            return ResultT.success(subcontractorDTO);
        } catch (Exception e) {
            log.error("查询分包方信息失败",e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

}
