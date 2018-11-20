package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderResultInfoDO;
import org.n3r.eql.EqlTran;

import java.util.List;

/* *
 * @Author heibin
 * @Description 证书结果
 * @Date 14:55 2018/11/20
 * @Param
 * @Return
 */
public interface OrderResultInfoDao {
    /**根据主键id查询证书结果信息*/
    OrderResultInfoDO getOrderResultInfo(OrderResultInfoDO orderResultInfoDO) throws Exception;
    /**查询全部证书结果信息*/
    List<OrderResultInfoDO> listOrderResultInfo(OrderResultInfoDO orderResultInfoDO) throws Exception;
    /**新增证书结果*/
    Integer insertOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception;
    /**更新证书结果*/
    Integer updateOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception;
   /**删除证书结果*/
   Integer deleteOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception;

}
