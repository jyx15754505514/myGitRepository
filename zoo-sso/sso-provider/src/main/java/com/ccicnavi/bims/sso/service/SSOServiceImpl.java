package com.ccicnavi.bims.sso.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.sso.api.SSOService;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.sso.common.result.ReturnT;
import com.ccicnavi.bims.sso.common.store.SsoSessionIdHelper;
import com.ccicnavi.bims.sso.login.SsoTokenLoginHelper;
import com.ccicnavi.bims.sso.store.SsoLoginStore;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SSOServiceImpl implements SSOService {


    @Autowired
    SsoTokenLoginHelper ssoTokenLoginHelper;

    /**
     * 登录
     * @param xxlUser
     * @return
     */
    public ReturnT<String> login(SSOUser xxlUser) {

        xxlUser.setVersion(UUID.randomUUID().toString().replaceAll("-", ""));
        xxlUser.setExpireMinite(SsoLoginStore.getRedisExpireMinite());
        xxlUser.setExpireFreshTime(System.currentTimeMillis());


        // 2、generate sessionId + storeKey
        String sessionId = SsoSessionIdHelper.makeSessionId(xxlUser);

        // 3、login, store storeKey
        ssoTokenLoginHelper.login(sessionId, xxlUser);

        // 4、return sessionId
        return new ReturnT<String>(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.message(),sessionId);

    }

    /**
     * 登出
     * @param sessionId
     * @return
     */
    public ReturnT<String> logout(String sessionId) {
        ssoTokenLoginHelper.logout(sessionId);
        return new ReturnT<String>(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.message());
    }

    /**
     * 查询用户登录状态
     * @param sessionId
     * @return
     */
    public ReturnT<SSOUser> logincheck(String sessionId) {
        SSOUser xxlUser = ssoTokenLoginHelper.loginCheck(sessionId);
        if (xxlUser == null) {
            if(ssoTokenLoginHelper.hasLandedOnKey(sessionId)){
                return new ReturnT<SSOUser>(ResultCode.USER_LOGIN_OUT.code(),ResultCode.USER_LOGIN_OUT.message());
            }else{
                return new ReturnT<SSOUser>(ResultCode.USER_NOT_LOGIN.code(),ResultCode.USER_NOT_LOGIN.message());
            }
        }
        return new ReturnT<SSOUser>(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.message(),xxlUser);
    }

    /**
     * 检查访问权限
     * @param sessionId
     * @param path
     * @return
     */
    public ReturnT<SSOUser> checkAccess(String sessionId,String path){
        //判断登录
        ReturnT<SSOUser> ssoUserReturnT = logincheck(sessionId);
        if(ssoUserReturnT.getCode() != 1){
            return ssoUserReturnT;
        }

        List<String> btnUrlList = ssoUserReturnT.getData().getBtnUrlList() == null ? new ArrayList<>() : ssoUserReturnT.getData().getBtnUrlList();
        if(btnUrlList.contains(path)){

            return new ReturnT<SSOUser>(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.message(),ssoUserReturnT.getData());
        }else{
            return new ReturnT<SSOUser>(ResultCode.USER_CANT_ACCESS.code(),ResultCode.USER_CANT_ACCESS.message());
        }
    }


}
