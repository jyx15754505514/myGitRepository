package com.ccicnavi.bims.resource.dao.impl;


import com.ccicnavi.bims.resource.dao.ResPersonWorkDao;
import com.ccicnavi.bims.resource.pojo.ResPersonWorkDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResPersonWorkDaoImpl implements ResPersonWorkDao {
    /**
     * 查询人员工作
     * @param
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public List<ResPersonWorkDO> listResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception {
        return new Eql().select("listResPersonWorkDO").params(resPersonWorkDO).returnType(ResPersonWorkDO.class).execute();
    }

    /**
     * 新增人员工作
     * @param
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public Integer insertResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception {
        return new Eql().insert("insertResPersonWorkDO").params(resPersonWorkDO).returnType(Integer.class).execute();
    }

    /**
     * 更新人员工作
     * @param
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public Integer updateResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception {
        return new Eql().insert("updateResPersonWorkDO").params(resPersonWorkDO).returnType(Integer.class).execute();
    }

    /**
     * 删除人员工作
     * @param
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public Integer deleteResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception {
        return new Eql().insert("deleteResPersonWorkDO").params(resPersonWorkDO).returnType(Integer.class).execute();
    }

    /**
     * 根据主键查询人员工作
     * @param
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public ResPersonWorkDO getResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception {
        return new Eql().selectFirst("getResPersonWorkDO").params(resPersonWorkDO).returnType(ResPersonWorkDO.class).execute();
    }
}
