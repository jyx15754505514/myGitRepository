package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 14:34
 * @Description:
 */
public interface OrderReviewService {

    PageBean<OrderReviewDO> testPage(PageParameter<OrderReviewDO> pageParameter);

    /* *
     * @Author MengZiJie
     * @Description 新增评审
     * @Date 22:06 2018/11/21
     * @Param [orderReviewDO]
     * @Return java.lang.Integer
     */
    Integer insertOrderReview(OrderReviewDO orderReviewDO);

    /* *
     * @Author MengZiJie
     * @Description 通过评审
     * @Date 22:06 2018/11/21
     * @Param [orderReviewDO, orderInfoDTO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    ResultT passOrderReview(OrderReviewDO orderReviewDO, OrderInfoDTO orderInfoDTO);
}
