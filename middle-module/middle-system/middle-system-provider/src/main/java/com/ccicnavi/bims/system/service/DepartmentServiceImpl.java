package com.ccicnavi.bims.system.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.DepartmentDao;
import com.ccicnavi.bims.system.dao.impl.DepartmentDaoImpl;
import com.ccicnavi.bims.system.pojo.DepartmentDTO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import com.ccicnavi.bims.system.service.api.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 部门信息的api实现类
 * @author: zhangpengwei
 * @create: 2018-11-15 14:45
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final static Logger log = LoggerFactory.getLogger(DepartmentDaoImpl.class);

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * @Description: 查询部门信息(条件查询)
     * @Param: [departmentDTO]
     * @return: List<DepartmentDTO>
     * @Author: zhangxingbiao
     * @date: 2018/11/15
     */
    @Override
    public ResultT listDepartment(PageParameter<DepartmentDTO> pageParameter) {
        try {
            PageBean<DepartmentDTO> pageBean = departmentDao.listDepartment(pageParameter);
            if (pageBean != null) {
                return ResultT.success(pageBean);
            }
        } catch (Exception e) {
            log.error("查询部门信息失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /*
     *@Description: 新增部门信息
     *@Param: [departmentDTO]
     *@return: Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/15
     */
    @Override
    public Integer insertDepartment(DepartmentDTO departmentDTO) {
        try {
            return departmentDao.insertDepartment(departmentDTO);
        } catch (Exception e) {
            log.error("新增部门信息失败", e);
            return null;
        }
    }

    /**
     * @Description: 更新部门信息
     * @Param: [departmentDTO]
     * @return: Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/15
     */
    @Override
    public Integer updateDepartment(DepartmentDTO departmentDTO) {
        try {
            return departmentDao.updateDepartment(departmentDTO);
        } catch (Exception e) {
            log.error("更新部门信息失败", e);
            return null;
        }
    }

    /**
     * @Description: 删除部门信息
     * @Param: [departmentDTO]
     * @return: Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/15
     */
    @Override
    public Integer deleteDepartment(DepartmentDTO departmentDTO) {
        try {
            return departmentDao.deleteDepartment(departmentDTO);
        } catch (Exception e) {
            log.error("删除部门信息失败", e);
            return null;
        }
    }

    /**
     * @Description: 根据ID获取单个部门信息
     * @Param: [departmentDTO]
     * @return: DepartmentDTO
     * @Author: zhangxingbiao
     * @date: 2018/11/15
     */
    @Override
    public DepartmentDTO getDepartment(DepartmentDTO departmentDTO) {
        try {
            return departmentDao.getDepartment(departmentDTO);
        } catch (Exception e) {
            log.error("根据ID获取单个部门信息失败", e);
            return null;
        }
    }

    /**
    *@Description: 根据用户的UUID查询所有的部门信息
    *@Param: [userDTO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDTO>
    *@Author: zhangpengwei
    *@date: 2018/11/23
    */
    @Override
    public List<DepartmentDTO> listDeptByUser(UserDTO userDTO) {
        List<DepartmentDTO> deptList = null;
        try {
            deptList = departmentDao.listDeptByUser(userDTO);
            return deptList;
        } catch (Exception e) {
            log.error("查询用户部门UUID失败", e);
            return deptList;
        }
    }

    /**
     * @Description: 根据部门类型查询部门信息
     * @Param: [departmentDTO]
     * @return: java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDTO>
     * @Author: zhangpengwei
     * @date: 2018/11/20
     */
    @Override
    public List<DepartmentDTO> listDeptByDeptType(DepartmentDTO departmentDTO) {
        List<DepartmentDTO> deptList = new ArrayList<DepartmentDTO>();
        try {
            deptList = departmentDao.listDeptByDeptType(departmentDTO);
            return deptList;
        } catch (Exception e) {
            log.error("查询部门信息失败", e);
        }
        return deptList;
    }

    /**
     * @Description: 根据公司查询部门信息(orgUuid和parentUuid ）
     * @Param: [departmentDTO]
     * @return: java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDTO>
     * @Author: zhangpengwei
     * @date: 2018/11/21
     */
    @Override
    public List<DepartmentDTO> listDept(DepartmentDTO departmentDTO) {
        List<DepartmentDTO> deptList = new ArrayList<DepartmentDTO>();
        try {
            //通过departmentDO中parentUuid+orgUuid  获取公司下的一级部门集合
            String parentUuid = departmentDTO.getOrgUuid();
            departmentDTO.setParentUuid(parentUuid);
            deptList = departmentDao.listDept(departmentDTO);
            if (deptList != null && deptList.size() > 0) {
                //递归调用，获取树形部门结构
                listChildDept(departmentDTO, deptList);
            }
            return deptList;
        } catch (Exception e) {
            log.error("查询部门信息失败", e);
            return null;
        }
    }

    /**
     *@Description: 递归调用
     *@Param: [departmentDTO, deptList]
     *@return: void
     *@Author: zhangpengwei
     *@date: 2018/11/21
     */
    private void listChildDept(DepartmentDTO departmentDTO, List<DepartmentDTO> deptList) throws Exception {
        List<DepartmentDTO> childList = new ArrayList<DepartmentDTO>();
        for (DepartmentDTO dept : deptList) {
            String deptUuid = dept.getDeptUuid();
            departmentDTO.setParentUuid(deptUuid);
            childList = departmentDao.listDept(departmentDTO);
            if (childList != null && childList.size() > 0) {
                dept.setDeptChildList(childList);
                listChildDept(departmentDTO, childList);
            }
        }
    }

}