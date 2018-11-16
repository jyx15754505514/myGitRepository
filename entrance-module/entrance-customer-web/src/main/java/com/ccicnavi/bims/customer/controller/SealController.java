//package com.ccicnavi.bims.customer.controller;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.ccicnavi.bims.common.ResultCode;
//import com.ccicnavi.bims.common.ResultT;
//import com.ccicnavi.bims.resource.api.SealService;
//import com.ccicnavi.bims.resource.pojo.SealDO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * @program: bims-backend
// * @description: （封识）增删改查
// * @author: zhangpengwei
// * @create: 2018-11-15 21:55
// */
//@RestController
//@RequestMapping("/seal")
//public class SealController {
//
//    private final static Logger log = LoggerFactory.getLogger(SealController.class);
//
//    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20882")
//    SealService sealService;
//
//    @RequestMapping(value = "/ListSeal", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    public ResultT sayHello(@RequestBody SealDO sealDO ){
//        List<SealDO> sealDOList = null;
//        try {
//            sealDOList = sealService.listSealDO(sealDO);
//            return ResultT.success(sealDOList);
//        } catch (Exception e) {
//            log.debug("根据条件查询封识失败", e);
//            return ResultT.failure(ResultCode.LIST_SEAL_FAILURE);
//        }
//    }
//}