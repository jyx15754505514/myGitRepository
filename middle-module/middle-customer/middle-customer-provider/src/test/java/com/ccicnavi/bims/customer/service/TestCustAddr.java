package com.ccicnavi.bims.customer.service;

import com.ccicnavi.bims.customer.dao.Impl.CustAddrDaoImpl;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;

import java.util.List;

public class TestCustAddr{



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
}
