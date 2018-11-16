package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.SealService;
import com.ccicnavi.bims.resource.dao.SealDao;
import com.ccicnavi.bims.resource.pojo.SealDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: bims-backend
 * @description: （封识）增删改查
 * @author: zhangpengwei
 * @create: 2018-11-15 14:49
 */

@Service
@Slf4j
public class SealSeriveImpl implements SealService {

    @Autowired
    private SealDao sealDao;

    /**
    *@Description: 列表查询（封识）
    *@Param: [pageParameter]
    *@return: com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.SealDO>
    *@Author: zhangpengwei
    *@date: 2018/11/15
    */
    @Override
    public PageBean<SealDO> listSeal(PageParameter pageParameter){
        PageBean<SealDO> sealList = null;
        try {
            sealList = sealDao.listSeal(pageParameter);
        } catch (Exception e) {
            log.error("封识列表查询失败",e);
        }
        return sealList;
    }

    /**
     *@Description: 新增（封识）
     *@Param: [sealDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    @Override
    public Integer insertSeal(SealDO sealDO){
        Integer num = null;
        try {
            num = sealDao.insertSeal(sealDO);
        } catch (Exception e) {
            log.error("新增封识失败",e);
        }
        return num;
    }

    /**
     *@Description: 更新（封识）
     *@Param: [sealDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    @Override
    public Integer updateSeal(SealDO sealDO){
        Integer num = null;
        try {
            num = sealDao.updateSeal(sealDO);
        } catch (Exception e) {
            log.error("更新封识失败",e);
        }
        return num;
    }

    /**
     *@Description: 删除（封识）
     *@Param: [sealDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    @Override
    public Integer deleteSeal(SealDO sealDO){
        Integer num = null;
        try {
            num = sealDao.deleteSeal(sealDO);
        } catch (Exception e) {
            log.error("删除封识失败",e);
        }
        return num;
    }

    /**
     *@Description: 根据主键或者名称获取（封识）
     *@Param: [sealDO]
     *@return: com.ccicnavi.bims.resource.pojo.SealDO
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    @Override
    public SealDO getSeal(SealDO sealDO){
        SealDO sealDO1 = null;
        try {
            sealDO1 = sealDao.getSeal(sealDO);
        } catch (Exception e) {
            log.error("获取指定封识信息失败",e);
        }
        return sealDO1;
    }

}
