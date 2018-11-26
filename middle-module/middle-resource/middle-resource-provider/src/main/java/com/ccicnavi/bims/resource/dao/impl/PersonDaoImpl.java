package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.PersonDO;
import com.ccicnavi.bims.resource.dao.PersonDao;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDaoImpl  implements PersonDao {

    Eql eql = new Eql();

    /**
     * 查询人员信息
     * @param personDo
     * @return List<PersonDO>
     * @throws Exception
     */
    @Override
    public List<PersonDO> listPerson(PersonDO personDo) throws Exception {

        return eql.select("listPerson").params(personDo).returnType(PersonDO.class).execute();
    }

    /**
     * 添加人员
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer insertPerson(PersonDO personDo){
        return eql.insert("insertPerson").params(personDo).returnType(Integer.class).execute();
    }

    /**
     * 更新人员信息
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer updatePerson(PersonDO personDo) throws Exception {
        return eql.update("updatePerson").params(personDo).returnType(Integer.class).execute();
    }

    /**
     * 删除人员信息
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer deletePerson(PersonDO personDo) throws Exception {
        return eql.delete("deletePerson").params(personDo).returnType(Integer.class).execute();
    }

    /**
     * 根据主键查询人员信息
     * @param personDo
     * @return PersonDO
     * @throws Exception
     */
    @Override
    public PersonDO getPerson(PersonDO personDo) {
        return eql.selectFirst("getPerson").params(personDo).returnType(PersonDO.class).execute();
    }

    /*
    *@Param: [pageParameter]
    *@description: 根据条件 查询人员分页数据
    *@return: com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.PersonDO>
    *@author: WangGengXiang
    *@create: 2018/11/16 15:19
    */
    @Override
    public PageBean<PersonDO> getPagePerson(PageParameter<PersonDO> pageParameter) {
        EqlPage page = new EqlPage(pageParameter.getStartIndex(),pageParameter.getPageRows());
        List<PersonDO> personDOS = EqlUtils.getInstance("DEFAULT").id("getPagePerson").params(pageParameter.getParameter()).limit(page).execute();
        return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),personDOS);
    }








}
