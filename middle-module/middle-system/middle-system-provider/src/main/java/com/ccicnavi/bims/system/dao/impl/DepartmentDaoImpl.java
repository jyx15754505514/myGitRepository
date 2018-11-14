package com.ccicnavi.bims.system.dao.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.DepartmentDao;
import com.ccicnavi.bims.system.pojo.DepartmentDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;


import java.util.List;

@Service
@Slf4j
public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public List<DepartmentDO> listDepartment(DepartmentDO departmentDO) throws Exception {
        List<DepartmentDO> row = null;
        try{
            row = new Eql().select("listDept").params(departmentDO).returnType(DepartmentDO.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer insertDepartment(DepartmentDO departmentDO) throws Exception {
        Integer integer = null;
        try{
            integer = new Eql().insert("insertDept").params(departmentDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer updateDepartment(DepartmentDO departmentDO) throws Exception {
        Integer integer = null;
        try{
            integer = new Eql().update("insertDept").params(departmentDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer deleteDepartment(DepartmentDO departmentDO) throws Exception {
        Integer integer = null;
        try{
            integer = new Eql().delete("deleteDept").params(departmentDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public DepartmentDO getDepartment(DepartmentDO departmentDO) throws Exception {
        DepartmentDO departmentDO1 = null;
        try{
            departmentDO1 = new Eql().select("listDept").params(departmentDO).returnType(DepartmentDO.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return departmentDO1;
    }


}
