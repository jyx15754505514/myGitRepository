package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.CustTailDO;

import java.util.List;

public interface CustTailDao {

    List<CustTailDO> listCustTail(CustTailDO custTail);

    int saveCustTail(CustTailDO custTail);

    int removeCustTail(String uuids);

    int updateCustTail(CustTailDO custTail);

    CustTailDO getCustTail(CustTailDO custTail);
}
