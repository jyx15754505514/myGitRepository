package com.ccicnavi.bims.order.dao.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.OrderReviewDao;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 10:38
 * @Description:
 */
@Service
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
        Eql eql = new Eql();
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
        Eql eql = new Eql();
        if (tran !=null){
            return eql.useTran(tran).update("updateOrderReview").params(orderReviewDO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderReview").params(orderReviewDO).returnType(Integer.class).execute();
    }
    /**
     * @Author songyateng
     * @Description 评审列表（分页）
     * @Date 2018/11/29 17:34
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.order.pojo.OrderReviewDO>
     */
    @Override
    public PageBean<OrderReviewDO> listOrderReviewPage(PageParameter<OrderReviewDO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartPage(), pageParameter.getPageRows());
        //执行查询
        List<OrderReviewDO>  OrderReviewDOList= new Eql().select("listOrderReviewPage").params(pageParameter.getParameter()).returnType(OrderReviewDO.class).limit(page).execute();
        if(OrderReviewDOList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),OrderReviewDOList);
        }else {
            return null;
        }
    }
}
