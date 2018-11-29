package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.PersonDO;
import com.ccicnavi.bims.resource.pojo.PersonDTO;
import org.n3r.eql.EqlTran;

import java.util.List;

public interface PersonDao {

    /*
     *@Param: [personDo]
     *@description: 查询人员
     *@return: java.util.List<com.ccicnavi.bims.resource.pojo.PersonDO>
     *@author: WangGengXiang
     *@create: 2018/11/16 15:18
     */
     List<PersonDO> listPerson(PersonDO personDo) throws Exception;

    /*
     *@Param: [personDo]
     *@description: 添加人员
     *@return: java.lang.Integer
     *@author: WangGengXiang
     *@create: 2018/11/16 15:18
     */
     Integer insertPerson(PersonDO personDo);

    /*
     *@Param: [personDo]
     *@description: 更新人员
     *@return: java.lang.Integer
     *@author: WangGengXiang
     *@create: 2018/11/16 15:18
     */
     Integer updatePerson(PersonDO personDo) throws Exception;

    /*
     *@Param: [personDo]
     *@description: 删除人员
     *@return: java.lang.Integer
     *@author: WangGengXiang
     *@create: 2018/11/16 15:18
     */
     Integer deletePerson(PersonDO personDo) throws Exception;

    /*
     *@Param: [personDo]
     *@description: 查询人员信息
     *@return: com.ccicnavi.bims.resource.pojo.PersonDO
     *@author: WangGengXiang
     *@create: 2018/11/16 15:18
     */
     PersonDO getPerson(PersonDO personDo);


    /*
     *@Param: [pageParameter]
     *@description: 根据条件 查询人员分页数据
     *@return: com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.PersonDO>
     *@author: WangGengXiang
     *@create: 2018/11/16 15:09
     */
     PageBean<PersonDO> getPagePerson(PageParameter<PersonDO> pageParameter);

     /**
     *@Description: 根据公司部门查询人员
     *@Param: PersonDTO
     *@return: PageBean<PersonDTO>
     *@Author: zqq
     *@date: 2018/11/29
     */

     PageBean<PersonDTO> selectByOrgOrDept(PageParameter<PersonDTO> pageParameter);
}
