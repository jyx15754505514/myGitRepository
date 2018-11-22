package com.ccicnavi.bims.sso.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.sso.SSOApplication;
import com.ccicnavi.bims.sso.api.SSOService;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.sso.common.result.ReturnT;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SSOApplication.class)
public class SSOTest {

    @Reference(timeout = 10000,url = "dubbo://192.168.11.15:20896")
    SSOService ssoService;


    @Test
    public void login(){
        SSOUser userInfo = new SSOUser();
        userInfo.setUserUuid(UUID.randomUUID().toString());
        userInfo.setNickName("张三");
        ReturnT<String> returnT = ssoService.login(userInfo);

        Assert.assertEquals(200,returnT.getCode());
        System.out.println(returnT.getData());
    }

    @Test
    public void logOut(){
        ReturnT<String> returnT = ssoService.logout("8863ca06-7f54-48f4-9232-674f00378ef1_e951997abda54948af3f93e8be2b4d92");
        Assert.assertEquals(200,returnT.getCode());
        System.out.println(returnT.getData());
    }

    @Test
    public void logincheck(){
        ReturnT<SSOUser> returnT = ssoService.logincheck("8863ca06-7f54-48f4-9232-674f00378ef1_e951997abda54948af3f93e8be2b4d92");
        Assert.assertEquals(200,returnT.getCode());
        System.out.println(returnT.getData());
    }

    @Test
    public void checkAccess(){
        ReturnT<SSOUser> returnT = ssoService.checkAccess("8863ca06-7f54-48f4-9232-674f00378ef1_e951997abda54948af3f93e8be2b4d92","/application/hello.do");
        Assert.assertEquals(200,returnT.getCode());
        System.out.println(returnT.getData());
    }


}
