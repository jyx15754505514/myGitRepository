package com.ccicnavi.bims.product.dao;


import com.ccicnavi.bims.product.pojo.MinItemStdDO;

/**
 * @program: bims-backend
 * @description: 最小服务项与标准关系接口定义
 * @author: LiJie
 * @create: 2018-11-19 21:25
 */
public interface MinItemStdDao {

    /**新增最小服务项与标准关系信息*/
    int saveMinItemStd(MinItemStdDO minItemStd) throws Exception;

    /**删除最小服务项与标准关系信息*/
    int removeMinItemStd(MinItemStdDO minItemStd) throws Exception;


}
