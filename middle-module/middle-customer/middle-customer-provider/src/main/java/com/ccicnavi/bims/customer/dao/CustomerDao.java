package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.CustomerDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerDao {

    /**查询全部客户信息*/
    List<CustomerDO> listCustomer(CustomerDO customer) throws Exception;

    /**新增客户信息*/
    int saveCustomer(CustomerDO customer) throws Exception;

    /**删除客户信息*/
    int removeCustomer(String uuids) throws Exception;

    /**修改客户信息*/
    int updateCustomer(CustomerDO customer) throws Exception;

    CustomerDO getCustomer(CustomerDO customer) throws Exception;
}
