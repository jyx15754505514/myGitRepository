package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.SealDO;
import org.n3r.eql.EqlTran;
import java.util.List;

/**
 * @program: bims-backend
 * @description: （封识）增删改查
 * @author: zhangxingbiao
 * @create: 2018-11-15 14:49
 */
public interface SealDao {

    /**
    *@Description: 列表查询（封识）
    *@Param: [pageParameter]
    *@return: com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.SealDO>
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    public PageBean<SealDO> listSeal(PageParameter pageParameter) throws Exception;

    /**
     *@Description: 新增（封识）
     *@Param: [sealDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    public Integer insertSeal(SealDO sealDO) throws Exception;

    /**
     *@Description: 更新（封识）
     *@Param: [sealDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    public Integer updateSeal(SealDO sealDO) throws Exception;

    /**
     *@Description: 删除（封识）
     *@Param: [sealDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    public Integer deleteSeal(SealDO sealDO) throws Exception;

    /**
     *@Description: 根据主键或者名称获取（封识）
     *@Param: [sealDO]
     *@return: com.ccicnavi.bims.resource.pojo.SealDO
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    public SealDO getSeal(SealDO sealDO) throws Exception;

}
