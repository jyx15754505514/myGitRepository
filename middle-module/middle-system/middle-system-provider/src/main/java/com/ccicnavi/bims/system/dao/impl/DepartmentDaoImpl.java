package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.DepartmentDao;
import com.ccicnavi.bims.system.pojo.DepartmentDTO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
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
    *@Param: [departmentDTO]
    *@return: List<DepartmentDTO>
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public PageBean<DepartmentDTO> listDepartment(PageParameter<DepartmentDTO> pageParameter) throws Exception {
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<DepartmentDTO> departmentDTOList = new Eql("DEFAULT").select("listDepartment").params(pageParameter.getParameter()).limit(eqlPage).returnType(DepartmentDTO.class).execute();
        if(departmentDTOList != null) {
            return  new PageBean<DepartmentDTO>(eqlPage.getTotalRows(),eqlPage.getTotalPages(), eqlPage.getCurrentPage(), eqlPage.getPageRows(), eqlPage.getStartIndex(), departmentDTOList);
        }else {
            return null;
        }
    }

    /**
    *@Description: 新增部门信息
    *@Param: [departmentDTO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer insertDepartment(DepartmentDTO departmentDTO) throws Exception {
        return new Eql().insert("insertDepartment").params(departmentDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 更新部门信息
    *@Param: [departmentDTO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer updateDepartment(DepartmentDTO departmentDTO) throws Exception {
        return new Eql().update("updateDepartment").params(departmentDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 删除部门信息
    *@Param: [departmentDTO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer deleteDepartment(DepartmentDTO departmentDTO) throws Exception {
        return new Eql().delete("deleteDepartment").params(departmentDTO).returnType(Integer.class).execute();

    }

    /**
    *@Description: 根据主键获取部门信息
    *@Param: [departmentDTO]
    *@return: DepartmentDTO
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public DepartmentDTO getDepartment(DepartmentDTO departmentDTO) throws Exception {
        return new Eql().selectFirst("getDepartment").params(departmentDTO).returnType(DepartmentDTO.class).execute();
    }

    /**
    *@Description: 根据用户的UUID查询所有的部门信息
    *@Param: [userDO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDTO>
    *@Author: zhangpengwei
    *@date: 2018/11/19
    */
    @Override
    public List<DepartmentDTO> listDeptByUser(UserDTO userDTO) throws Exception {
        return new Eql().select("listDeptByUser").params(userDTO).returnType(DepartmentDTO.class).execute();
    }

    /**
    *@Description: 根据部门类型查询部门信息
    *@Param: [departmentDTO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDTO>
    *@Author: zhangpengwei
    *@date: 2018/11/20
    */
    @Override
    public List<DepartmentDTO> listDeptByDeptType(DepartmentDTO departmentDTO) throws Exception {
        return new Eql().select("listDeptByDeptType").params(departmentDTO).returnType(DepartmentDTO.class).execute();
    }

    /**
     *@Description: 根据orgUuid和parentUuid查询部门
     *@Param: [departmentDTO]
     *@return: java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDTO>
     *@Author: zhangpengwei
     *@date: 2018/11/21
     */
    public List<DepartmentDTO> listDept(DepartmentDTO departmentDTO) throws Exception {
        return new Eql().select("listDept").params(departmentDTO).returnType(DepartmentDTO.class).execute();
    }
}
