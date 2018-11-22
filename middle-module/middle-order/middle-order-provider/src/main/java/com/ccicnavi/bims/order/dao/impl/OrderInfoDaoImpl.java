package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.OrderInfoDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author MengZiJie
 * @Description 委托单
 * @Date 16:28 2018/11/14
 */
@Service
public class OrderInfoDaoImpl implements OrderInfoDao {

    /**
     * @Author MengZiJie
     * @Description 新增委托单
     * @Date 15:35 2018/11/19
     * @Param [orderInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderInfo(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderInfo").params(orderInfoDTO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderInfo").params(orderInfoDTO).returnType(Integer.class).execute();
    }

    /**
     * @Author MengZiJie
     * @Description 更新委托单信息
     * @Date 15:37 2018/11/19
     * @Param [orderInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderInfo(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("updateOrderInfo").params(orderInfoDTO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderInfo").params(orderInfoDTO).returnType(Integer.class).execute();
    }

    /**
     * 功能描述: 根据委托单主键查询委托单信息
     * @param: orderInfoDTO
     * @return: OrderInfoDO
     * @auther: fandongsheng
     * @date: 2018/11/21 14:18
     */
    @Override
    public OrderInfoDTO getOrderInfo(OrderInfoDO orderInfoDO) throws Exception {
        Eql eql = new Eql("DEFAULT");
        return eql.selectFirst("getOrderInfo").params(orderInfoDO).returnType(OrderInfoDTO.class).execute();
    }

    /**
     * @Author fandongsheng
     * @Description 更新委托单信息
     * @Date 12018/11/20 20:27
     * @Param [orderInfoDao]
     * @Return PageBean<OrderInfoDO>
     */
    @Override
    public PageBean<OrderInfoDO> listOrderInfoPage(PageParameter<OrderInfoDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<OrderInfoDO> orderInfoList = new Eql().select("listOrderInfo").params(pageParameter.getParameter()).returnType(OrderInfoDO.class).limit(page).execute();
        if(orderInfoList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),orderInfoList);
        }else {
            return null;
        }
    }
}
