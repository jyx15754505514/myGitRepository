package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.order.api.OrderItemSubService;
import com.ccicnavi.bims.order.dao.OrderItemSubDao;
import com.ccicnavi.bims.order.pojo.OrderItemSubDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

/**
 * @Author heibin
 * @Description 委托单最小服务项子项（最小颗粒度）
 * @Date 9:44 2018/11/20
 */
@Slf4j
@Service
public class OrderItemSubServiceImpl implements OrderItemSubService {

    @Autowired
    private OrderItemSubDao orderItemSubDao;

    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;

    /**
     * @Author heibin
     * @Description 委托单最小服务项子项（最小颗粒度）添加
     * @Date 9:46 2018/11/20
     * @Param [orderItemSubDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderItemSub(OrderItemSubDO orderItemSubDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            /**生成uuid*/
            String subItemUuid = idWorkerService.getId(new Date());
            orderItemSubDO.setSubItemUuid(subItemUuid);
            integer = orderItemSubDao.insertOrderItemSub(orderItemSubDO, eqlTran);
        } catch (Exception e) {
            log.error("添加委托单最小服务项子项失败",e);
        }
        return integer;
    }
    /**
     * @Author heibin
     * @Description 委托单最小服务项子项（最小颗粒度）更新
     * @Date 9:46 2018/11/20
     * @Param [orderItemSubDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderItemSub(OrderItemSubDO orderItemSubDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderItemSubDao.updateOrderItemSub(orderItemSubDO, eqlTran);
        } catch (Exception e) {
            log.error("更新委托单最小服务项子项失败",e);
        }
        return integer;
    }
    /**
     * @Author heibin
     * @Description 委托单最小服务项子项（最小颗粒度）物理删除
     * @Date 11:19 2018/11/20
     * @Param [orderItemSubDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderItemSub(OrderItemSubDO orderItemSubDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderItemSubDao.deleteOrderItemSub(orderItemSubDO, eqlTran);
        } catch (Exception e) {
            log.error("删除委托单最小服务项子项失败",e);
        }
        return integer;
    }
}
