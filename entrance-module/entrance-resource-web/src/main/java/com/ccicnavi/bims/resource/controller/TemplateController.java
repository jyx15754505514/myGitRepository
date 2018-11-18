package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.TemplateService;
import com.ccicnavi.bims.resource.pojo.TemplateDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TemplateController
 * @description: 模板controller
 * @author: zhaotao
 * @create: 2018-11-15 20:09
 **/
@RestController
@RequestMapping("/template")
public class TemplateController {

    private final static Logger log = LoggerFactory.getLogger(TemplateController.class);

    //url指定dubbo的地址
    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20881")
    private TemplateService templateService;

    /*
    * 根据条件查询模板
    * @Author zhaotao
    * @Date  2018/11/15 21:49
    * @Param [Template]   封装请求参数的实体对象
    * @return com.ccicnavi.bims.common.ResultT   返回的结果类
    **/
    @RequestMapping(value = "/listTemplate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT ListTemplate(@RequestBody PageParameter parameter) {
        try {
            PageBean<TemplateDO> pageBean = templateService.listTemplate(parameter);
            return ResultT.success(pageBean);
        }catch (Exception e) {
            log.debug("根据条件查询模板失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /*
    * 新增模板
    * @Author zhaotao
    * @Date  2018/11/15 22:03
    * @Param [Template]
    * @return com.ccicnavi.bims.common.ResultT
    **/
    @RequestMapping(value = "/insertTemplate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertTemplate(@RequestBody TemplateDO template) {
        try {
            Integer insertResult = templateService.insertTemplate(template);
            if(insertResult != null && insertResult > 0) {
                return ResultT.success();
            }
        }catch (Exception e) {
            log.debug("新增模板失败", e);
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /*
    * 单个或批量更新模板
    * @Author zhaotao
    * @Date  2018/11/15 22:03
    * @Param [Template]
    * @return com.ccicnavi.bims.common.ResultT
    **/
    @RequestMapping(value = "/updateTemplate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateTemplate(@RequestBody TemplateDO template) {
        try {
            Integer updateResult = templateService.updateTemplate(template);
            if(updateResult != null && updateResult > 0) {
                return ResultT.success();
            }
        }catch (Exception e) {
            log.debug("更新模板失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /*
     * 单个或批量删除模板
     * @Author zhaotao
     * @Date  2018/11/15 22:03
     * @Param [Template]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/deleteTemplate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteTemplate(@RequestBody TemplateDO template) {
        try {
            Integer deleteResult = templateService.deleteTemplate(template);
            if(deleteResult != null && deleteResult > 0) {
                return ResultT.success();
            }
        }catch (Exception e) {
            log.debug("删除模板失败", e);
        }
            return ResultT.failure(ResultCode.DELETE_FAILURE);
    }

    /*
     * 获取指定模板
     * @Author zhaotao
     * @Date  2018/11/15 22:03
     * @Param [Template]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/getTemplate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getTemplate(@RequestBody TemplateDO template) {
        try {
            TemplateDO resultBean = templateService.getTemplate(template);
            if(resultBean != null) {
                return ResultT.success(resultBean);
            }
        }catch (Exception e) {
            log.debug("获取指定模板失败", e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }

}
