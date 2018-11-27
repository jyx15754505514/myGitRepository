package com.ccicnavi.bims.customer.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustMgrDO;
import com.ccicnavi.bims.customer.pojo.CustTailDO;

import java.util.List;

/**
 * @Auther: congzhiyuan
 * @Date: 2018/11/27 11:26
 * @Description: 客户跟进人管理
 * @Version 1.0
 */
public interface CustMgrService {
    /**查询全部客户跟进人*/
    List<CustMgrDO> listCustMgr(CustMgrDO custMgrDO);
    /**分页查询客户跟进人信息*/
    PageBean<CustMgrDO> listCustMgrPage(PageParameter<CustMgrDO> pageParameter);
    /**新增客户跟进人信息*/
    int insertCustMgr(CustMgrDO custMgrDO);
    /**删除客户跟进人信息*/
    int deleteCustMgr(CustMgrDO custMgrDO);
    /**获取客户跟进人详细信息*/
    public CustMgrDO getCustMgr(CustMgrDO custMgrDO);
}
