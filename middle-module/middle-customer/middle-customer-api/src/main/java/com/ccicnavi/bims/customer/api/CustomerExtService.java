package com.ccicnavi.bims.customer.api;


import com.ccicnavi.bims.customer.pojo.CustomerExtDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户注册信息接口定义
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
public interface CustomerExtService {

    /**查询全部客户发票信息*/
    List<CustomerExtDO> listCustomerExt(CustomerExtDO CustomerExt) ;

    /**新增客户发票信息*/
    int saveCustomerExt(CustomerExtDO CustomerExt) ;

    /**删除客户发票信息*/
    int removeCustomerExt(String uuids);

    /**修改客户发票信息*/
    int updateCustomerExt(CustomerExtDO CustomerExt);

    CustomerExtDO getCustomerExt(CustomerExtDO CustomerExt) ;
}
