package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.DemoService;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-15 15:46
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello() {
        return "你好~sssssssssssssssss~";
    }
}
