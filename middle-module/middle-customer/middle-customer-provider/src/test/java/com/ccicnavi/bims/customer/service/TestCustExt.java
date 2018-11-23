package com.ccicnavi.bims.customer.service;

import com.ccicnavi.bims.customer.dao.Impl.CustomerExtDaoImpl;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import com.ccicnavi.bims.customer.pojo.CustomerExtDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCustExt {



    @org.junit.Test
    public void listCustAddr() {
        CustomerExtDaoImpl custAddrDao=new CustomerExtDaoImpl();
        List<CustomerExtDO> custAddrDOS = custAddrDao.listCustomerExt(new CustomerExtDO());
        System.out.println(custAddrDOS);
    }

    @org.junit.Test
    public void saveCustAddr() {
    }

    @org.junit.Test
    public void removeCustAddr() {
    }

    @org.junit.Test
    public void updateCustAddr() {
    }

    @org.junit.Test
    public void getCustAddr() {
    }

    /**
     * ----------------------------------Junit测试----------------------------------
     */

    @Test
    public void testListCustomerExt(){
        List<CustomerExtDO> custList= EqlUtils.getInstance("druid").select("listCustomerExt").returnType(CustomerExtDO.class).execute();
        System.out.println(custList);
    }

    @Test
    public void testSaveCustomerExt(){
        for (int i = 1; i <=10; i++) {
            CustomerExtDO customerExt=new CustomerExtDO();
            customerExt.setCustUuid("asd"+i);
            customerExt.setLegalRep("法人"+i);
            int count= EqlUtils.getInstance("druid").select("insertCustomerExt").params(customerExt).execute();
            System.out.println("count"+i);
        }
    }

    /***
     * 新增客户注册信息
     */
    @Test
    public void testSaveCustomerAndExt(){
        for (int i = 1; i <=10; i++) {
            CustomerDTO customerExt=new CustomerDTO();
            customerExt.setCustUuid("asdEX"+i);
            customerExt.setLegalRep("法人EX"+i);
            int count= EqlUtils.getInstance("druid").select("insertCustomerExt").params(customerExt).execute();
            System.out.println("count"+i);
        }
    }


    @Test
    public void testUpdateCustomerExt(){
        CustomerExtDO customerExt=new CustomerExtDO();
        customerExt.setCustUuid("asd1");
        customerExt.setLegalRep("asd1被修改了~");
        EqlUtils.getInstance("druid").update("updateCustomerExt").params(customerExt).execute();
    }


    @Test
    public void deleteCustomerExt(){
        String uuids="asd1,asd10,asd2";
        String [] ids=uuids.split(",");
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",ids);
        int count=EqlUtils.getInstance("druid").update("deleteCustomerExt").params(data).execute();
        System.out.println(count);
    }


    @Test
    public void testCustomerExt(){
        CustomerExtDO CustomerExt=new CustomerExtDO();
        CustomerExt.setCustUuid("asd1");
        CustomerExtDO getCustomerExt= EqlUtils.getInstance("druid").selectFirst("listCustomerExt").params(CustomerExt).returnType(CustomerExtDO.class).execute();
        System.out.println(getCustomerExt);
    }


   /* @Test
    public void testInsertCustomerExt(){
        CustomerDO customer=new CustomerDO();
        customer.setCustUuid("asd1890");
        CustomerExtDO customerExtDO=new CustomerExtDO();
        customerExtDO.setBankAccount("asdadad");
        customer.setCustomerExtDO(customerExtDO);
        Integer count= EqlUtils.getInstance("druid").insert("insertCustomerExt").params(customer).execute();
        System.out.println(count);
    }*/



}
