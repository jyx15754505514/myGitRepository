package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.order.api.OrderSampleService;
import com.ccicnavi.bims.order.dao.impl.OrderSampleDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderSampleDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;

/**
 * @Author songyateng
 * @Description 样品信息
 * @Date 2018/11/27 23:23
 */
@Slf4j
@Service
public class OrderSampleServiceImpl implements OrderSampleService {
    /**
     * @Author songyateng
     * @Description 更新样品信息
     * @Date 2018/11/27 23:23
     * @Param [orderSampleDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderSample(OrderSampleDO orderSampleDO) {
        EqlTran eqlTran = null;
        Integer orderInfo = null;
        try {
            OrderSampleDaoImpl orderSampleDao = new OrderSampleDaoImpl();
            orderInfo = orderSampleDao.updateOrderSample(orderSampleDO,eqlTran);
            if(orderInfo > 0){
                return orderInfo;
            }
        } catch (Exception e) {
            log.error("更新委托单信息",e);
        }
        return -1;
    }
}
