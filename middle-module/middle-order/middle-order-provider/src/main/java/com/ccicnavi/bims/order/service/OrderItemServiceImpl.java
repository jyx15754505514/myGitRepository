package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.order.api.OrderInfoService;
import com.ccicnavi.bims.order.api.OrderItemService;
import com.ccicnavi.bims.order.dao.OrderInfoDao;
import com.ccicnavi.bims.order.dao.OrderItemDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderItemDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

/* *
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 17:30 2018/11/19
 */
@Slf4j
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;

    /* *
     * @Author MengZiJie
     * @Description 添加服务项
     * @Date 17:30 2018/11/19
     * @Param [orderItemDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderItem(OrderItemDO orderItemDO) {
        EqlTran aDefault = null;
        Integer integer = null;
        try {
            integer = orderItemDao.insertOrderItem(orderItemDO, aDefault);
        } catch (Exception e) {
            log.error("添加服务项失败",e);
        }
        return integer;
    }

    /* *
     * @Author MengZiJie
     * @Description 更新服务项
     * @Date 17:31 2018/11/19
     * @Param [orderItemDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderItem(OrderItemDO orderItemDO) {
        EqlTran aDefault = null;
        Integer integer = null;
        try {
            integer = orderItemDao.updateOrderItem(orderItemDO, aDefault);
        } catch (Exception e) {
            log.error("更新服务项失败",e);
        }
        return integer;
    }
}
