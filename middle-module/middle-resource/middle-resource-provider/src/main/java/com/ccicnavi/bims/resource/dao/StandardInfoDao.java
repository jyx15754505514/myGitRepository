package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.StandardInfoDO;
import com.ccicnavi.bims.common.service.pojo.PageBean;

import java.util.List;

/**
 * @program: bims-backend
 * @description: （标准）增删改查
 * @author: zhangpengwei
 * @create: 2018-11-15 14:49
 */

public interface StandardInfoDao {

    /**
    *@Description: 列表查询（标准）
    *@Param: [pageParameter]
    *@return: com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.StandardInfoDO>
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    public PageBean<StandardInfoDO> listStandardInfo(PageParameter pageParameter) throws Exception;

    /**
     *@Description: 新增（标准）
     *@Param: [standardInfoDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    public Integer insertStandardInfo(StandardInfoDO standardInfoDO) throws Exception;

    /**
     *@Description: 更新（标准）
     *@Param: [standardInfoDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    public Integer updateStandardInfo(StandardInfoDO standardInfoDO) throws Exception;

    /**
     *@Description: 删除（标准）
     *@Param: [standardInfoDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    public Integer deleteStandardInfo(StandardInfoDO standardInfoDO) throws Exception;

    /**
     *@Description: 根据主键或者名称获取（标准）
     *@Param: [standardInfoDO]
     *@return: com.ccicnavi.bims.resource.pojo.StandardInfoDO
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    public StandardInfoDO getStandardInfo(StandardInfoDO standardInfoDO) throws Exception;

}
