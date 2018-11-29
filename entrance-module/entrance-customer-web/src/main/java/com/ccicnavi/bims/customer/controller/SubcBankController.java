package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.customer.api.SubcBankService;
import com.ccicnavi.bims.customer.pojo.SubBankDO;
import com.ccicnavi.bims.customer.pojo.SubBankDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 分包方银行信息
 * @ClassName: SubcBankController
 * @author: chaiyanshun
 * @create: 2018-11-15 20:09
 **/
@RestController
@RequestMapping("/subcBank")
public class SubcBankController {

    private final static Logger log= LoggerFactory.getLogger(SubcBankController.class);

    @Reference(timeout = 30000)
    SubcBankService subcBankService;

    /**
    *@description: 查询指定分包方下的银行信息
    *@author: ChaiYanShun
    *@create: 2018/11/25 10:11
    *@Param [subcontractorDTO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/listSubcBank", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listSubcBank(@RequestBody SubcontractorDTO subcontractorDTO){
        log.debug("根据分包商uuid获取分包方银行列表 Param:" + JSON.toJSONString(subcontractorDTO)  + " Time: " + new Date());
        //判断分包方id是否存在
        if(StringUtils.isEmpty(subcontractorDTO.getSubcUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            List<SubBankDO> subBankList = subcBankService.listSubcBank(subcontractorDTO);
            if(subBankList != null && subBankList.size() > 0){
                log.debug("获取分包方银行列表结果：" + JSON.toJSONString(subBankList));
                return ResultT.success(subBankList);
            }
        } catch (Exception e) {
            log.error("查询指定分包方下的银行信息失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
    *@description: 分包方银行信息添加
    *@author: ChaiYanShun
    *@create: 2018/11/25 10:37
    *@Param [subBank]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/insertSubcBank", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertSubcBank(@RequestBody SubBankDO subBank){
        log.debug("保存分包方银行信息 Param:" + JSON.toJSONString(subBank)  + " Time: " + new Date());
        try {
            Integer num = subcBankService.insertSubcBank(subBank);
            if(num != null && num != 0) {
                log.debug("保存分包方银行信息结果：保存数量" + num);
                return ResultT.success("分包方银行信息添加成功");
            }
        } catch (Exception e) {
            log.error("分包方银行信息添加失败",e);
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /**
    *@description: 分包方银行删除
    *@author: ChaiYanShun
    *@create: 2018/11/25 10:48
    *@Param [subBankDTO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/deleteSubcBank", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteSubcBank(@RequestBody SubBankDTO subBankDTO){
        log.debug("删除分包方银行信息 Param:" + JSON.toJSONString(subBankDTO)  + " Time: " + new Date());
        try {
            Integer num = subcBankService.deleteSubcBank(subBankDTO);
            if(num != null && num != 0) {
                log.debug("删除分包方银行信息结果：删除数量" + num);
                return ResultT.success("分包方银行信息删除成功");
            }
        } catch (Exception e) {
            log.error("分包方银行信息删除失败",e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }

    /**
    *@description: 分包方银行修改
    *@author: ChaiYanShun
    *@create: 2018/11/25 11:07
    *@Param [subBank]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/updateSubcBank", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateSubcBank(@RequestBody SubBankDO subBank){
        log.debug("开始更新分包方银行信息 Param:" + JSON.toJSONString(subBank)  + " Time: " + new Date());
        try {
            Integer num = subcBankService.updateSubcBank(subBank);
            if(num != null && num != 0) {
                log.debug("更新分包方银行信息结果：更新数量" + num);
                return ResultT.success("分包方银行信息修改成功");
            }
        } catch (Exception e) {
            log.error("分包方银行信息修改成功",e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**
    *@description: 根据分包方信息查看指定得银行信息
    *@author: ChaiYanShun
    *@create: 2018/11/25 11:18
    *@Param [subBank]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/getSubcBank", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getSubcBank(@RequestBody SubBankDO subBank){
        log.debug("开始根据分包方信息查看指定得银行信息 Param:" + JSON.toJSONString(subBank)  + " Time: " + new Date());
        try {
            SubBankDO resultBean = subcBankService.getSubcBank(subBank);
            if(resultBean != null) {
                log.debug("根据分包方信息查看指定得银行信息：" + resultBean);
                return ResultT.success(resultBean);
            }
        } catch (Exception e) {
            log.error("根据分包方信息查看指定得银行信息失败",e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }
}
