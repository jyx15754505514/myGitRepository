package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.resource.pojo.PersonDO;


import java.util.List;

public interface PersonService {

    /*
     *@Param: [personDo]
     *@description: 查询人员
     *@return: java.util.List<com.ccicnavi.bims.resource.pojo.PersonDO>
     *@author: WangGengXiang
     *@create: 2018/11/16 9:32
     */
    public List<PersonDO> listPerson(PersonDO personDo) throws Exception;


    /*
     *@Param: [personDo]
     *@description: 添加人员
     *@return: java.lang.Integer
     *@author: WangGengXiang
     *@create: 2018/11/16 9:32
     */
    public Integer insertPerson(PersonDO personDo) throws Exception;

    /*
     *@Param: [personDo]
     *@description: 更新人员
     *@return: java.lang.Integer
     *@author: WangGengXiang
     *@create: 2018/11/16 9:32
     */
    public Integer updatePerson(PersonDO personDo) throws Exception;

    /*
     *@Param: [personDo]
     *@description: 删除人员
     *@return: java.lang.Integer
     *@author: WangGengXiang
     *@create: 2018/11/16 9:31
     */
    public Integer deletePerson(PersonDO personDo) throws Exception;

    /*
     *@Param: [personDo]
     *@description: 获取人员信息
     *@return: com.ccicnavi.bims.resource.pojo.PersonDO
     *@author: WangGengXiang
     *@create: 2018/11/16 9:31
     */
    public PersonDO getPerson(PersonDO personDo);


}
