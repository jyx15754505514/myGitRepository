package com.ccicnavi.bims.sso.api;

import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.sso.common.result.ReturnT;

public interface SSOService {


    /**
     * 登录
     * @param userInfo
     * @return
     */
    public ReturnT<String> login(SSOUser userInfo);

    /**
     * 登出
     * @param sessionId
     * @return
     */
    public ReturnT<String> logout(String sessionId);

    /**
     * 查询用户登录信息
     * @param sessionId
     * @return
     */
    public ReturnT<SSOUser> logincheck(String sessionId);

    /**
     * 检查访问权限
     * @param sessionId
     * @param path
     * @return
     */
    public ReturnT<SSOUser> checkAccess(String sessionId,String path);
}
