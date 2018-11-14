package com.ccicnavi.bims.resource.api;

import java.util.List;

import com.ccicnavi.bims.resource.pojo.TemplateDO;

/**
 * @program: bims-backend
 * @description: 模板api接口
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
public interface TemplateService {
	
    /**
     * 查询模板信息
     * @param tepmlate
     * @return List<TemplateDO>
     * @throws Exception
     */
    public List<TemplateDO> listTemplate(TemplateDO tepmlate) throws Exception;

    /**
     * 新增模板
     * @param tepmlate
     * @return Integer
     * @throws Exception
     */
    public Integer insertTemplate(TemplateDO tepmlate)throws  Exception;

    /**
     * 更新模板信息
     * @param tepmlate
     * @return Integer
     * @throws Exception
     */
    public Integer updateTemplate(TemplateDO tepmlate)throws Exception;

    /**
     * 删除模板信息
     * @param tepmlate
     * @return Integer
     * @throws Exception
     */
    public Integer deleteTemplate(TemplateDO tepmlate)throws Exception;

    /**
     * 根据主键查询模板信息
     * @param tepmlate
     * @return TemplateDO
     * @throws Exception
     */
    public TemplateDO getTemplate(TemplateDO tepmlate)throws Exception;

}
