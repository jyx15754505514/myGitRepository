package com.ccicnavi.bims.customer.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.CustomerService;
import com.ccicnavi.bims.customer.dao.CustomerDao;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 客户Service实现
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public List<CustomerDO> listCustomer(CustomerDO customer) {
        List<CustomerDO> custList=null;
        try {
            custList= customerDao.listCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询客户信息失败~",e);
        }
        return custList;
    }

    @Override
    public int saveCustomer(CustomerDO customer) {
        Integer count=0;
        try {
            count= customerDao.saveCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("保存客户信息失败~",e);
        }
        return count;
    }

    @Override
    public int removeCustomer(String uuids) {
        Integer count=0;
        try {
            count= customerDao.removeCustomer(uuids);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除客户信息失败~",e);
        }
        return count;
    }

    @Override
    public int updateCustomer(CustomerDO customer) {
        Integer count=0;
        try {
            count= customerDao.updateCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("修改客户信息失败~",e);
        }
        return count;
    }

    @Override
    public CustomerDO getCustomer(CustomerDO customerDO) {
        CustomerDO customer=null;
        try {
            customer=customerDao.getCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("根据主键查询客户信息失败~",e);
        }
        return customer;
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
            log.debug("查询客户信息失败~");
        }
        System.out.println(custList);
    }


}
