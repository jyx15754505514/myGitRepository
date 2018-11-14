package com.ccicnavi.bims.customer.api;

import com.ccicnavi.bims.customer.pojo.CustTailDO;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;

import java.util.List;

/**
 *客户跟踪信息
 */
public interface CustTailService {

    /**查询全部客户联系人信息*/
    List<CustTailDO> listCustTail(CustTailDO custTail);

    /**新增客户信息*/
    int saveCustTail(CustTailDO custTail);

    /**删除客户联系人信息*/
    int removeCustTail(String uuids);

    /**修改客户联系人信息*/
    int updateCustTail(CustTailDO custTail);

    CustTailDO getCustTail(CustTailDO custTail);

}
