package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.dao.PersonCultExpeDao;
import com.ccicnavi.bims.resource.pojo.PersonCultExpeDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonCultExpeDaoImpl implements PersonCultExpeDao {
    /**
     * 查询人员培训经历
     * @param personCultExpe
     * @return List<PersonCultExpeDO>
     * @throws Exception
     */
    @Override
    public List<PersonCultExpeDO> listPersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return new Eql().select("listPersonCultExpe").params(personCultExpe).returnType(PersonCultExpeDO.class).execute();
    }

    /**
     * 新增人员培训经历
     * @param personCultExpe
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer insertPersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return new Eql().insert("insertPersonCultExpe").params(personCultExpe).returnType(PersonCultExpeDO.class).execute();
    }

    /**
     * 更新人员培训经历
     * @param personCultExpe
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer updatePersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return new Eql().insert("updatePersonCultExpe").params(personCultExpe).returnType(PersonCultExpeDO.class).execute();
    }

    /**
     * 删除人员培训经历
     * @param personCultExpe
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer deletePersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return new Eql().insert("deletePersonCultExpe").params(personCultExpe).returnType(PersonCultExpeDO.class).execute();
    }
}
