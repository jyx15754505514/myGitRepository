package com.ccicnavi.bims.resource.dao.impl;


import com.ccicnavi.bims.resource.dao.TemplateDao;
import com.ccicnavi.bims.resource.pojo.TemplateDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateDaoImpl implements TemplateDao {

    /**
     * 查询模板信息
     * @param Template
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public List<TemplateDO> listTemplate(TemplateDO Template) throws Exception {
        return new Eql().select("listTemplate").params(Template).returnType(TemplateDO.class).execute();
    }

    /**
     * 新增模板
     * @param Template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer insertTemplate(TemplateDO Template) throws Exception {
        return new Eql().insert("insertTemplate").params(Template).returnType(Integer.class).execute();
    }

    /**
     * 更新模板信息
     * @param Template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer updateTemplate(TemplateDO Template) throws Exception {
        return new Eql().insert("updateTemplate").params(Template).returnType(Integer.class).execute();
    }

    /**
     * 删除模板信息
     * @param Template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer deleteTemplate(TemplateDO Template) throws Exception {
        return new Eql().insert("deleteTemplate").params(Template).returnType(Integer.class).execute();
    }

    /**
     * 根据主键查询模板信息
     * @param Template
     * @return Template
     * @throws Exception
     */
    @Override
    public TemplateDO getTemplate(TemplateDO Template) throws Exception {
        return new Eql().selectFirst("getTemplate").params(Template).returnType(TemplateDO.class).execute();
    }
}
