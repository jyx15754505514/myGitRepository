package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.order.api.OrderResultInfoService;
import com.ccicnavi.bims.order.dao.OrderResultInfoDao;
import com.ccicnavi.bims.order.pojo.OrderResultInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Author heibin
 * @Description 证书结果
 * @Date 14:51 2018/11/20
 */
@Slf4j
@Service
public class OrderResultInfoServiceImpl implements OrderResultInfoService {

    @Autowired
    private OrderResultInfoDao orderResultInfoDao;

    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;

    /**
     * @Author heibin
     * @Description 根据主键id查询证书结果
     * @Date 17:41 2018/11/20
     * @Param [orderResultInfoDO]
     * @Return OrderResultInfoDO
     */
    @Override
    public OrderResultInfoDO getOrderResultInfo(OrderResultInfoDO orderResultInfoDO) {
        try {
            return orderResultInfoDao.getOrderResultInfo(orderResultInfoDO);
        } catch (Exception e) {
            log.error("根据主键id查询证书结果失败~",e);
            return null;
        }
    }

    /**
     * @Author heibin
     * @Description 查询全部证书结果
     * @Date 14:52 2018/11/20
     * @Param [orderResultInfoDO]
     * @Return List<OrderResultInfoDO>
     */
    @Override
    public List<OrderResultInfoDO> listOrderResultInfo(OrderResultInfoDO orderResultInfoDO) {
        try {
            return orderResultInfoDao.listOrderResultInfo(orderResultInfoDO);
        } catch (Exception e) {
            log.error("查询所有证书结果失败~",e);
            return null;
        }
    }

    /**
     * @Author heibin
     * @Description 证书结果添加
     * @Date 14:52 2018/11/20
     * @Param [orderResultInfoDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderResultInfo(OrderResultInfoDO orderResultInfoDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            /**生成uuid*/
            String resultUuid = idWorkerService.getId(new Date());
            orderResultInfoDO.setResultUuid(resultUuid);
            integer = orderResultInfoDao.insertOrderResultInfo(orderResultInfoDO, eqlTran);
        } catch (Exception e) {
            log.error("添加证书结果失败",e);
        }
        return integer;
    }
    /**
     * @Author heibin
     * @Description 证书结果更新
     * @Date 14:52 2018/11/20
     * @Param [orderResultInfoDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderResultInfo(OrderResultInfoDO orderResultInfoDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderResultInfoDao.updateOrderResultInfo(orderResultInfoDO, eqlTran);
        } catch (Exception e) {
            log.error("更新证书结果失败",e);
        }
        return integer;
    }
    /**
     * @Author heibin
     * @Description 证书结果删除
     * @Date 16:53 2018/11/20
     * @Param [orderResultInfoDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderResultInfo(OrderResultInfoDO orderResultInfoDO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderResultInfoDao.deleteOrderResultInfo(orderResultInfoDO, eqlTran);
        } catch (Exception e) {
            log.error("删除证书结果失败",e);
        }
        return integer;
    }
}
