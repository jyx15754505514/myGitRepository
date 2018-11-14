package com.ccicnavi.bims.customer.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.CustomerService;
import com.ccicnavi.bims.customer.dao.CustomerDao;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户Service实现
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerDao customerDao;

    @Override
    public List<CustomerDO> listCustomer(CustomerDO customer) {
        return customerDao.listCustomer(customer);
    }

    @Override
    public int saveCustomer(CustomerDO customer) {
        return customerDao.saveCustomer(customer);
    }

    @Override
    public int removeCustomer(String uuids) {
        return customerDao.removeCustomer(uuids);
    }

    @Override
    public int updateCustomer(CustomerDO customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public CustomerDO getCustomer(CustomerDO customer) {
        return customerDao.getCustomer(customer);
    }


    @Test
    public void listCustomer(){
        CustomerDO cu=new CustomerDO();
        cu.setCustAddr("asdadsada");
        List<CustomerDO> custList= null;
        try {
            custList = customerDao.listCustomer(cu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(custList);
    }


}
