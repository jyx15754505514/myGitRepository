package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;
import com.ccicnavi.bims.system.service.api.NotworkdayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: NotworkdayController
 * @description: 非工作日客户端
 * @author: zhaotao
 * @create: 2018-11-15 20:09
 **/
@RestController
@RequestMapping("/notworkday")
public class NotworkdayController {

    private final static Logger log = LoggerFactory.getLogger(NotworkdayController.class);

    //url 指定dubbo的地址
    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20881")
    private NotworkdayService notworkdayService;

    /*
    * 根据条件查询非工作日
    * @Author zhaotao
    * @Date  2018/11/15 21:49
    * @Param [notworkday]   封装请求参数的实体对象
    * @return com.ccicnavi.bims.common.ResultT   返回的结果类
    **/
    @RequestMapping(value = "/listNotworkday", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT ListTemplate(@RequestBody PageParameter parameter) {
        try {
            return notworkdayService.listNotworkday(parameter);
        }catch (Exception e) {
            log.debug("根据条件查询模板失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /*
    * 新增非工作日
    * @Author zhaotao
    * @Date  2018/11/15 22:03
    * @Param [notworkday]
    * @return com.ccicnavi.bims.common.ResultT
    **/
    @RequestMapping(value = "/insertNotworkday", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertNotworkday(@RequestBody NotworkdayDO notworkday) {
        try {
            Integer insertResult = notworkdayService.insertNotworkday(notworkday);
            if(insertResult != null && insertResult != 0) {
                return ResultT.success();
            }
        }catch (Exception e) {
            log.debug("新增非工作日失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /*
    * 单个或批量更新非工作日
    * @Author zhaotao
    * @Date  2018/11/15 22:03
    * @Param [notworkday]
    * @return com.ccicnavi.bims.common.ResultT
    **/
    @RequestMapping(value = "/updateNotworkday", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateNotworkday(@RequestBody NotworkdayDO notworkday) {
        try {
            Integer updateResult = notworkdayService.updateNotworkday(notworkday);
            if(updateResult != null && updateResult != 0) {
                return ResultT.success();
            }
        }catch (Exception e) {
            log.debug("更新非工作日失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /*
     * 单个或批量删除非工作日
     * @Author zhaotao
     * @Date  2018/11/15 22:03
     * @Param [notworkday]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/deleteNotworkday", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteNotworkday(@RequestBody NotworkdayDO notworkday) {
        try {
            Integer deleteResult = notworkdayService.deleteNotworkday(notworkday);
            if(deleteResult != null && deleteResult != 0) {
                return ResultT.success();
            }
        }catch (Exception e) {
            log.debug("删除非工作日失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /*
     * 获取指定非工作日
     * @Author zhaotao
     * @Date  2018/11/15 22:03
     * @Param [notworkday]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/getNotworkday", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getNotworkday(@RequestBody NotworkdayDO notworkday) {
        try {
            NotworkdayDO resultBean = notworkdayService.getNotworkday(notworkday);
            if(resultBean != null) {
                return ResultT.success();
            }
        }catch (Exception e) {
            log.debug("获取指定非工作日失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

}
