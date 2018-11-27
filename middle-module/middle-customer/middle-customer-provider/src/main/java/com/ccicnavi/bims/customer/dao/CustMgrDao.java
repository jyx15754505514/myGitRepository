package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustMgrDO;

import java.util.List;

/**
 * @Auther: congzhiyuan
 * @Date: 2018/11/27 10:52
 * @Description: 跟进人管理
 * @Version 1.0
 */
public interface CustMgrDao {

    List<CustMgrDO> listCustMgr(CustMgrDO custMgrDO) throws Exception;

    PageBean<CustMgrDO> listCustMgrPage(PageParameter<CustMgrDO> pageParameter);

    int insertCustMgr(CustMgrDO custMgrDO) throws Exception;

    int deleteCustMgr(CustMgrDO custMgrDO) throws Exception;

    CustMgrDO getCustMgr(CustMgrDO custMgrDO);
}
