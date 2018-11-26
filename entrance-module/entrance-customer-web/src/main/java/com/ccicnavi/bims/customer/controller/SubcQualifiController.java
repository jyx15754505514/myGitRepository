package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.customer.api.SubcQualifiService;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import org.n3r.eql.EqlTran;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 分包方资质controller
 * @author: WangYingLing
 * @create: 2018-11-17 11:25
 */

@RestController
@RequestMapping(value = "/subcQualifi")
public class SubcQualifiController {

    private final static Logger log= LoggerFactory.getLogger(SubcQualifiController.class);

    @Reference(timeout = 30000)
    SubcQualifiService subcQualifiService;

    /**
     * @author WangYingLing
     * @description 查询分包方资质信息
     * @param subcontractorDTO
     * @return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/listSubcQuali",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listSubcQuali(@RequestBody SubcontractorDTO subcontractorDTO){
        List<SubcQualifiDO> subcQualifiDOList=null;
        try {
            subcQualifiDOList=subcQualifiService.listSubcQuali(subcontractorDTO);
            return ResultT.success(subcQualifiDOList);
        } catch (Exception e) {
            log.error("查询分包方资质信息失败",e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * @author WangYingLing
     * @description 新增分包方资质信息
     * @param subcQualifiDO
     * @return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/saveSubcQuali",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveSubcQuali(@RequestBody SubcQualifiDO subcQualifiDO){
        int count=0;
        try {
            count=subcQualifiService.insertSubcQuali(subcQualifiDO);
            if(count>0){
                return ResultT.success("新增分包方资质信息成功");
             }
        } catch (Exception e) {
            log.error("新增分包方资质信息失败",e);
        }
         return ResultT.failure(ResultCode.ADD_FAILURE);
     }

    /**
     * @author WangYingLing
     * @description 删除分包方资质信息
     * @param subcQualifiDTO
     * @return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/removeSubcQuali",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT removeSubcQuali(@RequestBody SubcQualifiDTO subcQualifiDTO){
        int count=0;
        try {
            count=subcQualifiService.deleteSubcQuali(subcQualifiDTO);
            if(count > 0){
                return ResultT.success("删除分包方资质信息成功");
            }
        } catch (Exception e) {
            log.error("删除分包方资质信息失败",e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }

    /**
     * @author WangYingLing
     * @description 修改分包方资质信息
     * @param subcQualifiDO
     * @return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/updateSubcQuali",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateSubcQuali(@RequestBody SubcQualifiDO subcQualifiDO){
        int count=0;
        try {
            count=subcQualifiService.updateSubcQuali(subcQualifiDO);
            if(count > 0){
                return ResultT.success("修改分包方资质信息成功");
            }
        } catch (Exception e) {
            log.error("修改分包方资质信息失败",e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**
     * @author WangYingLing
     * @description 获取分包方资质信息
     * @param subcQualifiDORequstBody
     * @return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/getSubcQuali",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getSubcQuali(@RequestBody SubcQualifiDO subcQualifiDORequstBody){
        SubcQualifiDO subcQualifiDO=new SubcQualifiDO();
        try {
            subcQualifiDO=subcQualifiService.getSubcQuali(subcQualifiDORequstBody);
            if(subcQualifiDO != null) {
                return ResultT.success(subcQualifiDO);
            }
        } catch (Exception e) {
            log.error("获取分包方资质信息失败",e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }

}
