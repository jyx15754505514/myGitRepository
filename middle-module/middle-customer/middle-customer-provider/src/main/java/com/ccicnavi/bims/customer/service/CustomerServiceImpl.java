package com.ccicnavi.bims.customer.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.CustomerService;
import com.ccicnavi.bims.customer.dao.CustomerDao;
import com.ccicnavi.bims.customer.dao.CustomerExtDao;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户基本操作
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;
    @Autowired
    CustomerExtDao customerExtDao;

    @Override
    public List<CustomerDO> listCustomer(CustomerDO customer) {
        try {
           return customerDao.listCustomer(customer);
        } catch (Exception e) {
            log.error("查询客户信息失败~",e);
            return null;
        }
    }

    @Override
    public int saveCustomer(CustomerDO customer) {
        try {
            return customerDao.saveCustomer(customer);
        } catch (Exception e) {
            log.error("保存客户信息失败~",e);
            return 0;
        }
    }

    @Override
    public int removeCustomer(String uuids) {
        try {
            return customerDao.removeCustomer(uuids);
        } catch (Exception e) {
            log.error("删除客户信息失败~",e);
            return 0;
        }
    }

    @Override
    public int updateCustomer(CustomerDO customer) {
        try {
            return customerDao.updateCustomer(customer);
        } catch (Exception e) {
            log.error("修改客户信息失败~",e);
            return 0;
        }
    }

    @Override
    public CustomerDO getCustomer(CustomerDO customerDO) {
        try {
            return customerDao.getCustomer(customerDO);
        } catch (Exception e) {
            log.error("根据主键查询客户信息失败~",e);
            return null;
        }
    }

    /**
     * 保存客户信息与客户注册信息
     * @param customerDTO
     * @return
     */
    @Override
    public int saveCustomerAndExt(CustomerDTO customerDTO) {
        EqlTran tran = new Eql().newTran();
        Integer saveCust = 0;
        Integer saveCustExt =0;
        try {
            tran.start();
            saveCust = customerDao.saveCustomerAndExt(customerDTO, tran);//新增客户基本信息
            saveCustExt = customerExtDao.saveCustomerAndExt(customerDTO, tran);//新增客户注册信息
            if(saveCust > 0 && saveCustExt > 0){
                tran.commit();
                return saveCust;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.debug("新增客户与客户注册信息失败~");
            tran.rollback();
        }finally {
            Closes.closeQuietly(tran);
        }
        return saveCust;
    }

    /**
     * 客户信息唯一性验证
     * @param customer
     * @return
     */
    @Override
    public boolean verifyCustInfoOnly(CustomerDO customer) {
        boolean flag=true;
        try {
            Integer count=customerDao.verifyCustInfoOnly(customer);
            if(count>0){
                flag=false;
            }
        }catch (Exception e){
            log.error("客户信息唯一性验证失败~");
        }
        return flag;
    }


}
