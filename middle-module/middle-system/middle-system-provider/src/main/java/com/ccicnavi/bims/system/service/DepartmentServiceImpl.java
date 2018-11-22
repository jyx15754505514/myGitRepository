package com.ccicnavi.bims.system.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.impl.DepartmentDaoImpl;
import com.ccicnavi.bims.system.dao.impl.SettingDaoImpl;
import com.ccicnavi.bims.system.pojo.UserDO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import com.ccicnavi.bims.system.pojo.UserDeptDO;
import com.ccicnavi.bims.system.service.api.DepartmentService;
import com.ccicnavi.bims.system.dao.DepartmentDao;
import com.ccicnavi.bims.system.pojo.DepartmentDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 *@program: bims-backend
 *@description: 部门信息的api实现类
 *@author: zhangxingbiao
 *@create: 2018-11-15 14:45
 */
 @Service
 public class DepartmentServiceImpl implements DepartmentService{

    private final static Logger log = LoggerFactory.getLogger(DepartmentDaoImpl.class);

    @Autowired
    private DepartmentDao departmentDao;

     /**
     *@Description: 查询部门信息(条件查询)
     *@Param: [departmentDO]
     *@return: List<DepartmentDO>
     *@Author: zhangxingbiao
     *@date: 2018/11/15
     */
     @Override
     public ResultT listDepartment(PageParameter<DepartmentDO> pageParameter){
         try {
             PageBean<DepartmentDO> pageBean = departmentDao.listDepartment(pageParameter);
             if(pageBean != null) {
                 return  ResultT.success(pageBean);
             }
         } catch (Exception e) {
             log.error("查询部门信息失败",e);
         }
         return  ResultT.failure(ResultCode.LIST_FAILURE);
     }

     /*/**
     *@Description: 新增部门信息
     *@Param: [departmentDO]
     *@return: Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/15
     */
     @Override
     public Integer insertDepartment(DepartmentDO departmentDO){
         try {
             return departmentDao.insertDepartment(departmentDO);
         } catch (Exception e) {
             log.error("新增部门信息失败",e);
             return null;
         }
     }

     /**
     *@Description: 更新部门信息
     *@Param: [departmentDO]
     *@return: Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/15
     */
     @Override
     public Integer updateDepartment(DepartmentDO departmentDO){
         try {
             return departmentDao.updateDepartment(departmentDO);
         } catch (Exception e) {
             log.error("更新部门信息失败",e);
             return null;
         }
     }

     /**
     *@Description: 删除部门信息
     *@Param: [departmentDO]
     *@return: Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/15
     */
     @Override
     public Integer deleteDepartment(DepartmentDO departmentDO){
         try {
             return departmentDao.deleteDepartment(departmentDO);
         } catch (Exception e) {
             log.error("删除部门信息失败",e);
             return null;
         }
     }

     /**
     *@Description: 根据ID获取单个部门信息
     *@Param: [departmentDO]
     *@return: DepartmentDO
     *@Author: zhangxingbiao
     *@date: 2018/11/15
     */
     @Override
     public DepartmentDO getDepartment(DepartmentDO departmentDO){
         try {
             return departmentDao.getDepartment(departmentDO);
         } catch (Exception e) {
             log.error("根据ID获取单个部门信息失败",e);
             return null;
         }
     }

     /**
     *@Description: 根据用户的UUID查询所有的部门信息
     *@Param: [userDO]
     *@return: java.util.List<com.ccicnavi.bims.system.pojo.UserDeptDO>
     *@Author: zhangpengwei
     *@date: 2018/11/19
     */
     @Override
     public List<DepartmentDO> listDeptByUser(UserDTO userDTO){
         List<DepartmentDO> deptList = null;
         try {
             deptList = departmentDao.listDeptByUser(userDTO);
             return deptList;
         } catch (Exception e) {
             log.error("查询用户部门UUID失败",e);
             return deptList;
         }

     }
 }
