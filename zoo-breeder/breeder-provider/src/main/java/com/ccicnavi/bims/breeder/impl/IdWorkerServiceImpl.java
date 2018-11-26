package com.ccicnavi.bims.breeder.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.breeder.domain.Constants;
import com.ccicnavi.bims.breeder.manager.IdWorkerManager;
import com.ccicnavi.bims.breeder.util.NumberUtails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.util.NumberUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: husky
 * @Date: 2018/11/15 10:34
 * @Version 0.1
 * @Description:
 */
@Service
@Slf4j
public class IdWorkerServiceImpl implements IdWorkerService {
    @Autowired
    RedisTemplate redisTemplate;
    private static IdWorkerManager idWorkerManager = new IdWorkerManager(1, 1);
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyMMddHHmmss");

    @Override
    public String getId(Date date) {
        String id = timeFormat.format(date) + String.valueOf(idWorkerManager.nextId());
        return id;
    }

    @Override
    public String getBusinessNumber(String sysUID, long initValue, String step, String cycle) {
        Long incr = null;
        try {
            incr = incr(sysUID,initValue,
                    "D".equals(cycle) ? Constants.SECONDS_DAY :
                            ("W".equals(cycle) ? Constants.SECONDS_WEEK :
                                    ("M".equals(cycle) ? Constants.SECONDS_MONTH :
                                            Constants.SECONDS_YEAR)));
        } catch (Exception e) {
            log.error("", e);
            throw new RuntimeException();
        }
        return String.valueOf(incr);
    }

    private Long incr(String key,long initValue, long liveTime) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();
        if ((null == increment || increment.longValue() == 0) && liveTime > 0) {
            entityIdCounter.set(initValue);
            entityIdCounter.expire(liveTime, TimeUnit.SECONDS);
        }
        return entityIdCounter.addAndGet(increment);
    }
}
