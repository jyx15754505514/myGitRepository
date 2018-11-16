package com.ccicnavi.bims.resource.manager;

import com.ccicnavi.bims.resource.pojo.PersonDTO;

public interface PersonManager {

    /*
     *@Param: [personDTO]
     *@description: 添加 人员信息 人员教育信息
     *@return: java.lang.Integer
     *@author: WangGengXiang
     *@create: 2018/11/16 17:04
     */
    public Integer insertPersonAndPersonTeach(PersonDTO personDTO);
}
