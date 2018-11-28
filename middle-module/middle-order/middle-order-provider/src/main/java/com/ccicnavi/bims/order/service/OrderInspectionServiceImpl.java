package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.order.api.OrderInspectionService;
import com.ccicnavi.bims.order.dao.OrderInspectionDao;
import com.ccicnavi.bims.order.pojo.OrderInspectionDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author heibin
 * @Description 委托单运输方式
 * @Date 17:52 2018/11/19
 */
@Slf4j
@Service
public class OrderInspectionServiceImpl implements OrderInspectionService {

    @Autowired
    private OrderInspectionDao orderInspectionDao;

    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;

    /**
     * @Author heibin
     * @Description 委托单运输方式添加
     * @Date 17:55 2018/11/19
     * @Param [orderShipmentDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderInspection(OrderInspectionDO orderInspectionDO) {
        Integer inspection = null;
        try {
            inspection = orderInspectionDao.insertOrderInspection(orderInspectionDO, null);
            if(inspection > 0){
                return  inspection;
            }
        } catch (Exception e) {
            log.error("添加委托单运输方式失败",e);
        }
        return -1;
    }

    /**
     * @Author heibin
     * @Description 更新委托单运输方式（参数：OrderInfoDTO）
     * @Date 18:04 2018/11/19
     * @Param [orderShipmentDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderInspection(OrderInspectionDO orderInspectionDO) {
        EqlTran eqlTran = null;
        Integer inspection = null;
        try {
            inspection = orderInspectionDao.updateOrderInspection(orderInspectionDO, eqlTran);
            if (inspection > 0) {
                return inspection;
            }
        } catch (Exception e) {
            log.error("更新委托单运输方式失败",e);
        }
        return -1;
    }
}
