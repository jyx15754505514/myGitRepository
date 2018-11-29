package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 14:34
 * @Description: 委托单评审管理
 */
public interface OrderReviewService {

    PageBean<OrderReviewDO> testPage(PageParameter<OrderReviewDO> pageParameter);

    /**
     * @Author MengZiJie
     * @Description 新增评审
     * @Date 22:06 2018/11/21
     * @Param [orderReviewDO]
     * @Return java.lang.Integer
     */
    Integer insertOrderReview(OrderReviewDO orderReviewDO);

    /**
     * @Author MengZiJie
     * @Description 通过
     * @Date 22:06 2018/11/21
     * @Param [orderReviewDO, orderInfoDTO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    ResultT passOrderReview(OrderReviewDO orderReviewDO, OrderInfoDTO orderInfoDTO);

    /**
     * @Author MengZiJie
     * @Description 驳回
     * @Date 22:10 2018/11/21
     * @Param [orderReviewDO, orderInfoDTO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    ResultT backOrderReview(OrderReviewDO orderReviewDO, OrderInfoDTO orderInfoDTO);

    /**
     * @Author songyateng
     * @Description 评审列表（分页）
     * @Date 2018/11/29 17:13
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.order.pojo.OrderReviewDO>
     */
    PageBean<OrderReviewDO> listOrderReview(PageParameter<OrderReviewDO> pageParameter);
}
