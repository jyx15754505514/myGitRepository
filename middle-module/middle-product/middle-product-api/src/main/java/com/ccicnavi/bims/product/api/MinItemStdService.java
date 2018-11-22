package com.ccicnavi.bims.product.api;


import com.ccicnavi.bims.product.pojo.MinItemStdDO;

/**
 * @program: bims-backend
 * @description: 最小服务项与标准接口定义
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
public interface MinItemStdService {

    /**
     * 新增最小服务项与标准关系信息
     */
    int saveMinItemStd(MinItemStdDO minItemStd);

    /**
     * 删除最小服务项与标准关系信息
     */
    int removeMinItemStd(MinItemStdDO minItemStd);


}
