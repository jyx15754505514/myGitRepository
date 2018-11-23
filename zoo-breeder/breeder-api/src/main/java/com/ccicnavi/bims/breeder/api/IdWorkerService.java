package com.ccicnavi.bims.breeder.api;

import java.util.Date;

/**
 * @Auther: husky
 * @Date: 2018/11/15 10:35
 * @Version 0.1
 * @Description:
 */
public interface IdWorkerService {
    /**
     * 获取唯一ID
     * @param date 当前时间
     * @return 唯一ID
     */
     String getId(Date date);


    /**
     * 获取业务ID
     * @param sysUID 机构ID
     * @param busiId 业务编号
     * @param step   步长 1000=4,,10000=5
     * @param cycle  周期  日=D,周=W,月=M,年=Y
     * @return
     */
     String getBusinessNumber(String sysUID,String busiId,String step,String cycle);



}
