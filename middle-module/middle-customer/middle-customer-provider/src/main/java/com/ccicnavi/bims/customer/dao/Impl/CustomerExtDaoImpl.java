package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.CustomerExtDao;
import com.ccicnavi.bims.customer.pojo.CustomerExtDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;
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
    public List<CustomerExtDO> listCustomerExt(CustomerExtDO CustomerExt) {
        return EqlUtils.getInstance("druid").select("listCustomerExt").params(CustomerExt).execute();
    }

    @Override
    public int saveCustomerExt(CustomerExtDO CustomerExt) {
        return EqlUtils.getInstance("druid").insert("insertCustomerExt").params(CustomerExt).execute();
    }

    @Override
    public int removeCustomerExt(String uuids) {
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",uuids.split(","));
        return EqlUtils.getInstance("druid").update("deleteCustomerExt").params(data).execute();
    }

    @Override
    public int updateCustomerExt(CustomerExtDO CustomerExt) {
        return EqlUtils.getInstance("druid").update("updateCustomerExt").params(CustomerExt).execute();
    }

    @Override
    public CustomerExtDO getCustomerExt(CustomerExtDO CustomerExt) {
        return EqlUtils.getInstance("druid").selectFirst("listCustomerExt").params(CustomerExt).returnType(CustomerExtDO.class).execute();
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








}
