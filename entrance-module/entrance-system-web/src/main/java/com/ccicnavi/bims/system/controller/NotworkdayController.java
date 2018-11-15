package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;
import com.ccicnavi.bims.system.service.api.NotworkdayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @RequestMapping(value = "/ListNotworkday", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT ListNotworkday(@RequestBody NotworkdayDO notworkday) {
        try {
            List<NotworkdayDO> notworkdayList = notworkdayService.listNotworkday(notworkday);
            //请求成功返回并设置返回数据
            return ResultT.success(notworkdayList);
        }catch (Exception e) {
            log.debug("根据条件查询非工作日失败", e);
            //请求失败返回并设置错误信息
            return ResultT.failure(ResultCode.NOTWORKDAY_LIST_NOTWORKDAY);
        }
    }



}
