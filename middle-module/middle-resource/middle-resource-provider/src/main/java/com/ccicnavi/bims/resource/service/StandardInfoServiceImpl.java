package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.StandardInfoService;
import com.ccicnavi.bims.resource.dao.StandardInfoDao;
import com.ccicnavi.bims.resource.pojo.StandardInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: （标准）增删改查
 * @author: zhangpengwei
 * @create: 2018-11-15 14:49
 */

@Service
@Slf4j
public class StandardInfoServiceImpl implements StandardInfoService{

    @Autowired
    private StandardInfoDao standardInfoDao;

    /**
    *@Description: 列表查询（标准）
    *@Param: [pageParameter]
    *@return: com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.StandardInfoDO>
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @Override
    public PageBean<StandardInfoDO> listStandardInfo(PageParameter pageParameter){
        PageBean<StandardInfoDO> standardInfoDOList = null;
        try {
            standardInfoDOList = standardInfoDao.listStandardInfo(pageParameter);
        } catch (Exception e) {
            log.error("列表查询失败", e);
        }
        return standardInfoDOList;
    }

    /**
    *@Description: 新增（标准）
    *@Param: [standardInfoDO]
    *@return: java.lang.Integer
    *@Author: zhangpengwei
    *@date: 2018/11/15
    */
    @Override
    public Integer insertStandardInfo(StandardInfoDO standardInfoDO){
        Integer num = null;
        try {
            num = standardInfoDao.insertStandardInfo(standardInfoDO);
        } catch (Exception e) {
            log.error("新增（标准）失败", e);
        }
        return num;
    }

    /**
    *@Description: 更新（标准）
    *@Param: [standardInfoDO]
    *@return: java.lang.Integer
    *@Author: zhangpengwei
    *@date: 2018/11/15
    */
    @Override
    public Integer updateStandardInfo(StandardInfoDO standardInfoDO){
        Integer num = null;
        try {
            num = standardInfoDao.updateStandardInfo(standardInfoDO);
        } catch (Exception e) {
            log.error("更新（标准）失败", e);
        }
        return num;
    }

    /**
    *@Description: 删除（标准）
    *@Param: [standardInfoDO]
    *@return: java.lang.Integer
    *@Author: zhangpengwei
    *@date: 2018/11/15
    */
    @Override
    public Integer deleteStandardInfo(StandardInfoDO standardInfoDO){
        Integer num = null;
        try {
            num = standardInfoDao.deleteStandardInfo(standardInfoDO);
        } catch (Exception e) {
            log.error("删除（标准）失败", e);
        }
        return num;
    }

    /**
    *@Description: 根据主键或者名称获取（标准）
    *@Param: [standardInfoDO]
    *@return: com.ccicnavi.bims.resource.pojo.StandardInfoDO
    *@Author: zhangpengwei
    *@date: 2018/11/15
    */
    @Override
    public StandardInfoDO getStandardInfo(StandardInfoDO standardInfoDO){
        StandardInfoDO getStandardInfoDO = null;
        try {
            getStandardInfoDO = standardInfoDao.getStandardInfo(standardInfoDO);
        } catch (Exception e) {
            log.error("获取（标准）失败", e);
        }
        return getStandardInfoDO;
    }
    
}
