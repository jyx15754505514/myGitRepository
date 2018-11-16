package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.PersonCultExpeDO;
import java.util.List;

public interface PersonCultExpeDao {
    /*
    *@program: [personCultExpe]
    *@description: 查询人员培训经历
    *@return: java.util.List<com.ccicnavi.bims.resource.pojo.PersonCultExpeDO>
    *@author: XiaWei
    *@create: 2018/11/16 10:25
    */
    public List<PersonCultExpeDO> listPersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception;

    /*
    *@program: [personCultExpe]
    *@description: 新增人员培训经历
    *@return: java.lang.Integer
    *@author: XiaWei
    *@create: 2018/11/16 10:27
    */
    public Integer insertPersonCultExpe(PersonCultExpeDO personCultExpe)throws  Exception;

    /*
    *@program: [personCultExpe]
    *@description: 更新人员培训经历
    *@return: java.lang.Integer
    *@author: XiaWei
    *@create: 2018/11/16 10:28
    */
    public Integer updatePersonCultExpe(PersonCultExpeDO personCultExpe)throws Exception;

    /*
    *@program: [personCultExpe]
    *@description: 删除人员培训经历
    *@return: java.lang.Integer
    *@author: XiaWei
    *@create: 2018/11/16 10:29
    */
    public Integer deletePersonCultExpe(PersonCultExpeDO personCultExpe)throws Exception;

    /*
    *@program: [personCultExpe]
    *@description: 根据主键获取人员培训经历
    *@return: com.ccicnavi.bims.resource.pojo.PersonCultExpeDO
    *@author: XiaWei
    *@create: 2018/11/16 18:07
    */
    public PersonCultExpeDO getPersonCultExpe(PersonCultExpeDO personCultExpe)throws Exception;

    /*
    *@program: [pageParameter]
    *@description: 根据条件 查询人员培训经历分页数据
    *@return: com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.PersonCultExpeDO>
    *@author: XiaWei
    *@create: 2018/11/16 17:43
    */
    public PageBean<PersonCultExpeDO> getPagePersonCultExpe(PageParameter<PersonCultExpeDO> pageParameter);
}
