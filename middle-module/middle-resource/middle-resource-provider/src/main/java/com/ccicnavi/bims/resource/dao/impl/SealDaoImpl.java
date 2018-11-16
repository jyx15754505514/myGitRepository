package com.ccicnavi.bims.resource.dao.impl;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.SealDao;
import com.ccicnavi.bims.resource.pojo.SealDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import org.n3r.eql.Eql;
import java.util.List;

/**
 * @program: bims-backend
 * @description: （封识）增删改查
 * @author: zhangxingbiao
 * @create: 2018-11-15 14:49
 */
@Service
@Slf4j
public class SealDaoImpl implements SealDao{

    /**
    *@Description: 列表查询（封识）
    *@Param: [pageParameter]
    *@return: com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.SealDO>
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @Override
    public PageBean<SealDO> listSeal(PageParameter pageParameter) throws  Exception{
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<SealDO> sealList =  new Eql().select("listSeal").params(pageParameter.getParameter()).returnType(SealDO.class).limit(page).execute();
        if(sealList != null) {
            return new PageBean<SealDO>(page.getTotalRows(), page.getTotalPages(), page.getCurrentPage(), page.getPageRows(), page.getStartIndex(), sealList);
        }else {
            return null;
        }

    }

    /**
    *@Description: 新增（封识）
    *@Param: [sealDO]
    *@return: java.lang.Integer
    *@Author: zhangpengwei
    *@date: 2018/11/15
    */
    @Override
    public Integer insertSeal(SealDO sealDO) throws Exception {
        return new Eql().insert("insertCopy").params(sealDO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 更新（封识）
    *@Param: [sealDO]
    *@return: java.lang.Integer
    *@Author: zhangpengwei
    *@date: 2018/11/15
    */
    @Override
    public Integer updateSeal(SealDO sealDO) throws Exception {
        return new Eql().update("updateSeal").params(sealDO).returnType(Integer.class).execute();
    }

     /**
    *@Description: 删除（封识）
    *@Param: [sealDO]
    *@return: java.lang.Integer
    *@Author: zhangpengwei
    *@date: 2018/11/15
    */
    @Override
    public Integer deleteSeal(SealDO sealDO) throws Exception {
        return new Eql().delete("deleteSeal").params(sealDO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 根据主键或者名称获取（封识）
    *@Param: [sealDO]
    *@return: com.ccicnavi.bims.resource.pojo.SealDO
    *@Author: zhangpengwei
    *@date: 2018/11/15
    */
    @Override
    public SealDO getSeal(SealDO sealDO) throws Exception {
        return new Eql().selectFirst("getSeal").params(sealDO).returnType(SealDO.class).execute();
    }

}
