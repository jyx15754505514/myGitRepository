package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.TemplateService;
import com.ccicnavi.bims.resource.dao.TemplateDao;
import com.ccicnavi.bims.resource.pojo.TemplateDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
/**
 * @program: bims-backend
 * @description: 模板api实现类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
public class TemplateServiceImpl implements TemplateService {

    private final static Logger log = LoggerFactory.getLogger(TemplateServiceImpl.class);

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
        try{
            return TemplateDao.listTemplate(Template);
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
            return TemplateDao.insertTemplate(Template);
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
            return TemplateDao.updateTemplate(Template);
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
            return TemplateDao.deleteTemplate(Template);
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
            return TemplateDao.getTemplate(Template);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }
}
