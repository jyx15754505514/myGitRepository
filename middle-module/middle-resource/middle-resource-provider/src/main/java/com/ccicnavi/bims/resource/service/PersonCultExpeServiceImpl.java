package com.ccicnavi.bims.resource.service;

import com.ccicnavi.bims.resource.api.PersonCultExpeService;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.dao.PersonCultExpeDao;
import com.ccicnavi.bims.resource.pojo.PersonCultExpeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.n3r.eql.Eql;

import java.util.List;

@Service
public class PersonCultExpeServiceImpl implements PersonCultExpeService {

    @Autowired
    private PersonCultExpeDao PersonCultExpeDao;

    /**
     * 查询人员培训经历
     * @param personCultExpe
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public List<PersonCultExpeDO> listPersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return PersonCultExpeDao.listPersonCultExpe(personCultExpe);
    }

    /**
     * 新增人员培训经历
     * @param personCultExpe
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer insertPersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return PersonCultExpeDao.insertPersonCultExpe(personCultExpe);
    }

    /**
     * 更新人员培训经历
     * @param personCultExpe
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer updatePersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return PersonCultExpeDao.updatePersonCultExpe(personCultExpe);
    }

    /**
     * 删除人员培训经历
     * @param personCultExpe
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer deletePersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return PersonCultExpeDao.deletePersonCultExpe(personCultExpe);
    }
}
