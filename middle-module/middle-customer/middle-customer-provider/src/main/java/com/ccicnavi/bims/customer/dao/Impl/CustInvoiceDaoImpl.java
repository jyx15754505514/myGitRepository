package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.CustInvoiceDao;
import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int removeCustInvoice(CustInvoiceDO custInvoice) {
        return new Eql().update("deleteCustInvoice").params(custInvoice).execute();
    }

    @Override
    public int updateCustInvoice(CustInvoiceDO custInvoice) {
        return new Eql().update("updateCustInvoice").params(custInvoice).execute();
    }

    @Override
    public CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoice) {
        return new Eql().selectFirst("listCustInvoice").params(custInvoice).returnType(CustInvoiceDO.class).execute();
    }

    @Override
    public PageBean<CustInvoiceDO> listCustInvoicePage(PageParameter<CustInvoiceDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CustInvoiceDO> custInvoiceList = new Eql().select("listCustInvoice").params(pageParameter.getParameter()).returnType(CustInvoiceDO.class).limit(page).execute();
        if(custInvoiceList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),custInvoiceList);//分装分页
        }else {
            return null;
        }
    }


}
