package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 14:34
 * @Description:
 */
public interface OrderReviewService {

    public PageBean<OrderReviewDO> testPage(PageParameter<OrderReviewDO> pageParameter);
}
