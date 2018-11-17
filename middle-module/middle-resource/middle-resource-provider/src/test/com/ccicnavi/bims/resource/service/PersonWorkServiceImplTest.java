package com.ccicnavi.bims.resource.service;

import com.ccicnavi.bims.resource.dao.impl.PersonWorkDaoImpl;
import com.ccicnavi.bims.resource.pojo.PersonWorkDO;
import org.junit.Test;

import java.util.List;


/**
 * @Author:
 * @Description:
 * @Date: Created in ${Time} 2018/11/15
 * @Modified By:
 */
public class PersonWorkServiceImplTest {
    @Test
    public void listPersonWorkDO() {
        PersonWorkDO personWorkDO = new PersonWorkDO();
        PersonWorkDaoImpl personWorkDao = new PersonWorkDaoImpl();
        personWorkDO.setProdCatalogUuid("33");
        personWorkDO.setPersonUuid("33");
        personWorkDO.setWorkUuid("33");
        personWorkDO.setOrgName("33");
        personWorkDO.setOrgUuid("33");
        personWorkDO.setAppSysUuid("33");
        Integer integer = personWorkDao.insertPersonWorkDO(personWorkDO);
        System.out.println(integer);
    }


    @Test
    public void listPersonWork() {
        PersonWorkDO personWorkDO = new PersonWorkDO();
        personWorkDO.setPersonUuid("4");
        PersonWorkDaoImpl dao = new PersonWorkDaoImpl();
        try {
            List<PersonWorkDO> list = dao.listPersonWorkDO(personWorkDO);
            System.out.print(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
