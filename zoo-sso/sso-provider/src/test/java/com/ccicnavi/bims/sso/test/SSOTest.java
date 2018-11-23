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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SSOApplication.class)
public class SSOTest {

    @Reference(timeout = 10000,url = "dubbo://127.0.0.1:20896")
    SSOService ssoService;


    @Test
    public void login(){
        SSOUser userInfo = new SSOUser();
        userInfo.setUserUuid(UUID.randomUUID().toString());
        userInfo.setNickName("张三");
        List<String> btnUrlList = new ArrayList<>();
        btnUrlList.add("/application/hello.do");
        userInfo.setBtnUrlList(btnUrlList);
        ReturnT<String> returnT = ssoService.login(userInfo);

        System.out.println(returnT.getData());
        Assert.assertEquals(1,returnT.getCode());
    }

    @Test
    public void logOut(){
        ReturnT<String> returnT = ssoService.logout("8863ca06-7f54-48f4-9232-674f00378ef1_e951997abda54948af3f93e8be2b4d92");
        System.out.println(returnT.getData());
        Assert.assertEquals(1,returnT.getCode());
    }

    @Test
    public void logincheck(){
        ReturnT<SSOUser> returnT = ssoService.logincheck("cc780768-006d-4502-9af2-5260c5809ba4_bd24949b60a9479aae37ec5636625513");
        System.out.println(returnT.getMsg());
        System.out.println(returnT.getData());
        Assert.assertEquals(1,returnT.getCode());
    }

    @Test
    public void checkAccess(){
        ReturnT<SSOUser> returnT = ssoService.checkAccess("75933b02-fc1d-4253-a4fc-d236c4fe3e9f_efe865c063fc4715b0e86e1cc97ff333","/application/helloo.do");
        System.out.println(returnT.getMsg());
        System.out.println(returnT.getData());
        Assert.assertEquals(1,returnT.getCode());
    }


}
