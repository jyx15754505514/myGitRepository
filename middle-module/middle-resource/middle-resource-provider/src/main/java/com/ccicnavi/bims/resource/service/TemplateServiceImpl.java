package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.TemplateService;
import com.ccicnavi.bims.resource.dao.TemplateDao;
import com.ccicnavi.bims.resource.pojo.TemplateDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @program: bims-backend
 * @description: 模板api实现类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
@Service
@Slf4j
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateDao TemplateDao;

    /**
     * 查询模板信息
     * @param parameter
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public PageBean<TemplateDO> listTemplate(PageParameter parameter){
        try{
            return TemplateDao.listTemplate(parameter);
        }catch (Exception e) {
            log.error("根据条件查询模板信息失败", e);
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
    public Integer insertTemplate(TemplateDO Template){
        try{
            return TemplateDao.insertTemplate(Template);
        }catch (Exception e) {
            log.error("新增模板失败", e);
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
    public Integer updateTemplate(TemplateDO Template){
        try{
            return TemplateDao.updateTemplate(Template);
        }catch (Exception e) {
            log.error("更新模板信息失败", e);
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
    public Integer deleteTemplate(TemplateDO Template){
        try{
            return TemplateDao.deleteTemplate(Template);
        }catch (Exception e) {
            log.error("删除模板信息失败", e);
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
    public TemplateDO getTemplate(TemplateDO Template){
        try{
            return TemplateDao.getTemplate(Template);
        }catch (Exception e) {
            log.error("删除模板信息失败", e);
            return null;
        }
    }
}
