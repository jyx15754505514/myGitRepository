package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.CustAddrDao;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户地址数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
public class CustAddrDaoImpl implements CustAddrDao {

    @Override
    public List<CustAddrDO> listCustAddr(CustAddrDO custAddr) {
        return new Eql().select("listCustAddr").params(custAddr).returnType(CustAddrDO.class).execute();
    }

    @Override
    public int saveCustAddr(CustAddrDO custAddr) {
        return new Eql().insert("insertCustAddr").params(custAddr).returnType(int.class).execute();
    }

    @Override
    public int removeCustAddr(CustAddrDO custAddr) {
        return new Eql().update("deleteCustAddr").params(custAddr).returnType(int.class).execute();
    }

    @Override
    public int updateCustAddr(CustAddrDO custAddr) {
        return new Eql().update("updateCustAddr").params(custAddr).returnType(int.class).execute();
    }

    @Override
    public CustAddrDO getCustAddr(CustAddrDO customer) {
        return new Eql().selectFirst("getCustAddr").params(customer).returnType(CustAddrDO.class).execute();
    }

    @Override
    public PageBean<CustAddrDO> listCustAddrPage(PageParameter<CustAddrDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CustAddrDO> custAddrList = new Eql().select("listCustAddr").params(pageParameter.getParameter()).returnType(CustAddrDO.class).limit(page).execute();
        if(custAddrList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),custAddrList);//分装分页
        }else {
            return null;
        }
    }


}
