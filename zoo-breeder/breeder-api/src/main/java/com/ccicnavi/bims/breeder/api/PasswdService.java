package com.ccicnavi.bims.breeder.api;

/**
 * @Auther: husky
 * @Date: 2018/11/15 10:50
 * @Version 0.1
 * @Description:
 */
public interface PasswdService {
    /**
     *  获取 Salt
     * @return
     */
    public String getSalt();

    /**
     *  获取hash后的密码
     * @param password 未Hash密码
     * @param salt
     * @return
     */
    public String getHash(String password, String salt) ;

    /**
     *
     * @param hashedPassword Hash后密码
     * @param password  未Hash密码
     * @param salt
     * @return
     */
    public boolean verify(String hashedPassword, String password, String salt);
}
