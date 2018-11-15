package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.Application;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.service.api.PageDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Reference(timeout = 1000000,url = "dubbo://127.0.0.1:20881")
    PageDemoService pageDemoService;
    @Test
    public void main() {
        PageParameter<RoleDO> pageParameter = new PageParameter<>();
        pageParameter.startPage = 1;
        pageParameter.pageRows = 2;
        RoleDO roleDO = new RoleDO();
        roleDO.setRoleCode("2");
        pageParameter.setParameter(roleDO);

        String rpageParameterString = JSONObject.toJSONString(pageParameter);
        PageBean<RoleDO> roleDOPageBean = pageDemoService.testPage(pageParameter);
        String roleString = JSONObject.toJSONString(roleDOPageBean);

        System.out.println(rpageParameterString);
        System.out.println(roleString);
    }
}