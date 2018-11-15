package com.ccicnavi.bims.customer.api;


import com.ccicnavi.bims.customer.pojo.CustAddrDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户地址接口定义
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
public interface CustAddrService {

    /**查询全部客户地址信息*/
    List<CustAddrDO> listCustAddr(CustAddrDO CustAddr);

    /**新增客户地址信息*/
    int saveCustAddr(CustAddrDO CustAddr);

    /**删除客户地址信息*/
    int removeCustAddr(String uuids);

    /**修改客户地址信息*/
    int updateCustAddr(CustAddrDO CustAddr) ;

    /**根据主键返回对应信息*/
    CustAddrDO getCustAddr(CustAddrDO CustAddr);

}
