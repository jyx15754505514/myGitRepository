package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.order.api.OrderItemService;
import com.ccicnavi.bims.order.dao.OrderItemCostDao;
import com.ccicnavi.bims.order.dao.OrderItemDao;
import com.ccicnavi.bims.order.pojo.OrderItemCostDo;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 17:30 2018/11/19
 */
@Slf4j
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private OrderItemCostDao orderItemCostDao;

    /**
     * @Author MengZiJie
     * @Description 添加服务项
     * @Date 17:30 2018/11/19
     * @Param [orderItemDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderItem(OrderItemDTO orderItemDTO) {
        Integer orderItem = null;
        try {
            orderItem = orderItemDao.insertOrderItem(orderItemDTO, null);
        } catch (Exception e) {
            log.error("添加服务项失败",e);
        }
        return orderItem;
    }

    /**
     * @Author MengZiJie
     * @Description 更新服务项
     * @Date 17:31 2018/11/19
     * @Param [orderItemDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderItem(OrderItemDTO orderItemDTO) {
        Integer orderItem = null;
        try {
            orderItem = orderItemDao.updateOrderItem(orderItemDTO, null);
        } catch (Exception e) {
            log.error("更新服务项失败",e);
        }
        return orderItem;
    }

    /**
     * @Author MengZiJie
     * @Description 分配任务
     * @Date 16:40 2018/11/22
     * @Param [orderItemDTO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer assignOrderItem(OrderItemDTO orderItemDTO) {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        try {
            eqlTran.start();
            Integer orderItem = orderItemDao.updateOrderItem(orderItemDTO, eqlTran);
            if (orderItem > 0 ) {
                eqlTran.commit();
                return orderItem;
            }
        } catch (Exception e) {
            log.error("分配失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
        return -1;
    }

    /**
     * @Author MengZiJie
     * @Description 外包任务
     * @Date 16:40 2018/11/22
     * @Param [orderItemDTO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer outsourcOrderItem(OrderItemDTO orderItemDTO) {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        Boolean statu = true;
        try {
            eqlTran.start();
            Integer integer = orderItemDao.updateOrderItem(orderItemDTO, eqlTran);
            if(integer <= 0){
                statu = false;
            }
            if (orderItemDTO.getOrderItemCostDo().size() > 0) {
                List<OrderItemCostDo> orderItemCostDo = orderItemDTO.getOrderItemCostDo();
                for (int i = 0;i < orderItemCostDo.size();i++) {
                    Integer itemCost = orderItemCostDao.updateOrderItemCost(orderItemCostDo.get(i), eqlTran);
                    if (itemCost <= 0) {
                        statu = false;
                    }
                }
            }
            if (statu = true) {
                eqlTran.commit();
                return 1;
            }
        } catch (Exception e) {
            log.error("外包失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
        return -1;
    }

}
