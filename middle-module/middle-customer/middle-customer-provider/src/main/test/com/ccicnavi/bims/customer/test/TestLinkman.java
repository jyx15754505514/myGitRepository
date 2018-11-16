package com.ccicnavi.bims.customer.test;

import com.ccicnavi.bims.customer.dao.Impl.CustAddrDaoImpl;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestLinkman {



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
    public void testListLinkman(){
        List<LinkmanDO> custList= EqlUtils.getInstance("druid").select("listLinkman").returnType(LinkmanDO.class).execute();
        System.out.println(custList);
    }

    @Test
    public void testSaveLinkman(){
        for (int i = 1; i <=10; i++) {
            LinkmanDO linkman=new LinkmanDO();
            linkman.setLinkmanUuid("客户联系人"+i);
            linkman.setCustUuid("客户"+i);
            linkman.setLinkmanName("客户联系人"+i);
            int count= EqlUtils.getInstance("druid").select("insertLinkman").params(linkman).execute();
            System.out.println("count"+i);
        }
    }

    @Test
    public void testUpdateLinkman(){
        LinkmanDO linkmanDO=new LinkmanDO();
        linkmanDO.setLinkmanUuid("客户联系人1");
        linkmanDO.setLinkmanName("客户联系人1被修改了~");
        int count=EqlUtils.getInstance("druid").update("updateLinkman").params(linkmanDO).execute();
        System.out.println(count);
    }


    @Test
    public void deleteLinkman(){
        String uuids="客户联系人1,客户联系人10,客户联系人2";
        String [] ids=uuids.split(",");
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",ids);
        int count=EqlUtils.getInstance("druid").update("deleteLinkman").params(data).execute();
        System.out.println(count);
    }

    @Test
    public void getLinkman(){
        LinkmanDO linkmanDO=new LinkmanDO();
        linkmanDO.setLinkmanUuid("客户联系人1");
        LinkmanDO linkman= EqlUtils.getInstance("druid").selectFirst("listLinkman").params(linkmanDO).returnType(LinkmanDO.class).execute();
        System.out.println(linkman);
    }



}
