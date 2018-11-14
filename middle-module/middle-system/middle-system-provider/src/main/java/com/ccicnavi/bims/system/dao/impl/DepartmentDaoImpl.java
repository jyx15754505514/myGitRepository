package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.DepartmentDao;
import com.ccicnavi.bims.system.pojo.DepartmentDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public List<DepartmentDO> listDepartment(DepartmentDO departmentDO){
        List<DepartmentDO> row = null;
        try{
            row = EqlUtils.getInstance("DEFAULT").select("listDept").params(departmentDO).returnType(DepartmentDO.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer insertDepartment(DepartmentDO departmentDO){
        Integer integer = null;
        try{
            integer = EqlUtils.getInstance("DEFAULT").insert("insertDept").params(departmentDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer updateDepartment(DepartmentDO departmentDO){
        Integer integer = null;
        try{
            integer = EqlUtils.getInstance("DEFAULT").update("insertDept").params(departmentDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer deleteDepartment(DepartmentDO departmentDO){
        Integer integer = null;
        try{
            integer = EqlUtils.getInstance("DEFAULT").delete("deleteDept").params(departmentDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public DepartmentDO getDepartment(DepartmentDO departmentDO){
        DepartmentDO departmentDO1 = null;
        try{
            departmentDO1 = EqlUtils.getInstance("DEFAULT").selectFirst("listDept").params(departmentDO).returnType(DepartmentDO.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return departmentDO1;
    }


}
