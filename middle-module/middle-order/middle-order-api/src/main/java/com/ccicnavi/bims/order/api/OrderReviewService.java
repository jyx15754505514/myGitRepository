package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
import org.n3r.eql.EqlTran;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 14:34
 * @Description:
 */
public interface OrderReviewService {

    public PageBean<OrderReviewDO> testPage(PageParameter<OrderReviewDO> pageParameter);

    /**新增评审*/
    Integer insertOrderReview(OrderReviewDO orderReviewDO);

    /**通过评审*/
    ResultT passOrderReview(OrderReviewDO orderReviewDO);
}
