package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
import org.n3r.eql.EqlTran;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 10:36
 * @Description:
 */
public interface OrderReviewDao {

    /**
     * @Author fandongsheng
     * @Description 新增委托单评审信息
     * @Date 2018/11/20 10:36
     * @Param [orderReviewDO, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderReview(OrderReviewDO orderReviewDO, EqlTran tran) throws Exception;
    /**
     * @Author fandongsheng
     * @Description 更新委托单评审信息
     * @Date 2018/11/20 10:36
     * @Param [orderReviewDO, tran]
     * @Return java.lang.Integer
     */
    Integer updateOrderReview(OrderReviewDO orderReviewDO, EqlTran tran) throws Exception;
    /**
     * @Author songyateng
     * @Description 评审列表（分页）
     * @Date 2018/11/29 17:17
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.order.pojo.OrderReviewDO>
     */
    PageBean<OrderReviewDO> listOrderReviewPage(PageParameter<OrderReviewDO> pageParameter);




}
