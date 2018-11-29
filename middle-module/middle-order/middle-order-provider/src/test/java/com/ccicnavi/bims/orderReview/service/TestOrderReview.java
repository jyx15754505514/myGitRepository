package com.ccicnavi.bims.orderReview.service;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.impl.OrderInfoDaoImpl;
import com.ccicnavi.bims.order.dao.impl.OrderReviewDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 22:01
 * @Description: 评审管理接口测试
 */
@Slf4j
public class TestOrderReview {
    /* *
     * @Author MengZiJie
     * @Description 新增评审信息
     * @Date 9:41 2018/11/22
     */
    @Test
    public void insertOrderReview() {
        try {
            OrderReviewDaoImpl order = new OrderReviewDaoImpl();
            OrderReviewDO orderReviewDO = new OrderReviewDO();
            orderReviewDO.setOrderUuid("222");//设置主键
            orderReviewDO.setReviewSuggest("222");
            orderReviewDO.setReviewUserUuid("333");
            System.err.print(order.insertOrderReview(orderReviewDO,null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* *
     * @Author MengZiJie
     * @Description 通过评审
     * @Date 9:41 2018/11/22
     */
    @Test
    public void passOrderReview(){
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        OrderReviewDO orderReviewDO = new OrderReviewDO();
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        OrderReviewDaoImpl orderReviewDaoImpl = new OrderReviewDaoImpl();//委托评审
        OrderInfoDaoImpl orderInfoDaoImpl = new OrderInfoDaoImpl();//委托单
        try {
            eqlTran.start();
            orderReviewDO.setOrderUuid("testOrderUuid");//设置委托单id
            orderReviewDO.setIsPass("Y");//is_pass 为Y
            orderInfoDTO.setOrderUuid(orderReviewDO.getOrderUuid());
            orderInfoDTO.setStatusUuid("ORDER_PASS_Y");
            orderInfoDTO.setStatusName("通过评审");
            Integer review = orderReviewDaoImpl.updateOrderReview(orderReviewDO,eqlTran);
            Integer orderInfo = orderInfoDaoImpl.updateOrderInfo(orderInfoDTO,eqlTran);
            if(review > 0 && orderInfo >0){
                eqlTran.commit();
                System.out.println("评审："+review+" 委托单："+orderInfo+" 通过评审");
            }
        } catch (Exception e) {
            log.error("评审未通过",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
    }

    /* *
     * @Author MengZiJie
     * @Description 驳回
     * @Date 9:46 2018/11/22
     */
    @Test
    public void backOrderReview(){
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        OrderReviewDO orderReviewDO = new OrderReviewDO();
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        OrderReviewDaoImpl orderReviewDaoImpl = new OrderReviewDaoImpl();//委托评审
        OrderInfoDaoImpl orderInfoDaoImpl = new OrderInfoDaoImpl();//委托单
        try {
            eqlTran.start();
            orderReviewDO.setOrderUuid("testOrderUuid");//设置委托单id
            orderReviewDO.setIsPass("N");//is_pass 为Y
            orderInfoDTO.setOrderUuid(orderReviewDO.getOrderUuid());
            orderInfoDTO.setStatusUuid("ORDER_PASS_N");
            orderInfoDTO.setStatusName("驳回");
            Integer review = orderReviewDaoImpl.updateOrderReview(orderReviewDO,eqlTran);
            Integer orderInfo = orderInfoDaoImpl.updateOrderInfo(orderInfoDTO,eqlTran);
            if(review > 0 && orderInfo >0){
                eqlTran.commit();
                System.out.println("评审："+review+" 委托单："+orderInfo+" 驳回成功！");
            }
        } catch (Exception e) {
            log.error("评审未通过",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
    }
    /**
     * @Author songyateng
     * @Description 评审列表（分页）
     * @Date 2018/11/29 17:26
     */
    @Test
    public void listOrderReview(){
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        try {
            OrderReviewDaoImpl orderReviewDaoImpl = new OrderReviewDaoImpl();//委托评审
            PageParameter<OrderReviewDO> pageParameter = new PageParameter();
            OrderReviewDO orderReviewDO = new OrderReviewDO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(2);
            pageParameter.setStartPage(1);
            orderReviewDO.setReviewUserUuid("pingshen");
            pageParameter.setParameter(orderReviewDO);
            PageBean<OrderReviewDO> certPaperDOPageBean = orderReviewDaoImpl.listOrderReviewPage(pageParameter);
            System.out.println(certPaperDOPageBean);
        } catch (Exception e) {
            log.error("评审列表分页失败",e);
        }
    }





}




