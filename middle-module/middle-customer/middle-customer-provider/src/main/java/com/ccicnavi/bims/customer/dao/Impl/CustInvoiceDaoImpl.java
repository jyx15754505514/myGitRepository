package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.CustInvoiceDao;
import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustInvoiceDaoImpl implements CustInvoiceDao {



    @Override
    public List<CustInvoiceDO> listCustInvoice(CustInvoiceDO custInvoice) {
        return EqlUtils.getInstance("druid").select("listCustInvoice").params(custInvoice).execute();
    }

    @Override
    public int saveCustInvoice(CustInvoiceDO custInvoice) {
        return EqlUtils.getInstance("druid").insert("insertCustInvoice").params(custInvoice).execute();
    }

    @Override
    public int removeCustInvoice(String uuids) {
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",uuids.split(","));
        return EqlUtils.getInstance("druid").update("deleteCustInvoice").params(data).execute();
    }

    @Override
    public int updateCustInvoice(CustInvoiceDO custInvoice) {
        return EqlUtils.getInstance("druid").update("updateCustInvoice").params(custInvoice).execute();
    }

    @Override
    public CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoice) {
        return EqlUtils.getInstance("druid").selectFirst("listCustInvoice").params(custInvoice).execute();
    }


    /**
     * ————————————Junit测试————————————————————————
     */

    @Test
    public void testListCustInvoice(){
        List<CustInvoiceDO> custList= EqlUtils.getInstance("druid").select("listCustInvoice").returnType(CustInvoiceDO.class).execute();
        System.out.println(custList);
    }

    @Test
    public void testSaveCustInvoice(){
        for (int i = 1; i <=10; i++) {
            CustInvoiceDO custInvoice=new CustInvoiceDO();
            custInvoice.setInvoiceUuid("客户发票"+i);
            custInvoice.setCustUuid("客户发票"+i);
            custInvoice.setIsTaxpayer("N");
            int count= EqlUtils.getInstance("druid").select("insertCustInvoice").params(custInvoice).execute();
            System.out.println("count"+i);
        }
    }

    @Test
    public void testUpdateCustInvoice(){
        CustInvoiceDO custInvoiceDO=new CustInvoiceDO();
        custInvoiceDO.setInvoiceUuid("客户发票1");
        custInvoiceDO.setBankName("客户发票1被修改了~");
        int count=EqlUtils.getInstance("druid").update("updateCustInvoice").params(custInvoiceDO).execute();
        System.out.println(count);
    }


    @Test
    public void deleteCustInvoice(){
        String uuids="客户发票1,客户发票10,客户发票2";
        String [] ids=uuids.split(",");
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",ids);
        int count=EqlUtils.getInstance("druid").update("deleteCustInvoice").params(data).execute();
        System.out.println(count);
    }

    @Test
    public void testGetCustInvoice(){
        CustInvoiceDO custInvoice=new CustInvoiceDO();
        custInvoice.setInvoiceUuid("客户发票1");
        CustInvoiceDO custInvoiceDo= EqlUtils.getInstance("druid").selectFirst("listCustInvoice").params(custInvoice).returnType(CustInvoiceDO.class).execute();
        System.out.println(custInvoiceDo);
    }



}
