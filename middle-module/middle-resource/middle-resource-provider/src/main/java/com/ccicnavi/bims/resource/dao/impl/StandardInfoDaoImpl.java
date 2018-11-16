package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.StandardInfoDao;
import com.ccicnavi.bims.resource.pojo.StandardInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: （标准）增删改查
 * @author: zhangpengwei
 * @create: 2018-11-15 14:49
 */

@Service
@Slf4j
public class StandardInfoDaoImpl implements StandardInfoDao{

    /**
    *@Description: 列表查询（标准）
    *@Param: [pageParameter]
    *@return: com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.StandardInfoDO>
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @Override
    public PageBean<StandardInfoDO> listStandardInfo(PageParameter pageParameter) throws Exception {
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<StandardInfoDO> standardInfoDOList = new Eql().select("listStandardInfo").params(pageParameter.getParameter()).returnType(StandardInfoDO.class).execute();
        if(standardInfoDOList != null) {
            return new PageBean<StandardInfoDO>(page.getTotalRows(), page.getTotalPages(), page.getCurrentPage(), page.getPageRows(), page.getStartIndex(), standardInfoDOList);
        }else {
            return null;
        }
    }

    /**
     *@Description: 新增（标准）
     *@Param: [standardInfoDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    @Override
    public Integer insertStandardInfo(StandardInfoDO standardInfoDO) throws Exception {
        return new Eql().insert("insertStandardInfo").params(standardInfoDO).returnType(Integer.class).execute();
    }

    /**
     *@Description: 更新（标准）
     *@Param: [standardInfoDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    @Override
    public Integer updateStandardInfo(StandardInfoDO standardInfoDO) throws Exception {
        return new Eql().update("updateStandardInfo").params(standardInfoDO).returnType(Integer.class).execute();
    }

    /**
     *@Description: 删除（标准）
     *@Param: [standardInfoDO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    @Override
    public Integer deleteStandardInfo(StandardInfoDO standardInfoDO) throws Exception {
        return new Eql().delete("deleteStandardInfo").params(standardInfoDO).returnType(Integer.class).execute();
    }

    /**
     *@Description: 根据主键或者名称获取（标准）
     *@Param: [standardInfoDO]
     *@return: com.ccicnavi.bims.resource.pojo.StandardInfoDO
     *@Author: zhangpengwei
     *@date: 2018/11/15
     */
    @Override
    public StandardInfoDO getStandardInfo(StandardInfoDO standardInfoDO) throws Exception {
        StandardInfoDO getStandardInfoDO = new Eql().selectFirst("getStandardInfo").params(standardInfoDO).returnType(StandardInfoDO.class).execute();
        return getStandardInfoDO;
    }

}
