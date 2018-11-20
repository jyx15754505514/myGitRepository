package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.order.api.OrderInfoService;
import com.ccicnavi.bims.order.dao.OrderInfoDao;
import com.ccicnavi.bims.order.dao.OrderItemDao;
import com.ccicnavi.bims.order.dao.OrderShipmentDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
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

    @Autowired
    private OrderShipmentDao orderShipmentDao;

    @Autowired
    private OrderItemDao orderItemDao;

    /* *
     * @Author MengZiJie
     * @Description 新增委托单
     * @Date 17:31 2018/11/19
     * @Param [orderInfoDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderInfo(OrderInfoDTO orderInfoDTO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderInfoDao.insertOrderInfo(orderInfoDTO,eqlTran);
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
    public Integer updateOrderInfo(OrderInfoDTO orderInfoDTO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderInfoDao.updateOrderInfo(orderInfoDTO,eqlTran);
        } catch (Exception e) {
            log.error("更新委托单信息",e);
        }
        return integer;
    }

    /* *
     * @Author MengZiJie
     * @Description 保存委托单
     * @Date 9:55 2018/11/20
     * @Param [orderInfoDTO]
     * @Return java.lang.Integer
     */
    @Override
    public ResultT saveOrderInfo(OrderInfoDTO orderInfoDTO) {
        EqlTran eqlTran = EqlUtils.getInstance("DEFAULT").newTran();
        try {
            eqlTran.start();
            if(orderInfoDTO.getOrderUuid() != null && !orderInfoDTO.getOrderUuid().equals("")){
                //更新委托单运输信息
                Integer shipment = orderShipmentDao.updateOrderShipment(orderInfoDTO, eqlTran);
                //更新委托单服务项*/
                Integer orderItem =  orderItemDao.updateOrderItem(orderInfoDTO,eqlTran);
                //更新委托单详情*/
                Integer orderInfo = orderInfoDao.updateOrderInfo(orderInfoDTO,eqlTran);
                if(shipment > 0 && orderItem > 0 && orderInfo > 0){
                    eqlTran.commit();
                    return ResultT.success();
                }
            }else{
                //添加委托单运输信息
                Integer shipment = orderShipmentDao.insertOrderShipment(orderInfoDTO,eqlTran);
                //添加委托单服务项
                Integer orderItem = orderItemDao.insertOrderItem(orderInfoDTO,eqlTran);
                //添加委托单详情
                Integer orderInfo = orderInfoDao.insertOrderInfo(orderInfoDTO,eqlTran);
                if(shipment > 0 && orderItem > 0 && orderInfo > 0){
                    eqlTran.commit();
                    return ResultT.failure(ResultCode.ADD_FAILURE);
                }
            }
        } catch (Exception e) {
            log.error("保存失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
        return null;
    }
}
