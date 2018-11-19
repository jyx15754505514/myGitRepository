package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.order.api.OrderInfoService;
import com.ccicnavi.bims.order.dao.OrderInfoDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

/* *
 * @Author MengZiJie
 * @Description 委托单
 * @Date 17:06 2018/11/19
 */
@Slf4j
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;

    /* *
     * @Author MengZiJie
     * @Description 新增委托单
     * @Date 17:31 2018/11/19
     * @Param [orderInfoDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderInfo(OrderInfoDO orderInfoDO) {
        EqlTran aDefault = null;
        Integer integer = null;
        try {
            integer = orderInfoDao.insertOrderInfo(orderInfoDO,aDefault);
        } catch (Exception e) {
            log.error("新增委托单失败",e);
        }
        return integer;
    }

    /* *
     * @Author MengZiJie
     * @Description 更新委托单
     * @Date 17:31 2018/11/19
     * @Param [orderInfoDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderInfo(OrderInfoDO orderInfoDO) {
        EqlTran aDefault = null;
        Integer integer = null;
        try {
            integer = orderInfoDao.updateOrderInfo(orderInfoDO,aDefault);
        } catch (Exception e) {
            log.error("更新委托单信息",e);
        }
        return integer;
    }
}
