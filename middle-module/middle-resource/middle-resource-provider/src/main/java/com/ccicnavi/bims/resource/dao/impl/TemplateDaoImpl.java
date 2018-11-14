package com.ccicnavi.bims.resource.dao.impl;


import com.ccicnavi.bims.resource.dao.TemplateDao;
import com.ccicnavi.bims.resource.pojo.TemplateDO;
import org.n3r.eql.Eql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateDaoImpl implements TemplateDao {

    private final static Logger log = LoggerFactory.getLogger(TemplateDaoImpl.class);

    /**
     * 查询模板信息
     * @param Template
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public List<TemplateDO> listTemplate(TemplateDO Template) throws Exception {
        try{
            return new Eql().select("listTemplate").params(Template).returnType(TemplateDO.class).execute();
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    /**
     * 新增模板
     * @param Template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer insertTemplate(TemplateDO Template) throws Exception {
        try{
            return new Eql().insert("insertTemplate").params(Template).returnType(Integer.class).execute();
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    /**
     * 更新模板信息
     * @param Template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer updateTemplate(TemplateDO Template) throws Exception {
        try{
            return new Eql().insert("updateTemplate").params(Template).returnType(Integer.class).execute();
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    /**
     * 删除模板信息
     * @param Template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer deleteTemplate(TemplateDO Template) throws Exception {
        try{
            return new Eql().insert("deleteTemplate").params(Template).returnType(Integer.class).execute();
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    /**
     * 根据主键查询模板信息
     * @param Template
     * @return Template
     * @throws Exception
     */
    @Override
    public TemplateDO getTemplate(TemplateDO Template) throws Exception {
        try{
            return new Eql().selectFirst("getTemplate").params(Template).returnType(TemplateDO.class).execute();
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }
}
