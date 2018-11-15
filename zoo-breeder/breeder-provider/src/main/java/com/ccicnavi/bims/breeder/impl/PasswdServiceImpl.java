package com.ccicnavi.bims.breeder.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.PasswdService;
import com.ccicnavi.bims.breeder.manager.CryptoManager;

/**
 * @Auther: husky
 * @Date: 2018/11/15 10:53
 * @Version 0.1
 * @Description:
 */
@Service
public class PasswdServiceImpl implements PasswdService {

    @Override
    public String getSalt() {
        return CryptoManager.getSalt();
    }

    @Override
    public String getHash(String password, String salt) {
        return CryptoManager.getHash(password,salt);
    }

    @Override
    public boolean verify(String hashedPassword, String password, String salt) {
        return CryptoManager.verify(hashedPassword,password,salt);
    }
}
