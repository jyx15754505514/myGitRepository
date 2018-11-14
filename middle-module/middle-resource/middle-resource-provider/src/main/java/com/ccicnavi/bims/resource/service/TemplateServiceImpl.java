package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.TemplateService;
import com.ccicnavi.bims.resource.dao.TemplateDao;
import com.ccicnavi.bims.resource.pojo.TemplateDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateDao TemplateDao;

    /**
     * 查询模板信息
     * @param Template
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public List<TemplateDO> listTemplate(TemplateDO Template) throws Exception {
        return TemplateDao.listTemplate(Template);
    }

    /**
     * 新增模板
     * @param Template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer insertTemplate(TemplateDO Template) throws Exception {
        return TemplateDao.insertTemplate(Template);
    }

    /**
     * 更新模板信息
     * @param Template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer updateTemplate(TemplateDO Template) throws Exception {
        return TemplateDao.updateTemplate(Template);
    }

    /**
     * 删除模板信息
     * @param Template
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer deleteTemplate(TemplateDO Template) throws Exception {
        return TemplateDao.deleteTemplate(Template);
    }

    /**
     * 根据主键查询模板信息
     * @param Template
     * @return Template
     * @throws Exception
     */
    @Override
    public TemplateDO getTemplate(TemplateDO Template) throws Exception {
        return TemplateDao.getTemplate(Template);
    }
}
