package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.product.service.api.DepartmentService;
import com.ccicnavi.bims.system.dao.DepartmentDao;
import com.ccicnavi.bims.system.pojo.DepartmentDO;



import java.util.List;

 @Service
 public class DepartmentServiceImpl implements DepartmentService {

    @Reference
    DepartmentDao departmentDao;


     @Override
     public List<DepartmentDO> listDepartment(DepartmentDO departmentDO) throws Exception {
         return departmentDao.listDepartment(departmentDO);
     }

     @Override
     public Integer insertDepartment(DepartmentDO departmentDO) throws Exception {
         return departmentDao.insertDepartment(departmentDO);
     }

     @Override
     public Integer updateDepartment(DepartmentDO departmentDO) throws Exception {
         return departmentDao.updateDepartment(departmentDO);
     }

     @Override
     public Integer deleteDepartment(DepartmentDO departmentDO) throws Exception {
         return departmentDao.deleteDepartment(departmentDO);
     }

     @Override
     public DepartmentDO getDepartment(DepartmentDO departmentDO) throws Exception {
         return departmentDao.getDepartment(departmentDO);
     }
 }
