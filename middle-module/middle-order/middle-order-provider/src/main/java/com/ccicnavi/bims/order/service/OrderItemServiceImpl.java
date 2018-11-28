package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.api.OrderItemService;
import com.ccicnavi.bims.order.dao.OrderItemCostDao;
import com.ccicnavi.bims.order.dao.OrderItemDao;
import com.ccicnavi.bims.order.pojo.OrderItemCostDO;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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

    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;

    /**
     * @Author MengZiJie
     * @Description 添加服务项
     * @Data 2018/11/19 17:30
     * @Param [orderItemDTO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderItem(OrderItemDTO orderItemDTO) {
        Integer orderItem = null;
        try {
            /**生成uuid*/
            String orderItemUuid = idWorkerService.getId(new Date());
            orderItemDTO.setOrderItemUuid(orderItemUuid);
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
            if (orderItemDTO.getOrderItemCostDO().size() > 0) {
                List<OrderItemCostDO> orderItemCostDO = orderItemDTO.getOrderItemCostDO();
                for (int i = 0;i < orderItemCostDO.size();i++) {
                    Integer itemCost = orderItemCostDao.updateOrderItemCost(orderItemCostDO.get(i), eqlTran);
                    if (itemCost <= 0) {
                        statu = false;
                    }
                }
            }
            if (statu) {
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
    /**
     * @Author songyateng
     * @Description 删除服务项信息
     * @Date 2018/11/28 10:39
     * @Param [orderItemDTO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderItem(OrderItemDTO orderItemDTO) {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        eqlTran.start();
        Integer count = 0;
        try {
            count = orderItemDao.deleteOrderItem(orderItemDTO, eqlTran);
            eqlTran.commit();
        } catch (Exception e) {
            log.error("删除分包方资质信息失败", e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
        return count;
    }
    /**
     * @Author heibin
     * @Description 业务查询分页列表
     * @Date 15:13 2018/11/28
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.order.pojo.OrderItemDTO>
     */
    @Override
    public PageBean<OrderItemDTO> listOrderItemPage(PageParameter<OrderItemDTO> pageParameter) {
        try {
            return orderItemDao.listOrderItemPage(pageParameter);
        } catch (Exception e) {
            log.error("业务查询分页列表查询失败",e);
            return null;
        }
    }
}
