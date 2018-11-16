package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.CustomerExtDao;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import com.ccicnavi.bims.customer.pojo.CustomerExtDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bims-backend
 * @description: 客户注册信息数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:21
 */
@Service
public class CustomerExtDaoImpl implements CustomerExtDao {


    @Override
    public List<CustomerExtDO> listCustomerExt(CustomerExtDO customerExt) {
        return new Eql().select("listCustomerExt").params(customerExt).returnType(CustomerExtDO.class).execute();
    }

    @Override
    public int saveCustomerExt(CustomerExtDO customerExt) {
        return new Eql().insert("insertCustomerExt").params(customerExt).execute();
    }

    @Override
    public int removeCustomerExt(String uuids) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("ids", uuids.split(","));
        return new Eql().update("deleteCustomerExt").params(data).execute();
    }

    @Override
    public int updateCustomerExt(CustomerExtDO customerExt) {
        return new Eql().update("updateCustomerExt").params(customerExt).execute();
    }

    @Override
    public CustomerExtDO getCustomerExt(CustomerExtDO customerExt) {
        return new Eql().selectFirst("listCustomerExt").params(customerExt).returnType(CustomerExtDO.class).execute();
    }

    @Override
    public int saveCustomerAndExt(CustomerDTO customerDTO, EqlTran tran) {
        return new Eql().insert("insertCustomerExt").useTran(tran).params(customerDTO).execute();
    }


}
