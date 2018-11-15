package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.DepartmentDao;
import com.ccicnavi.bims.system.pojo.DepartmentDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @program: bims-backend
 * @description: 部门信息dao实现类
 * @author: zhangxingbiao
 * @create: 2018-11-14 23:33
 **/
@Service
@Slf4j
public class DepartmentDaoImpl implements DepartmentDao {

    /**
    *@Description: 查询部门信息
    *@Param: [departmentDO]
    *@return: List<DepartmentDO>
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public List<DepartmentDO> listDepartment(DepartmentDO departmentDO)throws Exception{
        return EqlUtils.getInstance("DEFAULT").select("listDept").params(departmentDO).returnType(DepartmentDO.class).execute();
    }

    /**
    *@Description: 新增部门信息
    *@Param: [departmentDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer insertDepartment(DepartmentDO departmentDO)throws Exception{
        return EqlUtils.getInstance("DEFAULT").insert("insertDept").params(departmentDO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 更新部门信息
    *@Param: [departmentDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer updateDepartment(DepartmentDO departmentDO)throws Exception{
        return EqlUtils.getInstance("DEFAULT").update("updateDept").params(departmentDO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 删除部门信息
    *@Param: [departmentDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer deleteDepartment(DepartmentDO departmentDO)throws Exception{
        return EqlUtils.getInstance("DEFAULT").delete("deleteDept").params(departmentDO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 根据主键获取部门信息
    *@Param: [departmentDO]
    *@return: DepartmentDO
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public DepartmentDO getDepartment(DepartmentDO departmentDO)throws Exception{
        return EqlUtils.getInstance("DEFAULT").selectFirst("listDept").params(departmentDO).returnType(DepartmentDO.class).execute();
    }

}
