package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.order.api.OrderSampleTypeService;
import com.ccicnavi.bims.order.dao.OrderSampleTypeDao;
import com.ccicnavi.bims.order.pojo.OrderSampleTypeDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @Author heibin
 * @Description 委托样品类型
 * @Date 20:40 2018/11/21
 */
@Slf4j
@Service
public class OrderSampleTypeServiceImpl implements OrderSampleTypeService {
    @Autowired
    OrderSampleTypeDao orderSampleTypeDao;
    /**
     * @Author heibin
     * @Description 根据主键id查询委托样品类型
     * @Date 20:41 2018/11/21
     * @Param [orderSampleTypeDO]
     * @Return OrderSampleTypeDO
     */
    @Override
    public OrderSampleTypeDO getOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) {
        try {
            return orderSampleTypeDao.getOrderSampleType(orderSampleTypeDO);
        } catch (Exception e) {
            log.error("根据主键id查询委托样品类型失败~",e);
            return null;
        }
    }

    /**
     * @Author heibin
     * @Description 查询全部委托样品类型
     * @Date 20:44 2018/11/21
     * @Param [orderSampleTypeDO]
     * @Return List<OrderSampleTypeDO>
     */
    @Override
    public List<OrderSampleTypeDO> listOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) {
        try {
            return orderSampleTypeDao.listOrderSampleType(orderSampleTypeDO);
        } catch (Exception e) {
            log.error("查询全部委托样品类型失败~",e);
            return null;
        }
    }

    /**
     * @Author heibin
     * @Description 委托样品类型添加
     * @Date 20:45 2018/11/21
     * @Param [orderSampleTypeDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderSampleTypeDao.insertOrderSampleType(orderSampleTypeDO, eqlTran);
        } catch (Exception e) {
            log.error("委托样品类型添加失败",e);
        }
        return integer;
    }

    /**
     * @Author heibin
     * @Description 委托样品类型更新
     * @Date 20:47 2018/11/21
     * @Param [orderSampleTypeDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderSampleTypeDao.updateOrderSampleType(orderSampleTypeDO, eqlTran);
        } catch (Exception e) {
            log.error("委托样品类型更新失败",e);
        }
        return integer;
    }

    /**
     * @Author heibin
     * @Description 委托样品类型删除
     * @Date 20:49 2018/11/21
     * @Param [orderSampleTypeDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderSampleTypeDao.deleteOrderSampleType(orderSampleTypeDO, eqlTran);
        } catch (Exception e) {
            log.error("委托样品类型删除失败",e);
        }
        return integer;
    }
}
