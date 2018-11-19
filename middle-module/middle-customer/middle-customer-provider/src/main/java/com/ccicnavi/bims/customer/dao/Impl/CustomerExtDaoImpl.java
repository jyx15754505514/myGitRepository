package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.CustomerExtDao;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import com.ccicnavi.bims.customer.pojo.CustomerExtDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int saveCustomerExt(CustomerExtDO customerExt,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertCustomerExt").params(customerExt).returnType(int.class).execute();
    }

    @Override
    public int removeCustomerExt(CustomerDO customerDO,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("deleteCustomerExt").params(customerDO).returnType(int.class).execute();
    }

    @Override
    public int updateCustomerExt(CustomerExtDO customerExt,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("updateCustomerExt").params(customerExt).returnType(int.class).execute();
    }

    @Override
    public CustomerExtDO getCustomerExt(CustomerExtDO customerExt) {
        return new Eql().selectFirst("listCustomerExt").params(customerExt).returnType(CustomerExtDO.class).execute();
    }

    @Override
    public int saveCustomerAndExt(CustomerDTO customerDTO, EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertCustomerExt").params(customerDTO).returnType(int.class).execute();
    }


}
