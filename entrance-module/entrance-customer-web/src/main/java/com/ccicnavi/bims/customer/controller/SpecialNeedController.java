package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.SpecialNeedService;
import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: congzhiyuan
 * @Date: 2018/11/27 17:30
 * @Description: 客户特殊需求功能管理
 * @Version 1.0
 */
@RestController
@RequestMapping("/specialNeed")
public class SpecialNeedController {

    private final static Logger log = LoggerFactory.getLogger(SpecialNeedController.class);
    @Reference(timeout = 30000)
    SpecialNeedService specialNeedService;

    /**
     *@Description: 查询客户信息(分页)
     *@Param: pageParameter
     *@return: PageBean<CustomerDO>
     *@Author: zqq
     *@date: 2018/11/19
     */

    @RequestMapping(value = "/getSpecialNeedPageData", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getSpecialNeedPageData(@RequestBody PageParameter<SpecialNeedDO> pageParameter) {
        try {
            PageBean<SpecialNeedDO> specialNeedPage = specialNeedService.getSpecialNeedPage(pageParameter);
            return ResultT.success(specialNeedPage);
        } catch (Exception e) {
            log.error("分页查询客户特殊需求失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
     * 功能描述: 获取跟进人详细信息
     * @param: custMgrDO
     * @return: ResultT
     * @date: 2018/11/27 11:58
     * @auther: congzhiyuan
     */
    @RequestMapping(value = "/getSpecialNeed", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getSpecialNeed(@RequestBody SpecialNeedDO specialNeedDO) {
        try {
            SpecialNeedDO result = specialNeedService.getSpecialNeed(specialNeedDO);
            if (result != null) {
                return ResultT.success(result);
            }
        } catch (Exception e) {
            log.error("根据主键查询客户特殊需求失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
     * 功能描述: 添加客户跟进人信息
     * @param: custMgrDO
     * @return: ResultT
     * @date: 2018/11/27 11:58
     * @auther: congzhiyuan
     */
    @RequestMapping(value = "/saveSpecialNeed", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveSpecialNeed(@RequestBody SpecialNeedDO specialNeedDO) {
        try {
            Integer count = specialNeedService.saveSpecialNeed(specialNeedDO);
            if (count > 0) {
                return ResultT.success("新增客户跟进人成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增客户特殊需求失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }
    /**
     * 功能描述: 删除客户跟进人信息
     * @param: custMgrDO
     * @return: ResultT
     * @date: 2018/11/27 11:58
     * @auther: congzhiyuan
     */
    @RequestMapping(value = "/removeSpecialNeed", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public ResultT removeSpecialNeed(@RequestParam("needUuid") String needUuid) {
        try {
            Integer count = specialNeedService.removeSpecialNeed(needUuid);
            if (count > 0) {
                return ResultT.success("删除客户特殊需求成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("删除客户特殊需求失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }
}
