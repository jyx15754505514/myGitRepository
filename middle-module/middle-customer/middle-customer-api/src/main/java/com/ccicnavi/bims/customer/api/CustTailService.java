package com.ccicnavi.bims.customer.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustTailDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户跟踪信息接口定义
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
public interface CustTailService {

    /**查询全部客户跟踪信息*/
    List<CustTailDO> listCustTail(CustTailDO custTail);

    /**新增客户跟踪信息*/
    int saveCustTail(CustTailDO custTail);

    /**删除客户跟踪信息*/
    int removeCustTail(CustTailDO custTail);

    /**修改客户跟踪信息*/
    int updateCustTail(CustTailDO custTail);

    /**根据主键查询客户跟踪信息*/
    CustTailDO getCustTail(CustTailDO custTail);

    /**分页查询客户跟踪信息*/
    PageBean<CustTailDO> listCustTailPage(PageParameter<CustTailDO> pageParameter);
}
