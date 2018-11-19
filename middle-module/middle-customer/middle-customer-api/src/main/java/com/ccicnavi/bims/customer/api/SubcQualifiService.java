package com.ccicnavi.bims.customer.api;


import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 分包方资质接口定义
 * @author: WangYingLing
 * @create: 2018-11-15 09:19
 */

public interface SubcQualifiService {

    /**查询所有的分包方资质信息*/
    List<SubcQualifiDO> listSubcQuali(SubcQualifiDO subcQuali) throws Exception;

    /**新增分包方资质信息*/
    int saveSubcQuali(SubcQualifiDO subcQuali) throws Exception;

    /**删除分包方资质信息*/
    int removeSubcQuali(SubcQualifiDO subcQuali) throws Exception;

    /**修改分包方资质信息*/
    int updateSubcQuali(SubcQualifiDO subcQuali) throws Exception;

    /**根据主键返回对应的分包方资质信息*/
    SubcQualifiDO getSubcQuali(SubcQualifiDO subcQuali) throws Exception;

}
