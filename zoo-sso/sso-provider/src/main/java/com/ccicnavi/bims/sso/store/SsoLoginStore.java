package com.ccicnavi.bims.sso.store;

import com.alibaba.fastjson.JSONObject;
import com.ccicnavi.bims.sso.common.conf.Conf;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.sso.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * local login store
 *
 * @author xuxueli 2018-04-02 20:03:11
 */
@Component
public class SsoLoginStore {

    private static int redisExpireMinite = 1440;    // 1440 minite, 24 hour

    @Autowired
    private JedisUtil jedisUtil;


    public static void setRedisExpireMinite(int redisExpireMinite) {
        if (redisExpireMinite < 30) {
            redisExpireMinite = 30;
        }
        SsoLoginStore.redisExpireMinite = redisExpireMinite;
    }
    public static int getRedisExpireMinite() {
        return redisExpireMinite;
    }

    /**
     * get
     *
     * @param storeKey
     * @return
     */
    public SSOUser get(String storeKey) {

        String redisKey = redisKey(storeKey);
        Object objectValue = jedisUtil.getObjectValue(redisKey);
        if (objectValue != null) {
            return JSONObject.parseObject(JSONObject.toJSONString(objectValue),SSOUser.class);
        }
        return null;
    }

    /**
     * remove
     *
     * @param storeKey
     */
    public void remove(String storeKey) {
        String redisKey = redisKey(storeKey);
        jedisUtil.del(redisKey);
    }

    /**
     * put
     *
     * @param storeKey
     * @param xxlUser
     */
    public void put(String storeKey, SSOUser xxlUser) {
        String redisKey = redisKey(storeKey);
        jedisUtil.setObjectValue(redisKey, xxlUser, redisExpireMinite,TimeUnit.MINUTES);  // minite to second
    }


    /**
     * 设置到登录列表中
     * @param storeKey
     */
    public void setLoginOn(String storeKey){
        String redisKey = loginONnRedisKey(storeKey);
        jedisUtil.setSetValue(redisKey,System.currentTimeMillis());
    }

    /**
     * 判断登录用户列表是否存在该用户
     * @param storeKey
     */
    public boolean hasLandedOnKey(String storeKey){
        String redisKey = loginONnRedisKey(storeKey);
        return jedisUtil.hasKey(redisKey);
    }


    private static String loginONnRedisKey(String sessionId){
        return Conf.SSO_LANDED_ON.concat(":").concat(sessionId);
    }

    private static String redisKey(String sessionId){
        return Conf.SSO_SESSIONID.concat(":").concat(sessionId);
    }



}
