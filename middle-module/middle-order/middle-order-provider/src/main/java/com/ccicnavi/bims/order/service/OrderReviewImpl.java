package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.api.OrderReviewService;
import com.ccicnavi.bims.order.dao.OrderReviewDao;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 15:04
 * @Description:
 */
@Slf4j
@Service
public class OrderReviewImpl implements OrderReviewService {
    @Autowired
    OrderReviewDao orderReviewDao;

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
    public Integer insertOrderReview(OrderReviewDO orderReviewDO , EqlTran tran) {
        try {
            return orderReviewDao.insertOrderReview(orderReviewDO,tran);
        } catch (Exception e) {
            log.error("添加评审信息失败",e);
            return null;
        }
    }
}
