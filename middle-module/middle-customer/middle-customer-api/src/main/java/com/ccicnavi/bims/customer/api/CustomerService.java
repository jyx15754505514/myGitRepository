package com.ccicnavi.bims.customer.api;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户接口定义
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
public interface CustomerService {

    /**查询全部客户信息*/
    List<CustomerDO> listCustomer(CustomerDO customer);

    /**新增客户信息*/
    int saveCustomer(CustomerDO customer);

    /**删除客户信息*/
    int removeCustomer(CustomerDO customer);

    /**修改客户信息*/
    int updateCustomer(CustomerDO customer);

    CustomerDO getCustomer(CustomerDO customer);

    /**新增客户与客户注册信息*/
    int saveCustomerAndExt(CustomerDTO customerDTO);

    /**客户信息唯一性验证*/
    boolean verifyCustInfoOnly(CustomerDO customer);

    /**客户分页信息展示*/
    PageBean<CustomerDO> listCustomerPage(PageParameter<CustomerDO> pageParameter);
}
