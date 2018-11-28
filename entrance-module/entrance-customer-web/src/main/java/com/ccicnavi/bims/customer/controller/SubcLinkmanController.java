package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.customer.api.SubcLinkmanService;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDO;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 分包方联系人
 * @author: limin
 * @create: 2018-11-25 09:58
 */
@Slf4j
@RestController
@RequestMapping(value = "/subcLinkman")
public class SubcLinkmanController {


    @Reference(timeout = 30000)
    SubcLinkmanService subcLinkmanService;

    /**
    * TODO 分包方联系人列表（不分页）
    * @Param subcontractorDTO
    * @return ResultT
    * @Author limin
    * @Date  2018/11/25 10:24
    **/
    @RequestMapping(value = "/listSubcLinkman",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    private ResultT listSubcLinkman(@RequestBody SubcontractorDTO subcontractorDTO){
        log.info("开始获取联系人列表根据分包商uuid Param:" + JSON.toJSONString(subcontractorDTO)  + " Time: " + new Date());
        //判断参数是否存在，如果不存在直接返回
        if(StringUtils.isEmpty(subcontractorDTO.getSubcUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            //调用中台层接口
            List<SubLinkmanDO> subLinkmanDOList= subcLinkmanService.listSubcLinkman(subcontractorDTO);
            if(subLinkmanDOList != null && subLinkmanDOList.size() > 0){
                log.info("获取联系人列表结果：" + JSON.toJSONString(subcontractorDTO));
                return ResultT.success(subLinkmanDOList);
            }
            log.info("根据分包商获取联系人列表异常");
            return ResultT.failure(ResultCode.LIST_FAILURE);
        } catch (Exception e) {
            log.error("根据分包商获取联系人列表异常" + e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }



    /**
     * TODO 新增分包方联系人信息
     * @Param subcontractorDTO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/25 10:24
     **/
    @RequestMapping(value = "/insertSubcLinkman",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    private ResultT insertSubcLinkman(@RequestBody SubLinkmanDO subLinkmanDO){
        log.info("开始保存分包方联系人信息 Param:" + JSON.toJSONString(subLinkmanDO)  + " Time: " + new Date());
        try {
            Integer count = subcLinkmanService.insertSubcLinkman(subLinkmanDO);
            if(count >= 1){
                log.info("保存分包方联系人信息结果：保存数量" + count);
                return ResultT.success();
            }
            log.info("保存分包方联系人信息异常");
            return ResultT.failure(ResultCode.ADD_FAILURE);
        } catch (Exception e) {
            log.error("保存分包方联系人信息异常" + e );
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }

    }



    /**
     * TODO 修改分包方联系人信息
     * @Param subcontractorDTO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/25 10:24
     **/
    @RequestMapping(value = "/updateSubcLinkman",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    private ResultT updateSubcLinkman(@RequestBody SubLinkmanDO subLinkmanDO){
        log.info("开始更新分包方联系人信息 Param:" + JSON.toJSONString(subLinkmanDO)  + " Time: " + new Date());
        if(StringUtils.isEmpty(subLinkmanDO.getLinkmanUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            Integer count = subcLinkmanService.updateSubcLinkman(subLinkmanDO);
            if(count >= 1){
                log.info("更新分包方联系人信息结果：更新数量" + count);
                return ResultT.success();
            }
            log.info("更新分包方联系人信息异常");
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        } catch (Exception e) {
            log.error("更新分包方联系人信息异常" + e );
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }


    /**
     * TODO 删除分包方联系人信息（支持批量）
     * @Param subcontractorDTO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/25 10:24
     **/
    @RequestMapping(value = "/deleteSubcLinkman",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    private ResultT deleteSubcLinkman(@RequestBody SubLinkmanDTO subLinkmanDTO){
        log.info("开始移除分包方联系人信息 Param:" + JSON.toJSONString(subLinkmanDTO)  + " Time: " + new Date());
        if(subLinkmanDTO.getLinkmanUuids() == null || (subLinkmanDTO.getLinkmanUuids() != null && subLinkmanDTO.getLinkmanUuids().size() == 0)){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            Integer count = subcLinkmanService.deleteSubcLinkman(subLinkmanDTO);
            if(count >= 1){
                log.info("移除分包方联系人信息结果：移除数量" + count);
                return ResultT.success();
            }
            log.info("移除分包方联系人信息异常");
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        } catch (Exception e) {
            log.error("移除分包方联系人信息异常" + e );
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }

    }


    /**
     * TODO 分包方联系人信息编辑获取
     * @Param subcontractorDTO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/25 10:24
     **/
    @RequestMapping(value = "/getSubcLinkman",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    private ResultT getSubcLinkman(@RequestBody SubLinkmanDO subLinkmanDO){
        log.info("开始获取分包方联系人信息 Param:" + JSON.toJSONString(subLinkmanDO)  + " Time: " + new Date());
        if(StringUtils.isEmpty(subLinkmanDO.getLinkmanUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            SubLinkmanDO subLinkman = subcLinkmanService.getSubcLinkman(subLinkmanDO);
            if(subLinkman != null && !StringUtils.isEmpty(subLinkman.getSubcUuid())){
                log.info("获取分包方联系人信息结果：" + JSON.toJSONString(subLinkman));
                return ResultT.success(subLinkman);
            }
            log.info("获取分包方联系人信息异常");
            return ResultT.failure(ResultCode.GET_FAILURE);
        } catch (Exception e) {
            log.error("获取分包方联系人信息异常" + e );
            return ResultT.failure(ResultCode.GET_FAILURE);
        }

    }





}
