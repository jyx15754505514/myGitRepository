package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.CustInvoiceDao;
import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bims-backend
 * @description: 客户发票数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
public class CustInvoiceDaoImpl implements CustInvoiceDao {



    @Override
    public List<CustInvoiceDO> listCustInvoice(CustInvoiceDO custInvoice) {
        return new Eql().select("listCustInvoice").params(custInvoice).returnType(CustInvoiceDO.class).execute();
    }

    @Override
    public int saveCustInvoice(CustInvoiceDO custInvoice) {
        return new Eql().insert("insertCustInvoice").params(custInvoice).execute();
    }

    @Override
    public int removeCustInvoice(String uuids) {
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("ids",uuids.split(","));
        return new Eql().update("deleteCustInvoice").params(data).execute();
    }

    @Override
    public int updateCustInvoice(CustInvoiceDO custInvoice) {
        return new Eql().update("updateCustInvoice").params(custInvoice).execute();
    }

    @Override
    public CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoice) {
        return new Eql().selectFirst("listCustInvoice").params(custInvoice).returnType(CustInvoiceDO.class).execute();
    }


}
