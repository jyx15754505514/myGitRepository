package com.ccicnavi.bims.system.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.service.api.DepartmentService;
import com.ccicnavi.bims.system.dao.DepartmentDao;
import com.ccicnavi.bims.system.pojo.DepartmentDO;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

 @Service
 public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDao departmentDao;

     /**
      * 查询部门信息（条件查询）
      * @param departmentDO
      * @return
      */
     @Override
     public List<DepartmentDO> listDepartment(DepartmentDO departmentDO){
         return departmentDao.listDepartment(departmentDO);
     }

     /**
      * 新增部门信息
      * @param departmentDO
      * @return
      */
     @Override
     public Integer insertDepartment(DepartmentDO departmentDO){
         return departmentDao.insertDepartment(departmentDO);
     }

     /**
      * 更新部门信息
      * @param departmentDO
      * @return
      */
     @Override
     public Integer updateDepartment(DepartmentDO departmentDO){
         return departmentDao.updateDepartment(departmentDO);
     }

     /**
      * 删除部门信息
      * @param departmentDO
      * @return
      */
     @Override
     public Integer deleteDepartment(DepartmentDO departmentDO){
         return departmentDao.deleteDepartment(departmentDO);
     }

     /**
      * 查询单个部门信息（主键查询）
      * @param departmentDO
      * @return
      */
     @Override
     public DepartmentDO getDepartment(DepartmentDO departmentDO){
         return departmentDao.getDepartment(departmentDO);
     }
 }
