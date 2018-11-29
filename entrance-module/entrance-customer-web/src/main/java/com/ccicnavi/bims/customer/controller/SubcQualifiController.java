package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.customer.api.SubcQualifiService;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
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
    *@Description: 查询分包方资质信息
    *@Author: ChaiYanShun
    *@Create: 2018/11/29 18:11
    *@Param [subcontractorDTO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/listSubcQuali",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listSubcQuali(@RequestBody SubcontractorDTO subcontractorDTO){
        log.debug("查询分包方资质信息列表 Param:" + JSON.toJSONString(subcontractorDTO)  + " Time: " + new Date());
        //判断分包方id是否为空
        if(StringUtils.isEmpty(subcontractorDTO.getSubcUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            List<SubcQualifiDO> subcQualifiDOList=subcQualifiService.listSubcQuali(subcontractorDTO);
            if(subcQualifiDOList != null && subcQualifiDOList.size() > 0){
                log.debug("获取分包方资质列表结果：" + JSON.toJSONString(subcQualifiDOList));
                return ResultT.success(subcQualifiDOList);
            }
        } catch (Exception e) {
            log.error("查询分包方资质信息失败",e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
    *@Description: 新增分包方资质信息
    *@Author: ChaiYanShun
    *@Create: 2018/11/29 14:06
    *@Param [subcQualifiDTO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/saveSubcQuali",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveSubcQuali(@RequestBody SubcQualifiDTO subcQualifiDTO){
        log.debug("新增分包方资质信息 Param:" + JSON.toJSONString(subcQualifiDTO)  + " Time: " + new Date());
        try {
            Integer num =subcQualifiService.insertSubcQuali(subcQualifiDTO);
            if(num != null && num != 0) {
                log.debug("新增分包方资质信息结果：保存数量" + num);
                return ResultT.success("新增分包方资质信息成功");
             }
        } catch (Exception e) {
            log.error("新增分包方资质信息失败",e);
        }
         return ResultT.failure(ResultCode.ADD_FAILURE);
     }

    /**
    *@Description: 删除分包方资质信息
    *@Author: ChaiYanShun
    *@Create: 2018/11/29 18:14
    *@Param [subcQualifiDTO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/removeSubcQuali",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT removeSubcQuali(@RequestBody SubcQualifiDTO subcQualifiDTO){
        log.debug("删除分包方资质信息 Param:" + JSON.toJSONString(subcQualifiDTO)  + " Time: " + new Date());
        try {
            Integer num=subcQualifiService.deleteSubcQuali(subcQualifiDTO);
            if(num != null && num != 0) {
                log.debug("删除分包方资质信息结果：删除数量" + num);
                return ResultT.success("删除分包方资质信息成功");
            }
        } catch (Exception e) {
            log.error("删除分包方资质信息失败",e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }

    /**
    *@Description: 修改分包方资质信息
    *@Author: ChaiYanShun
    *@Create: 2018/11/29 18:16
    *@Param [subcQualifiDO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/updateSubcQuali",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateSubcQuali(@RequestBody SubcQualifiDO subcQualifiDO){
        log.debug("开始修改分包方资质信息 Param:" + JSON.toJSONString(subcQualifiDO)  + " Time: " + new Date());
        try {
            Integer num=subcQualifiService.updateSubcQuali(subcQualifiDO);
            if(num != null && num != 0) {
                log.debug("修改分包方资质信息结果：更新数量" + num);
                return ResultT.success("修改分包方资质信息成功");
            }
        } catch (Exception e) {
            log.error("修改分包方资质信息失败",e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**
    *@Description: 获取分包方资质信息
    *@Author: ChaiYanShun
    *@Create: 2018/11/29 18:18
    *@Param [subcQualifiDORequstBody]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/getSubcQuali",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getSubcQuali(@RequestBody SubcQualifiDO subcQualifiDORequstBody){
        log.debug("开始获取分包方资质信息 Param:" + JSON.toJSONString(subcQualifiDORequstBody)  + " Time: " + new Date());
        try {
            SubcQualifiDO subcQualifiDO=subcQualifiService.getSubcQuali(subcQualifiDORequstBody);
            if(subcQualifiDO != null) {
                log.debug("获取分包方资质信息：" + subcQualifiDO);
                return ResultT.success(subcQualifiDO);
            }
        } catch (Exception e) {
            log.error("获取分包方资质信息失败",e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }

}
