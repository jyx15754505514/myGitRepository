package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderSampleDO;
import org.n3r.eql.EqlTran;
import java.util.List;

/**
 * @Author MengZiJie
 * @Description 标准样品库
 * @Date 18:01 2018/11/20
 */
public interface OrderSampleDao {

   /**
    * @Author MengZiJie
    * @Description 添加样品信息
    * @Date 16:54 2018/11/20
    * @Param [orderSampleDO]
    * @Return java.lang.Integer
    */
    Integer insertOrderSample(OrderSampleDO orderSampleDO, EqlTran tran);

    /**
     * @Author MengZiJie
     * @Description 删除样品
     * @Date 16:55 2018/11/20
     * @Param [orderSampleDO]
     * @Return java.lang.Integer
     */
    Integer deleteOrderSample(OrderSampleDO orderSampleDO,EqlTran tran);

    /**
      * @author songyateng
      * @description
      * @date 2018/11/23 14:42
      * @Param [orderSampleDO]
      * @return java.util.List<com.ccicnavi.bims.order.pojo.OrderSampleDO>
      */
    List<OrderSampleDO> listOrderSample(OrderSampleDO orderSampleDO) throws Exception;
}
