package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustTailDO;
import org.n3r.eql.EqlTran;

import java.util.List;

public interface CustTailDao {

    List<CustTailDO> listCustTail(CustTailDO custTail) throws Exception;

    int saveCustTail(CustTailDO custTail, EqlTran tran) throws Exception;

    int removeCustTail(CustTailDO custTail, EqlTran tran) throws Exception;

    int updateCustTail(CustTailDO custTail, EqlTran tran) throws Exception;

    CustTailDO getCustTail(CustTailDO custTail) throws Exception;

    PageBean<CustTailDO> listCustTailPage(PageParameter<CustTailDO> pageParameter) throws Exception;
}
