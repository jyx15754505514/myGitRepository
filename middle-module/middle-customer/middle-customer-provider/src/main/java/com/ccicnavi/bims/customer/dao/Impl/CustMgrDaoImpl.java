package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.CustMgrDao;
import com.ccicnavi.bims.customer.pojo.CustMgrDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: congzhiyuan
 * @Date: 2018/11/27 10:52
 * @Description: 跟进人管理
 * @Version 1.0
 */
@Service
public class CustMgrDaoImpl implements CustMgrDao {
    @Override
    public List<CustMgrDO> listCustMgr(CustMgrDO custMgrDO) throws Exception{
        return new Eql().select("listCustMgr").params(custMgrDO).returnType(CustMgrDO.class).execute();
    }

    @Override
    public PageBean<CustMgrDO> listCustMgrPage(PageParameter<CustMgrDO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CustMgrDO> custList = new Eql().select("listCustMgr").params(pageParameter.getParameter()).returnType(CustMgrDO.class).limit(page).execute();
        if(custList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),custList);
        }else {
            return null;
        }
    }

    @Override
    public int insertCustMgr(CustMgrDO custMgrDO) throws Exception {
        return new Eql().insert("insertCustMgr").params(custMgrDO).returnType(Integer.class).execute();
    }

    @Override
    public int deleteCustMgr(CustMgrDO custMgrDO) throws Exception {
        return new Eql().delete("deleteCustMgr").params(custMgrDO).returnType(Integer.class).execute();
    }

    @Override
    public CustMgrDO getCustMgr(CustMgrDO custMgrDO) {
        return new Eql().selectFirst("listCustMgr").params(custMgrDO).returnType(CustMgrDO.class).execute();
    }
}
