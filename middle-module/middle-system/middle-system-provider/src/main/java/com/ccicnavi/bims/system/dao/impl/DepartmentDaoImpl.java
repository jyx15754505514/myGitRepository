package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.DepartmentDao;
import com.ccicnavi.bims.system.pojo.*;
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
    *@Param: [departmentDO]
    *@return: List<DepartmentDO>
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public PageBean<DepartmentDO> listDepartment(PageParameter<DepartmentDO> pageParameter){
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<DepartmentDO> departmentDOList = new Eql("DEFAULT").select("listDepartment").params(pageParameter.getParameter()).limit(eqlPage).returnType(DepartmentDO.class).execute();
        if(departmentDOList != null) {
            return  new PageBean<DepartmentDO>(eqlPage.getTotalRows(),eqlPage.getTotalPages(), eqlPage.getCurrentPage(), eqlPage.getPageRows(), eqlPage.getStartIndex(), departmentDOList);
        }else {
            return null;
        }
    }

    /**
    *@Description: 新增部门信息
    *@Param: [departmentDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer insertDepartment(DepartmentDO departmentDO){
        return new Eql().insert("insertDepartment").params(departmentDO).returnType(Integer.class).execute();
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
        return new Eql().update("updateDepartment").params(departmentDO).returnType(Integer.class).execute();
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
        return new Eql().delete("deleteDepartment").params(departmentDO).returnType(Integer.class).execute();

    }

    /**
    *@Description: 根据主键获取部门信息
    *@Param: [departmentDO]
    *@return: DepartmentDO
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public DepartmentDO getDepartment(DepartmentDO departmentDO){
        return new Eql().selectFirst("getDepartment").params(departmentDO).returnType(DepartmentDO.class).execute();
    }

    /**
    *@Description: 根据用户的UUID查询所有的部门信息
    *@Param: [userDO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.UserDeptDO>
    *@Author: zhangpengwei
    *@date: 2018/11/19
    */
    @Override
    public List<DepartmentDTO> listDeptByUser(UserDTO userDTO) throws Exception {
        return new Eql().select("listDeptByUser").params(userDTO).returnType(DepartmentDTO.class).execute();
    }

}
