package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.customer.api.SubcLinkmanService;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDO;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
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
    * TODO 分包商联系人列表（不分页）
    * @Param subcontractorDTO
    * @return ResultT
    * @Author limin
    * @Date  2018/11/25 10:24
    **/
    @RequestMapping(value = "/listSubcLinkman",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    private ResultT listSubcLinkman(@RequestBody SubcontractorDTO subcontractorDTO){
        //判断参数是否存在，如果不存在直接返回
        if(subcontractorDTO.getSubcUuid() == null || !"".equals(subcontractorDTO.getSubcUuid()) ){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            //调用中台层接口
            List<SubLinkmanDO> subLinkmanDOList= subcLinkmanService.listSubcLinkman(subcontractorDTO);
            if(subLinkmanDOList != null && subLinkmanDOList.size() > 0){
                return ResultT.success(subLinkmanDOList);
            }
            return ResultT.failure(ResultCode.LIST_FAILURE);
        } catch (Exception e) {
            log.error("根据分包商获取联系人列表失败" + e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }



    /**
     * TODO 新增分包商联系人信息
     * @Param subcontractorDTO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/25 10:24
     **/
    @RequestMapping(value = "/insertSubcLinkman",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    private ResultT insertSubcLinkman(@RequestBody SubLinkmanDO subLinkmanDO){

        try {
            Integer num = subcLinkmanService.insertSubcLinkman(subLinkmanDO);
            if(num == 1){
                return ResultT.success();
            }
            return ResultT.failure(ResultCode.ADD_FAILURE);
        } catch (Exception e) {
            log.error("新增分包联系人信息失败" + e );
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }

    }



    /**
     * TODO 修改分包商联系人信息
     * @Param subcontractorDTO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/25 10:24
     **/
    @RequestMapping(value = "/updateSubcLinkman",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    private ResultT updateSubcLinkman(@RequestBody SubLinkmanDO subLinkmanDO){
        if(subLinkmanDO.getLinkmanUuid() == null || "".equals(subLinkmanDO.getLinkmanUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }

        try {
            Integer num = subcLinkmanService.updateSubcLinkman(subLinkmanDO);
            if(num == 1){
                return ResultT.success();
            }
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        } catch (Exception e) {
            log.error("修改分包联系人信息失败" + e );
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }


    /**
     * TODO 删除分包商联系人信息（支持批量）
     * @Param subcontractorDTO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/25 10:24
     **/
    @RequestMapping(value = "/deleteSubcLinkman",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    private ResultT deleteSubcLinkman(@RequestBody SubLinkmanDTO subLinkmanDTO){
        if(subLinkmanDTO.getLinkmanUuids() == null || (subLinkmanDTO.getLinkmanUuids() != null && subLinkmanDTO.getLinkmanUuids().size() == 0)){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            Integer num = subcLinkmanService.deleteSubcLinkman(subLinkmanDTO);
            if(num >= 1){
                return ResultT.success();
            }
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        } catch (Exception e) {
            log.error("删除分包联系人信息失败" + e );
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }

    }


    /**
     * TODO 分包商联系人信息编辑获取
     * @Param subcontractorDTO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/25 10:24
     **/
    @RequestMapping(value = "/getSubcLinkman",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    private ResultT getSubcLinkman(@RequestBody SubLinkmanDO subLinkmanDO){
        log.info(subLinkmanDO.getLinkmanUuid());
        if(subLinkmanDO.getLinkmanUuid() == null || "".equals(subLinkmanDO.getLinkmanUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }

        try {
            SubLinkmanDO subLinkman = subcLinkmanService.getSubcLinkman(subLinkmanDO);
            if(subLinkman != null && subLinkman.getSubcUuid() != null && !"".equals(subLinkman.getSubcUuid())){
                return ResultT.success(subLinkman);
            }
            return ResultT.failure(ResultCode.GET_FAILURE);
        } catch (Exception e) {
            log.error("获取分包联系人信息失败" + e );
            return ResultT.failure(ResultCode.GET_FAILURE);
        }

    }





}
