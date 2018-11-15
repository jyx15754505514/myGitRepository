package com.ccicnavi.bims.breeder.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.breeder.manager.IdWorkerManager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: husky
 * @Date: 2018/11/15 10:34
 * @Version 0.1
 * @Description:
 */
@Service
public class IdWorkerServiceImpl implements IdWorkerService {
    private static IdWorkerManager idWorkerManager= new IdWorkerManager(1, 1);
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyMMddHHmmss");

    @Override
    public String getId(Date date) {
        String id = timeFormat.format(date) + String.valueOf(idWorkerManager.nextId());
        return id;
    }
}
