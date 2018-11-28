package com.ccicnavi.bims.base.controller;

import com.ccicnavi.bims.sso.api.SSOService;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.sso.common.result.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @Title: BaseController.java
 * @Package et.yuanh.client.base
 * @Description: controller基础类
 * @author zhaotao
 * @date 2018年11月26日 下午11:32:36
 * @version V1.0
 */
@Component
public class BaseController {

    @Autowired
    private HttpServletRequest request;

    @Reference(timeout = 30000)
//    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20896")
    private SSOService ssoService;

    public SSOUser getUserInfo() {
        String jsessionID = request.getHeader("jsessionID");
        ReturnT<SSOUser> logincheck = ssoService.logincheck(jsessionID);
        SSOUser SSOUser = logincheck.getData();
        return SSOUser;
    }


}
