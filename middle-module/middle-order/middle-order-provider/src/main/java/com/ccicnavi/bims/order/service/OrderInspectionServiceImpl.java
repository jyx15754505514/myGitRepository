package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.order.api.OrderInspectionService;
import com.ccicnavi.bims.order.dao.OrderInspectionDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

/* *
 * @Author heibin
 * @Description 委托单运输方式
 * @Date 17:52 2018/11/19
 */
@Slf4j
@Service
public class OrderInspectionServiceImpl implements OrderInspectionService {
    @Autowired
    private OrderInspectionDao orderInspectionDao;
    /* *
     * @Author heibin
     * @Description 委托单运输方式添加
     * @Date 17:55 2018/11/19
     * @Param [orderShipmentDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderInspection(OrderInfoDTO orderInfoDTO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderInspectionDao.insertOrderInspection(orderInfoDTO, eqlTran);
        } catch (Exception e) {
            log.error("添加委托单运输方式失败",e);
        }
        return integer;
    }

    /* *
     * @Author heibin
     * @Description 更新委托单运输方式
     * @Date 18:04 2018/11/19
     * @Param [orderShipmentDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderInspection(OrderInfoDTO orderInfoDTO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderInspectionDao.updateOrderInspection(orderInfoDTO, eqlTran);
        } catch (Exception e) {
            log.error("更新委托单运输方式失败",e);
        }
        return integer;
    }
}
