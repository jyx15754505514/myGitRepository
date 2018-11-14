package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.resource.pojo.TemplateDO;


import java.util.List;


public interface TemplateDao {
	
	/**
     * 查询模板信息
     * @param Template
     * @return List<Template>
     * @throws Exception
     */
    public List<TemplateDO> listTemplate(TemplateDO Template) throws Exception;

    /**
     * 新增模板
     * @param Template
     * @return Integer
     * @throws Exception
     */
    public Integer insertTemplate(TemplateDO Template)throws  Exception;

    /**
     * 更新模板信息
     * @param Template
     * @return Integer
     * @throws Exception
     */
    public Integer updateTemplate(TemplateDO Template)throws Exception;

    /**
     * 删除模板信息
     * @param Template
     * @return Integer
     * @throws Exception
     */
    public Integer deleteTemplate(TemplateDO Template)throws Exception;

    /**
     * 根据主键查询模板信息
     * @param Template
     * @return Template
     * @throws Exception
     */
    public TemplateDO getTemplate(TemplateDO Template)throws Exception;
}