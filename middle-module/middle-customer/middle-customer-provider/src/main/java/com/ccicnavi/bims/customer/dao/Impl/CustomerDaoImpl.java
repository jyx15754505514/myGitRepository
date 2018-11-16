package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.CustomerDao;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bims-backend
 * @description: 客户数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
public class CustomerDaoImpl implements CustomerDao {


    @Override
    public List<CustomerDO> listCustomer(CustomerDO customer) throws Exception{
        return new Eql().select("listCustomer").params(customer).returnType(CustomerDO.class).execute();
    }

    @Override
    public int saveCustomer(CustomerDO customer) throws Exception{
        return new Eql().insert("insertCustomer").params(customer).execute();
    }

    @Override
    public int removeCustomer(String uuids) throws Exception{
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",uuids.split(","));
        return new Eql().update("deleteCustomer").params(data).execute();
    }

    @Override
    public int updateCustomer(CustomerDO customer) throws Exception{
        return new Eql().update("updateCustomer").params(customer).execute();
    }

    @Override
    public CustomerDO getCustomer(CustomerDO customer) throws Exception{
        return new Eql().selectFirst("listCustomer").params(customer).returnType(CustomerDO.class).execute();
    }

    @Override
    public int saveCustomerAndExt(CustomerDTO customerDTO, EqlTran tran) throws Exception {
        return new Eql().useTran(tran).insert("insertCustomer").params(customerDTO).execute();
    }


    @Override
    public int verifyCustInfoOnly(CustomerDO customer) throws Exception {
        return new Eql().select("verifyCustInfoOnly").params(customer).returnType(int.class).execute();
    }








}
