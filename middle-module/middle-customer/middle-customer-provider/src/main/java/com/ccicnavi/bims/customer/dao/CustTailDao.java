package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.CustTailDO;

import java.util.List;

public interface CustTailDao {

    List<CustTailDO> listCustTail(CustTailDO custTail) throws Exception;

    int saveCustTail(CustTailDO custTail) throws Exception;

    int removeCustTail(String uuids) throws Exception;

    int updateCustTail(CustTailDO custTail) throws Exception;

    CustTailDO getCustTail(CustTailDO custTail) throws Exception;
}
