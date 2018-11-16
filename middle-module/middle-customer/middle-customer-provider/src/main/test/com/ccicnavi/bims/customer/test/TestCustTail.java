package com.ccicnavi.bims.customer.test;

import com.ccicnavi.bims.customer.dao.Impl.CustAddrDaoImpl;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;
import com.ccicnavi.bims.customer.pojo.CustTailDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCustTail {



    @org.junit.Test
    public void listCustAddr() {
        CustAddrDaoImpl custAddrDao=new CustAddrDaoImpl();
        List<CustAddrDO> custAddrDOS = custAddrDao.listCustAddr(new CustAddrDO());
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
     * ————————————Junit测试————————————————————————
     */

    @Test
    public void testListCustTail(){
        List<CustTailDO> custList= EqlUtils.getInstance("druid").select("listCustTail").returnType(CustTailDO.class).execute();
        System.out.println(custList);
    }

    @Test
    public void testSaveCustTail(){
        for (int i = 1; i <=10; i++) {
            CustTailDO custTail=new CustTailDO();
            custTail.setTailUuid("客户跟踪"+i);
            custTail.setCustUuid("客户跟踪"+i);
            custTail.setIdea("客户跟踪");
            int count= EqlUtils.getInstance("druid").select("insertCustTail").params(custTail).execute();
            System.out.println("count"+i);
        }
    }

    @Test
    public void testUpdateCustTail(){
        CustTailDO custTailDO=new CustTailDO();
        custTailDO.setTailUuid("客户跟踪1");
        custTailDO.setPerformance("客户跟踪1被修改了~");
        int count=EqlUtils.getInstance("druid").update("updateCustTail").params(custTailDO).execute();
        System.out.println(count);
    }


    @Test
    public void deleteCustTail(){
        String uuids="客户跟踪1,客户跟踪10,客户跟踪2";
        String [] ids=uuids.split(",");
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",ids);
        int count=EqlUtils.getInstance("druid").update("deleteCustTail").params(data).execute();
        System.out.println(count);
    }

    @Test
    public void getCustTail(){
        CustTailDO custTailDO=new CustTailDO();
        custTailDO.setTailUuid("客户跟踪1");
        CustTailDO custTail= EqlUtils.getInstance("druid").selectFirst("listCustTail").params(custTailDO).returnType(CustTailDO.class).execute();
        System.out.println(custTail);
    }
}
