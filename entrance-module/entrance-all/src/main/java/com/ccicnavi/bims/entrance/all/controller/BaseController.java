package com.ccicnavi.bims.entrance.all.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.sso.api.SSOService;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.sso.common.result.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * controller基础类
 *
 * @author TXW
 * @date 2018/11/29 18:29
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
