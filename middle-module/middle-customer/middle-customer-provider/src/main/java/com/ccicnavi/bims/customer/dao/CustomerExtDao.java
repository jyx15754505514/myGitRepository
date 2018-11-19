package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import com.ccicnavi.bims.customer.pojo.CustomerExtDO;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-15 09:21
 */
public interface CustomerExtDao {

    /**查询全部客户注册信息信息*/
    List<CustomerExtDO> listCustomerExt(CustomerExtDO CustomerExt) ;

    /**新增客户注册信息信息*/
    int saveCustomerExt(CustomerExtDO CustomerExt,EqlTran tran) ;

    /**删除客户注册信息信息*/
    int removeCustomerExt(CustomerDO customerDO,EqlTran tran);

    /**修改客户注册信息信息*/
    int updateCustomerExt(CustomerExtDO CustomerExt,EqlTran tran);

    /**根据主键查询对应客户注册信息*/
    CustomerExtDO getCustomerExt(CustomerExtDO CustomerExt) ;

    /**保存客户注册信息*/
    int saveCustomerAndExt(CustomerDTO customerDTO, EqlTran tran);
}
