package com.ccicnavi.bims.sso.login;

import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.sso.common.store.SsoSessionIdHelper;
import com.ccicnavi.bims.sso.store.SsoLoginStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xuxueli 2018-11-15 15:54:40
 */
@Component
public class SsoTokenLoginHelper {

    @Autowired
    SsoLoginStore ssoLoginStore;

    /**
     * client login
     *
     * @param sessionId
     * @param xxlUser
     */
    public void login(String sessionId, SSOUser xxlUser) {

        String storeKey = SsoSessionIdHelper.parseStoreKey(sessionId);
        if (storeKey == null) {
            throw new RuntimeException("parseStoreKey Fail, sessionId:" + sessionId);
        }

        ssoLoginStore.put(storeKey, xxlUser);
        ssoLoginStore.setLoginOn(storeKey);
    }

    /**
     * client logout
     *
     * @param sessionId
     */
    public void logout(String sessionId) {

        String storeKey = SsoSessionIdHelper.parseStoreKey(sessionId);
        if (storeKey == null) {
            return;
        }

        ssoLoginStore.remove(storeKey);
    }


    /**
     * login check
     *
     * @param sessionId
     * @return
     */
    public SSOUser loginCheck(String  sessionId){

        String storeKey = SsoSessionIdHelper.parseStoreKey(sessionId);
        if (storeKey == null) {
            return null;
        }

        SSOUser xxlUser = ssoLoginStore.get(storeKey);
        if (xxlUser != null) {
            String version = SsoSessionIdHelper.parseVersion(sessionId);
            if (xxlUser.getVersion().equals(version)) {

                // After the expiration time has passed half, Auto refresh
                if ((System.currentTimeMillis() - xxlUser.getExpireFreshTime()) > xxlUser.getExpireMinite()/2) {
                    xxlUser.setExpireFreshTime(System.currentTimeMillis());
                    ssoLoginStore.put(storeKey, xxlUser);
                }

                return xxlUser;
            }
        }
        return null;
    }

    /**
     * 判断当前用户是否在登录列表中
     * @param sessionId
     * @return
     */
    public boolean hasLandedOnKey(String sessionId){
        String storeKey = SsoSessionIdHelper.parseStoreKey(sessionId);
        if (storeKey == null) {
            return false;
        }
        return ssoLoginStore.hasLandedOnKey(storeKey);
    }



}
