package com.ccicnavi.bims.resource.dao.impl;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.PersonWorkDao;
import com.ccicnavi.bims.resource.pojo.PersonWorkDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonWorkDaoImpl implements PersonWorkDao {

    /**@description: 查询人员工作
    *@author: ChaiYanShun
    *@create: 2018/11/16 16:39
    *@Param [personWorkDO]
    *@return java.util.List<com.ccicnavi.bims.resource.pojo.PersonWorkDO>
    */
    @Override
    public List<PersonWorkDO> listPersonWorkDO(PersonWorkDO personWorkDO){
        return new Eql().select("listPersonWorkDO").params(personWorkDO).returnType(PersonWorkDO.class).execute();
    }

    /**@description: 新增人员工作
    *@author: ChaiYanShun
    *@create: 2018/11/16 16:39
    *@Param [personWorkDO]
    *@return java.lang.Integer
    */
    @Override
    public Integer insertPersonWorkDO(PersonWorkDO personWorkDO){
        return new Eql().insert("insertPersonWorkDO").params(personWorkDO).returnType(Integer.class).execute();
    }

    /**@description: 更新人员工作
    *@author: ChaiYanShun
    *@create: 2018/11/16 16:39
    *@Param [personWorkDO]
    *@return java.lang.Integer
    */
    @Override
    public Integer updatePersonWorkDO(PersonWorkDO personWorkDO){
        return new Eql().insert("updatePersonWorkDO").params(personWorkDO).returnType(Integer.class).execute();
    }

    /**@description: 删除人员工作
    *@author: ChaiYanShun
    *@create: 2018/11/16 16:38
    *@Param [personWorkDO]
    *@return java.lang.Integer
    */
    @Override
    public Integer deletePersonWorkDO(PersonWorkDO personWorkDO){
        return new Eql().insert("deletePersonWorkDO").params(personWorkDO).returnType(Integer.class).execute();
    }

    /**@description: 根据主键查询人员工作
    *@author: ChaiYanShun
    *@create: 2018/11/16 16:38
    *@Param [personWorkDO]
    *@return com.ccicnavi.bims.resource.pojo.PersonWorkDO
    */
    @Override
    public PersonWorkDO getPersonWorkDO(PersonWorkDO personWorkDO){
        return new Eql().selectFirst("getPersonWorkDO").params(personWorkDO).returnType(PersonWorkDO.class).execute();
    }

    /**@description: 分页查询查询人员工作
    *@author: ChaiYanShun
    *@create: 2018/11/16 16:38
    *@Param [pageParameter]
    *@return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.PersonWorkDO>
    */
    @Override
    public PageBean<PersonWorkDO> getPersonWorkPage(PageParameter<PersonWorkDO> pageParameter) {
        EqlPage page = new EqlPage(pageParameter.getStartIndex(),pageParameter.pageRows);
        List<PersonWorkDO> PersonWorkDOS = new Eql().select("getPersonWorkPage").params(pageParameter.getParameter()).returnType(PersonWorkDO.class).limit(page).execute();
        return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),PersonWorkDOS);
    }
}
