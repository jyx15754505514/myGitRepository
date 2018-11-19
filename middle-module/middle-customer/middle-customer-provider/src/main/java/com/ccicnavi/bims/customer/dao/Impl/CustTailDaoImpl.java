package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.CustTailDao;
import com.ccicnavi.bims.customer.pojo.CustTailDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户跟踪信息数据库交互
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
public class CustTailDaoImpl implements CustTailDao {

    @Override
    public List<CustTailDO> listCustTail(CustTailDO custTail) {
        return new Eql().select("listCustTail").params(custTail).execute();
    }

    @Override
    public int saveCustTail(CustTailDO custTail, EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertCustTail").params(custTail).returnType(int.class).execute();
    }

    @Override
    public int removeCustTail(CustTailDO custTail,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("deleteCustTail").params(custTail).returnType(int.class).execute();
    }

    @Override
    public int updateCustTail(CustTailDO custTail,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("updateCustTail").params(custTail).returnType(int.class).execute();
    }

    @Override
    public CustTailDO getCustTail(CustTailDO custTail) {
        return new Eql().selectFirst("getCustTail").params(custTail).returnType(CustTailDO.class).execute();
    }

    @Override
    public PageBean<CustTailDO> listCustTailPage(PageParameter<CustTailDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CustTailDO> custTailList = new Eql().select("listCustTail").params(pageParameter.getParameter()).returnType(CustTailDO.class).limit(page).execute();
        if(custTailList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),custTailList);
        }else {
            return null;
        }
    }


}
