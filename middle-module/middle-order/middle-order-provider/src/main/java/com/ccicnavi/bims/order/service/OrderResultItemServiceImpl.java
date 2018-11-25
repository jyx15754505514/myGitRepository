package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.order.api.OrderResultItemService;
import com.ccicnavi.bims.order.dao.OrderResultItemDao;
import com.ccicnavi.bims.order.pojo.OrderResultItemDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
/**
 * @Author heibin
 * @Description 委托服务项-证书关系
 * @Date 20:22 2018/11/20
 */
@Slf4j
@Service
public class OrderResultItemServiceImpl implements OrderResultItemService {

    @Autowired
    private OrderResultItemDao orderResultItemDao;

    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;

    /**
     * @Author heibin
     * @Description 根据主键id查询委托服务项-证书关系
     * @Date 20:23 2018/11/20
     * @Param [orderResultItemDO]
     * @Return OrderResultItemDO
     */
    @Override
    public OrderResultItemDO getOrderResultItem(OrderResultItemDO orderResultItemDO) {
        try {
            return orderResultItemDao.getOrderResultItem(orderResultItemDO);
        } catch (Exception e) {
            log.error("根据主键id查询委托服务项-证书关系失败~",e);
            return null;
        }
    }

    /**
     * @Author heibin
     * @Description 查询全部委托服务项-证书关系
     * @Date 20:25 2018/11/20
     * @Param [orderResultItemDO]
     * @Return List<OrderResultItemDO>
     */
    @Override
    public List<OrderResultItemDO> listOrderResultItem(OrderResultItemDO orderResultItemDO) {
        try {
            return orderResultItemDao.listOrderResultItem(orderResultItemDO);
        } catch (Exception e) {
            log.error("查询全部委托服务项-证书关系失败~",e);
            return null;
        }
    }

    /**
     * @Author heibin
     * @Description 委托服务项-证书关系添加
     * @Date 20:28 2018/11/20
     * @Param [orderResultItemDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderResultItem(OrderResultItemDO orderResultItemDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            /**生成uuid*/
            String resultItemUuid = idWorkerService.getId(new Date());
            orderResultItemDO.setResultItemUuid(resultItemUuid);
            integer = orderResultItemDao.insertOrderResultItem(orderResultItemDO, eqlTran);
        } catch (Exception e) {
            log.error("添加委托服务项-证书关系失败",e);
        }
        return integer;
    }

    /**
     * @Author heibin
     * @Description 委托服务项-证书关系更新
     * @Date 20:30 2018/11/20
     * @Param [orderResultItemDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderResultItem(OrderResultItemDO orderResultItemDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderResultItemDao.updateOrderResultItem(orderResultItemDO, eqlTran);
        } catch (Exception e) {
            log.error("更新委托服务项-证书关系失败",e);
        }
        return integer;
    }

    /**
     * @Author heibin
     * @Description 委托服务项-证书关系删除
     * @Date 20:32 2018/11/20
     * @Param [orderResultItemDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderResultItem(OrderResultItemDO orderResultItemDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderResultItemDao.deleteOrderResultItem(orderResultItemDO, eqlTran);
        } catch (Exception e) {
            log.error("删除委托服务项-证书关系失败",e);
        }
        return integer;
    }
}
