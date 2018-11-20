package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.order.api.OrderInfoService;
import com.ccicnavi.bims.order.dao.OrderInfoDao;
import com.ccicnavi.bims.order.dao.OrderItemDao;
import com.ccicnavi.bims.order.dao.OrderItemSubDao;
import com.ccicnavi.bims.order.dao.OrderShipmentDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import com.ccicnavi.bims.order.pojo.OrderItemSubDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

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

    @Autowired
    OrderItemSubDao orderItemSubDao;

    @Autowired
    IdWorkerService idWorkerService;

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
        Integer shipment = null;
        Integer orderItem = null;
        Integer orderItemSub = null;
        Integer orderInfo = null;
        try {
            eqlTran.start();
            if(orderInfoDTO.getOrderUuid() != null && !orderInfoDTO.getOrderUuid().equals("")){
                //更新委托单运输信息
                shipment = orderShipmentDao.updateOrderShipment(orderInfoDTO, eqlTran);
                List<OrderItemDTO> orderItemDTO = orderInfoDTO.getOrderItemDTO();
                if(orderItemDTO.size() > 0){
                    for (int i = 0; i < orderItemDTO.size(); i++) {
                        //更新服务项信息
                        orderItem +=orderItemDao.updateOrderItem(orderItemDTO.get(i),eqlTran);
                        if(orderItemDTO.get(i).getOrderItemSubDO() != null){
                            List<OrderItemSubDO> orderItemSubDO = orderItemDTO.get(i).getOrderItemSubDO();
                            for (int j = 0; j < orderItemSubDO.size(); j++) {
                                //更新服务子项信息
                                orderItemSub += orderItemSubDao.insertOrderItemSub(orderItemSubDO.get(j),eqlTran);
                            }
                        }
                    }
                }
                //更新委托单详情*/
                orderInfo = orderInfoDao.updateOrderInfo(orderInfoDTO,eqlTran);
                if(shipment > 0 && orderItem > 0 && orderInfo > 0){
                    eqlTran.commit();
                    return ResultT.success();
                }
            }
            //生成委托单id
            String orderUuid = idWorkerService.getId(new Date());
            orderInfoDTO.setOrderUuid(orderUuid);
            //生成委托单号

            //添加委托单运输信息
            String shippingTypeId = idWorkerService.getId(new Date());
            orderInfoDTO.setShippingTypeId(shippingTypeId);
            shipment = orderShipmentDao.insertOrderShipment(orderInfoDTO,eqlTran);
            List<OrderItemDTO> orderItemDTO = orderInfoDTO.getOrderItemDTO();
            if(orderItemDTO.size() > 0){
                for (int i = 0; i < orderItemDTO.size(); i++) {
                    //添加委托单服务项
                    //生成服务项主键
                    String orderItemUuid = idWorkerService.getId(new Date());
                    orderItemDTO.get(i).setOrderItemUuid(orderItemUuid);
                    //生成服务单编号

                    orderItem += orderItemDao.insertOrderItem(orderItemDTO.get(i),eqlTran);
                    if(orderItemDTO.get(i).getOrderItemSubDO() != null){
                        List<OrderItemSubDO> orderItemSubDO = orderItemDTO.get(i).getOrderItemSubDO();
                        for (int j = 0; j < orderItemSubDO.size(); j++) {
                            //生成子项主键id
                            String orderItemSubUuid = idWorkerService.getId(new Date());
                            orderItemSubDO.get(j).setSubItemUuid(orderItemSubUuid);
                            //生成子项编号

                            //添加子项信息
                            orderItemSub += orderItemSubDao.insertOrderItemSub(orderItemSubDO.get(j),eqlTran);
                        }
                    }
                }
            }
            //添加委托单详情
            orderInfo = orderInfoDao.insertOrderInfo(orderInfoDTO,eqlTran);
            if(shipment > 0 && orderItem > 0 && orderInfo > 0){
                eqlTran.commit();
                return ResultT.success();
             }
        } catch (Exception e) {
            log.error("保存失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }
}
