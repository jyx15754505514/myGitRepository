package com.ccicnavi.bims.breeder;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.breeder.api.PasswdService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: husky
 * @Date: 2018/11/15 11:04
 * @Version 0.1
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BreederApplication.class)
@Slf4j
public class BreederApplicationTest {
    @Reference(url = "dubbo://127.0.0.1:20880")
    IdWorkerService idWorkerService;

    @Reference(url = "dubbo://192.168.125.11:20880")
    PasswdService passwdService;

    @Test
    public void test1() {
        String id = idWorkerService.getId(new Date());
        log.info("id:{},length:{}", id, id.length());
        String salt = passwdService.getSalt();
        log.info("salt:{}", salt);
        String hash = passwdService.getHash("123456", salt);
        log.info("hash:{},length:{}", hash, hash.length());
        boolean verify = passwdService.verify(hash, "123455", salt);
        log.info("verify:{}", verify);

    }

    @Test
    public void test() {
        String v = idWorkerService.getBusinessNumber("YHYHYHYH", 3000, "4", "Y");
        System.out.println(v);
    }

}
