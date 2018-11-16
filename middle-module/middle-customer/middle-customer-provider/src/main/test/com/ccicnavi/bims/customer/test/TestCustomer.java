package com.ccicnavi.bims.customer.test;

import com.ccicnavi.bims.customer.dao.Impl.CustomerDaoImpl;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;
import org.n3r.eql.EqlPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCustomer {



    @org.junit.Test
    public void listCustAddr() {
        CustomerDaoImpl custAddrDao=new CustomerDaoImpl();
        List<CustomerDO> custAddrDOS = null;
        try {
            custAddrDOS = custAddrDao.listCustomer(new CustomerDO());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void testGetCustomer(){
        CustomerDO customer=new CustomerDO();
        customer.setCustUuid("asd1");
        CustomerDO getCustomer= EqlUtils.getInstance("druid").selectFirst("listCustomer").params(customer).returnType(CustomerDO.class).execute();
        System.out.println(getCustomer);
    }


    @Test
    public void testInsertCustExt(){
        CustomerDTO customerDTO=new CustomerDTO();
        customerDTO.setCustUuid("asd186");
        customerDTO.setBankName("中国建设银行");
        customerDTO.setBusinessLine("CUSTOMER");
        customerDTO.setOrgUuid("XN102");
        customerDTO.setAppSysUuid("KKLIMS102");
        Integer count= EqlUtils.getInstance("druid").insert("insertCustomer").params(customerDTO).execute();
        System.out.println(count);
    }

    @Test
    public void testVerifyCustInfoOnly(){
        CustomerDO customer=new CustomerDO();
        //customer.setCustUuid("asd1");
        customer.setCustName("客户1");
        customer.setOrgUuid("XN102");
        customer.setAppSysUuid("KKLIMS102");
        Integer count= EqlUtils.getInstance("druid").selectFirst("verifyCustInfoOnly").params(customer).returnType(int.class).execute();
        System.out.println(count);
    }


    /***
     * 连接查询
     */
    @Test
    public void testQueryConnectCustInfo(){
        List<CustomerDTO> customer= EqlUtils.getInstance("druid").select("listCustomerAndExt").returnType(CustomerDTO.class).execute();
        System.out.println(customer);
    }


    /**
     * 分页
     */
    @Test
    public void testPage(){
        EqlPage page=new EqlPage(3,2);
        List<CustomerDO> custList= EqlUtils.getInstance("druid").select("listCustomer").returnType(CustomerDO.class).params(page).execute();
        System.out.println(page);
        System.out.println(custList);
    }
}
