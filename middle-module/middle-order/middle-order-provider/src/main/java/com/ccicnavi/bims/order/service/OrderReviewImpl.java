package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.api.OrderReviewService;
import com.ccicnavi.bims.order.dao.OrderInfoDao;
import com.ccicnavi.bims.order.dao.OrderReviewDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 15:04
 * @Description: 评审管理
 */
@Slf4j
@Service
public class OrderReviewImpl implements OrderReviewService {

    @Autowired
    OrderReviewDao orderReviewDao;

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Override
    public PageBean<OrderReviewDO> testPage(PageParameter<OrderReviewDO> pageParameter) {
        return null;
    }

    /**
     * 功能描述: 新增评审信息
     * @param: orderReviewDO
     * @return: java.long.Integer
     * @auther: fandongsheng
     * @date: 2018/11/20 15:04
     */
    @Override
    public Integer insertOrderReview(OrderReviewDO orderReviewDO) {
        try {
            return orderReviewDao.insertOrderReview(orderReviewDO,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* *
     * @Author MengZiJie
     * @Description 通过评审
     * @Date 20:57 2018/11/21
     * @Param [orderReviewDO]
     * @Return java.lang.Integer
     */
    @Override
    public ResultT passOrderReview(OrderReviewDO orderReviewDO) {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        try {
            eqlTran.start();
            orderInfoDTO.setOrderUuid(orderReviewDO.getOrderUuid());
            Integer orderInfo = orderInfoDao.updateOrderInfo(orderInfoDTO,eqlTran);
            Integer orderReview = orderReviewDao.updateOrderReview(orderReviewDO,eqlTran);
            if(orderReview > 0 && orderInfo >0){
                eqlTran.commit();
                return ResultT.success(ResultCode.SUCCESS);
            }
        } catch (Exception e) {
            log.error("评审失败！",e);
            eqlTran.rollback();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        } finally {
            eqlTran.close();
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

}
