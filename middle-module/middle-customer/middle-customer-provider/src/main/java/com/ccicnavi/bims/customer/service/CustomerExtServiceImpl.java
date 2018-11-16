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
        try {
            return customerExtDao.listCustomerExt(CustomerExt);
        } catch (Exception e) {
            log.error("查询客户注册信息失败",e);
            return null;
        }
    }

    @Override
    public int saveCustomerExt(CustomerExtDO CustomerExt) {
        try {
            return customerExtDao.saveCustomerExt(CustomerExt);
        } catch (Exception e) {
            log.error("保存客户注册信息失败",e);
            return 0;
        }
    }

    @Override
    public int removeCustomerExt(String uuids) {
        try {
            return customerExtDao.removeCustomerExt(uuids);
        } catch (Exception e) {
            log.error("删除客户注册信息失败",e);
            return 0;
        }
    }

    @Override
    public int updateCustomerExt(CustomerExtDO CustomerExt) {
        try {
            return customerExtDao.updateCustomerExt(CustomerExt);
        } catch (Exception e) {
            log.error("修改客户注册信息失败",e);
            return 0;
        }
    }

    @Override
    public CustomerExtDO getCustomerExt(CustomerExtDO CustomerExtDO) {
        try {
            return customerExtDao.getCustomerExt(CustomerExtDO);
        } catch (Exception e) {
            log.error("根据主键查询客户注册信息信息失败~",e);
            return null;
        }
    }


}
