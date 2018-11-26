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

        try {
            xxlUser.setVersion(UUID.randomUUID().toString().replaceAll("-", ""));
            xxlUser.setExpireMinite(SsoLoginStore.getRedisExpireMinite());
            xxlUser.setExpireFreshTime(System.currentTimeMillis());


            // 2、generate sessionId + storeKey
            String sessionId = SsoSessionIdHelper.makeSessionId(xxlUser);

            // 3、login, store storeKey
            ssoTokenLoginHelper.login(sessionId, xxlUser);

            // 4、return sessionId
            return new ReturnT<String>(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.message(),sessionId);
        } catch (Exception e) {
            return new ReturnT<String>(ResultCode.USER_LOGIN_EXCEPTION.code(),ResultCode.USER_LOGIN_EXCEPTION.message());
        }
    }

    /**
     * 登出
     * @param sessionId
     * @return
     */
    public ReturnT<String> logout(String sessionId) {
        try {
            ssoTokenLoginHelper.logout(sessionId);
            return new ReturnT<String>(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.message());
        } catch (Exception e) {
            return new ReturnT<String>(ResultCode.USER_LOGINOUT_EXCEPTION.code(),ResultCode.USER_LOGINOUT_EXCEPTION.message());
        }
    }

    /**
     * 查询用户登录状态
     * @param sessionId
     * @return
     */
    public ReturnT<SSOUser> logincheck(String sessionId) {
        try {
            SSOUser xxlUser = ssoTokenLoginHelper.loginCheck(sessionId);
            if (xxlUser == null) {
                if(ssoTokenLoginHelper.hasLandedOnKey(sessionId)){
                    return new ReturnT<SSOUser>(ResultCode.USER_LOGIN_OUT.code(),ResultCode.USER_LOGIN_OUT.message());
                }else{
                    return new ReturnT<SSOUser>(ResultCode.USER_NOT_LOGIN.code(),ResultCode.USER_NOT_LOGIN.message());
                }
            }
            return new ReturnT<SSOUser>(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.message(),xxlUser);
        } catch (Exception e) {
            return new ReturnT<SSOUser>(ResultCode.USER_LOGINCHECK_EXCEPTION.code(),ResultCode.USER_LOGINCHECK_EXCEPTION.message());
        }
    }

    /**
     * 检查访问权限
     * @param sessionId
     * @param path
     * @return
     */
    public ReturnT<SSOUser> checkAccess(String sessionId,String path){
        try {
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
        } catch (Exception e) {
            return new ReturnT<SSOUser>(ResultCode.USER_CHECKACCESS_EXCEPTION.code(),ResultCode.USER_CHECKACCESS_EXCEPTION.message());
        }
    }


}
