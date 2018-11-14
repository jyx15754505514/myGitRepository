package com.ccicnavi.bims.customer.api;


import com.ccicnavi.bims.customer.pojo.CustomerDO;

import java.util.List;

/**
 * 客户接口层
 */
public interface CustomerService {

    /**查询全部客户信息*/
    List<CustomerDO> listCustomer(CustomerDO customer);

    /**新增客户信息*/
    int saveCustomer(CustomerDO customer);

    /**删除客户信息*/
    int removeCustomer(String uuids);

    /**修改客户信息*/
    int updateCustomer(CustomerDO customer);

    CustomerDO getCustomer(CustomerDO customer);

}
