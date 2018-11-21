package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerDao {

    /**查询全部客户信息*/
    List<CustomerDO> listCustomer(CustomerDO customer) throws Exception;

    /**新增客户信息*/
    int saveCustomer(CustomerDO customer,EqlTran tran) throws Exception;

    /**删除客户信息*/
    int removeCustomer(CustomerDO customer,EqlTran tran) throws Exception;

    /**修改客户信息*/
    int updateCustomer(CustomerDO customer,EqlTran tran) throws Exception;

    /**根据主键查询对应信息*/
    CustomerDO getCustomer(CustomerDO customer) throws Exception;

    /**新增客户基本信息与客户注册信息*/
    int saveCustomerAndExt(CustomerDTO customerDTO, EqlTran tran) throws Exception;

    /**客户信息唯一性验证*/
    int verifyCustInfoOnly(CustomerDO customer) throws Exception;

    /**客户分页信息展示*/
    PageBean<CustomerDO> listCustomerPage(PageParameter<CustomerDO> pageParameter);
    /**
    *@Description: 根据客户uuid客户信息
    *@Param: customer
    *@return: CustomerDTO
    *@Author: zqq
    *@date: 2018/11/20
    */

    CustomerDTO getCustomerUuid(CustomerDO customer) throws Exception;
}
