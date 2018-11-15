package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.CustomerDao;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;
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
    public List<CustomerDO> listCustomer(CustomerDO customer) {
        return EqlUtils.getInstance("druid").select("listCustomer").params(customer).execute();
    }

    @Override
    public int saveCustomer(CustomerDO customer) {
        return EqlUtils.getInstance("druid").insert("insertCustomer").params(customer).execute();
    }

    @Override
    public int removeCustomer(String uuids) {
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",uuids.split(","));
        return EqlUtils.getInstance("druid").update("deleteCustomer").params(data).execute();
    }

    @Override
    public int updateCustomer(CustomerDO customer) {
        return EqlUtils.getInstance("druid").update("updateCustomer").params(customer).execute();
    }

    @Override
    public CustomerDO getCustomer(CustomerDO customer) {
        return EqlUtils.getInstance("druid").selectFirst("listCustomer").params(customer).returnType(CustomerDO.class).execute();
    }


    /**
     * ----------------------------测试-------------------------------------------------
     */

    @Test
    public void testListCustomer(){
        List<CustomerDO> custList= EqlUtils.getInstance("druid").select("listCustomer").returnType(CustomerDO.class).execute();
        System.out.println(custList);
    }

    @Test
    public void testSaveCustomer(){
        for (int i = 1; i <=10; i++) {
            CustomerDO customer=new CustomerDO();
            customer.setCustUuid("asd"+i);
            customer.setCustName("客户"+i);
            customer.setIsSediment("Y");
            customer.setCustAddr("客户地址"+i);
            customer.setBusinessLine("CUSTOMER");
            customer.setOrgUuid("XN102");
            customer.setAppSysUuid("KKLIMS102");
            int count= EqlUtils.getInstance("druid").select("insertCustomer").params(customer).execute();
            System.out.println("count"+i);
        }
    }

    @Test
    public void testUpdateCustomer(){
        CustomerDO customer=new CustomerDO();
        customer.setCustUuid("asd1");
        customer.setCustName("asd1被修改了~");
        EqlUtils.getInstance("druid").update("updateCustomer").params(customer).execute();
    }


    @Test
    public void deleteCustomer(){
        String uuids="asd1,asd10,asd2";
        String [] ids=uuids.split(",");
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",ids);
        int count=EqlUtils.getInstance("druid").update("deleteCustomer").params(data).execute();
        System.out.println(count);
    }


    @Test
    public void testCustomer(){
        CustomerDO customer=new CustomerDO();
        customer.setCustUuid("asd1");
        CustomerDO getCustomer= EqlUtils.getInstance("druid").selectFirst("listCustomer").params(customer).returnType(CustomerDO.class).execute();
        System.out.println(getCustomer);
    }




}
