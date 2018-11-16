package com.ccicnavi.bims.resource.dao.impl;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.TemplateDao;
import com.ccicnavi.bims.resource.pojo.TemplateDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @program: bims-backend
 * @description: 模板dao实现类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
@Service
@Slf4j
public class TemplateDaoImpl implements TemplateDao {

    /**
     * 根据条件查询模板信息
     * @param parameter
     * @return PageBean<TemplateDO>
     * @throws Exception
     */
    @Override
    public PageBean<TemplateDO> listTemplate(PageParameter parameter) throws Exception {
        EqlPage eqlPage = new EqlPage(parameter.getStartIndex(), parameter.getPageRows());
        List<TemplateDO> templateDOList = new Eql().select("listTemplate").params(parameter.getParameter()).limit(eqlPage).returnType(TemplateDO.class).execute();
        return new PageBean<TemplateDO>(eqlPage.getTotalRows(),eqlPage.getTotalPages(), eqlPage.getCurrentPage(), eqlPage.getPageRows(), eqlPage.getStartIndex(), templateDOList);
    }

    /**
     * 新增模板
     * @param template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer insertTemplate(TemplateDO template) throws Exception {
        return new Eql().insert("insertTemplate").params(template).returnType(Integer.class).execute();
    }

    /**
     * 单个或批量更新模板信息
     * @param template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer updateTemplate(TemplateDO template) throws Exception {
        return new Eql().update("updateTemplate").params(template).returnType(Integer.class).execute();
    }

    /**
     * 单个或批量删除模板信息
     * @param template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer deleteTemplate(TemplateDO template) throws Exception {
        return new Eql().delete("deleteTemplate").params(template).returnType(Integer.class).execute();
    }

    /**
     * 根据主键查询模板信息
     * @param template
     * @return TemplateDO
     * @throws Exception
     */
    @Override
    public TemplateDO getTemplate(TemplateDO template) throws Exception {
        return new Eql().selectFirst("getTemplate").params(template).returnType(TemplateDO.class).execute();
    }

}
