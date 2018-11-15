package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.resource.pojo.PersonCultExpeDO;
import java.util.List;

public interface PersonCultExpeDao {
    /**
     * 查询人员培训经历
     * @param personCultExpe
     * @return List<PersonCultExpe>
     * @throws Exception
     */
    public List<PersonCultExpeDO> listPersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception;

    /**
     * 新增人员培训经历
     * @param personCultExpe
     * @return Integer
     * @throws Exception
     */
    public Integer insertPersonCultExpe(PersonCultExpeDO personCultExpe)throws  Exception;

    /**
     * 更新人员培训经历
     * @param personCultExpe
     * @return Integer
     * @throws Exception
     */
    public Integer updatePersonCultExpe(PersonCultExpeDO personCultExpe)throws Exception;

    /**
     * 删除人员培训经历
     * @param personCultExpe
     * @return Integer
     * @throws Exception
     */
    public Integer deletePersonCultExpe(PersonCultExpeDO personCultExpe)throws Exception;
}
