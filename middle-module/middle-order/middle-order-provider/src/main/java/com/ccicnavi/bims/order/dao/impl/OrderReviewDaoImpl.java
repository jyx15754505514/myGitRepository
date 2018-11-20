package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderReviewDao;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 10:38
 * @Description:
 */
public class OrderReviewDaoImpl implements OrderReviewDao {
    /**
     * 功能描述: 添加评审信息
     * @param: orderReviewDO,tran
     * @return: java.lang.Integer
     * @auther: fandongsheng
     * @date: 2018/11/20 10:38
     */
    @Override
    public Integer insertOrderReview(OrderReviewDO orderReviewDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if (tran !=null){
            return eql.useTran(tran).insert("insertOrderReview").params(orderReviewDO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderReview").params(orderReviewDO).returnType(Integer.class).execute();
    }
    /**
     * 功能描述: 更新评审信息
     * @param: orderReviewDO,tran
     * @return: java.lang.Integer
     * @auther: fandongsheng
     * @date: 2018/11/20 10:39
     */
    @Override
    public Integer updateOrderReview(OrderReviewDO orderReviewDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if (tran !=null){
            return eql.useTran(tran).update("updateOrderReview").params(orderReviewDO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderReview").params(orderReviewDO).returnType(Integer.class).execute();
    }
}
