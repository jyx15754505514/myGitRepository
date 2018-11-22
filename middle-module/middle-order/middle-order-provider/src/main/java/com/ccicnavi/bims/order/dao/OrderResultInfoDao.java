package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderResultInfoDO;
import org.n3r.eql.EqlTran;
import java.util.List;
/**
 * @Author heibin
 * @Description 证书结果
 * @Date 14:55 2018/11/20
 */
public interface OrderResultInfoDao {
    /**
     * @Author heibin
     * @Description 根据主键id查询证书结果信息
     * @Date 14:55 2018/11/20
     * @Param [orderResultInfoDO]
     * @Return com.ccicnavi.bims.order.pojo.OrderResultInfoDO
     */
    OrderResultInfoDO getOrderResultInfo(OrderResultInfoDO orderResultInfoDO) throws Exception;
    /**
     * @Author heibin
     * @Description 查询全部证书结果信息
     * @Date 14:55 2018/11/20
     * @Param [orderResultInfoDO]
     * @Return java.util.List<com.ccicnavi.bims.order.pojo.OrderResultInfoDO>
     */
    List<OrderResultInfoDO> listOrderResultInfo(OrderResultInfoDO orderResultInfoDO) throws Exception;
    /**
     * @Author heibin
     * @Description 新增证书结果
     * @Date 14:55 2018/11/20
     * @Param [orderResultInfoDO, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception;
    /**
     * @Author heibin
     * @Description 更新证书结果
     * @Date 14:55 2018/11/20
     * @Param [orderResultInfoDO, tran]
     * @Return java.lang.Integer
     */
    Integer updateOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception;
   /**
    * @Author heibin
    * @Description 删除证书结果
    * @Date 14:55 2018/11/20
    * @Param [orderResultInfoDO, tran]
    * @Return java.lang.Integer
    */
   Integer deleteOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception;

}
