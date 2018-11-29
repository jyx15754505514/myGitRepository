package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.PersonService;
import com.ccicnavi.bims.resource.dao.PersonDao;
import com.ccicnavi.bims.resource.pojo.PersonDO;
import com.ccicnavi.bims.resource.pojo.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;


    /**
     * 查询人员信息
     *
     * @param personDo
     * @return List<PersonDO>
     * @throws Exception
     */
    @Override
    public List<PersonDO> listPerson(PersonDO personDo) throws Exception {
        try {
            return personDao.listPerson(personDo);
        } catch (Exception e) {
            log.error("人员信息查询错误", e);
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 添加人员
     *
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer insertPerson(PersonDO personDo) throws Exception {
        try {
            return personDao.insertPerson(personDo);
        } catch (Exception e) {
            log.error("添加人员错误", e);
            e.printStackTrace();
            return  null;
        }
    }

    /**
     * 更新人员信息
     *
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer updatePerson(PersonDO personDo) throws Exception {
        try {
            return personDao.updatePerson(personDo);
        } catch (Exception e) {
            log.error("更新人员信息错误",e);
            e.printStackTrace();
            return  null;
        }
    }

    /**
     * 删除人员信息
     *
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer deletePerson(PersonDO personDo) throws Exception {
        try {
            return personDao.deletePerson(personDo);
        } catch (Exception e) {
            log.error("删除人员信息错误",e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据主键查询人员信息
     *
     * @param personDo
     * @return PersonDO
     * @throws Exception
     */
    @Override
    public PersonDO getPerson(PersonDO personDo) {
        try {
            return personDao.getPerson(personDo);
        } catch (Exception e) {
            log.error("删除人员信息错误",e);
            e.printStackTrace();
            return null;
        }
    }

    /*
     *@Param: [pageParameter]
     *@description: 根据条件 查询人员分页数据
     *@return: com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.PersonDO>
     *@author: WangGengXiang
     *@create: 2018/11/16 15:38
     */
    @Override
    public PageBean<PersonDO> getPagePerson(PageParameter<PersonDO> pageParameter) {
        try {
            return personDao.getPagePerson(pageParameter);
        } catch (Exception e) {
            log.error("根据条件 查询人员分页数据",e);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PageBean<PersonDTO> selectByOrgOrDept(PageParameter<PersonDTO> pageParameter) {
        try {
            return personDao.selectByOrgOrDept(pageParameter);
        } catch (Exception e) {
            log.error("根据条件查询人员失败",e);
            e.printStackTrace();
            return null;
        }
    }


}
