package com.ccicnavi.bims.customer.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.CustomerExtService;
import com.ccicnavi.bims.customer.dao.CustomerExtDao;
import com.ccicnavi.bims.customer.pojo.CustomerExtDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户注册信息基本操作
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
@Slf4j
public class CustomerExtServiceImpl implements CustomerExtService {

    @Autowired
    CustomerExtDao customerExtDao;

    @Override
    public List<CustomerExtDO> listCustomerExt(CustomerExtDO CustomerExt) {
        List<CustomerExtDO> custInvoceList=null;
        try {
            custInvoceList=customerExtDao.listCustomerExt(CustomerExt);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询客户注册信息失败",e);
        }
        return custInvoceList;
    }

    @Override
    public int saveCustomerExt(CustomerExtDO CustomerExt) {
        Integer count=0;
        try {
            count= customerExtDao.saveCustomerExt(CustomerExt);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("保存客户注册信息失败",e);
        }
        return count;
    }

    @Override
    public int removeCustomerExt(String uuids) {
        Integer count=0;
        try {
            count=customerExtDao.removeCustomerExt(uuids);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除客户注册信息失败",e);
        }
        return count;
    }

    @Override
    public int updateCustomerExt(CustomerExtDO CustomerExt) {
        Integer count=0;
        try {
            count=customerExtDao.updateCustomerExt(CustomerExt);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("修改客户注册信息失败",e);
        }
        return count;
    }

    @Override
    public CustomerExtDO getCustomerExt(CustomerExtDO CustomerExtDO) {
        CustomerExtDO CustomerExt=null;
        try {
            CustomerExt=customerExtDao.getCustomerExt(CustomerExtDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("根据主键查询客户注册信息信息失败~",e);
        }
        return CustomerExt;
    }


}
