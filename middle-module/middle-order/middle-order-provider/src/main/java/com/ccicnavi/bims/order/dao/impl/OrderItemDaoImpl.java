package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.OrderItemDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 16:28 2018/11/14
 */
@Service
public class OrderItemDaoImpl implements OrderItemDao {

    /**
     * @Author MengZiJie
     * @Description 新增服务项
     * @Date 15:50 2018/11/19
     * @Param [orderItemInfo, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderItem(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
    }

    /**
     * @Author MengZiJie
     * @Description 更改服务项信息
     * @Date 15:50 2018/11/19
     * @Param [orderItemInfo, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderItem(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
    }

    /**
     * @Author fandongsheng
     * @Description 根据委托单信息查询其下的服务项目信息
     * @Date 14:37 2018/11/21
     * @Param [orderInfoDO]
     * @Return java.util.List<com.ccicnavi.bims.order.pojo.OrderItemDTO>
     */
    @Override
    public List<OrderItemDTO> listOrderItemDTO(OrderInfoDO orderInfoDO) throws Exception {
        Eql eql = new Eql();
        return  eql.select("listOrderItem").params(orderInfoDO).returnType(OrderItemDTO.class).execute();
    }

    /**
     * @Author heibin
     * @Description 删除服务项信息
     * @Date 14:14 2018/11/22
     * @Param [orderItemDTO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderItem(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
        }
        return eql.update("deleteOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
    }
    /**
     * @Author heibin
     * @Description 业务查询分页列表
     * @Date 15:13 2018/11/28
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.order.pojo.OrderItemDTO>
     */
    @Override
    public PageBean<OrderItemDTO> listOrderItemPage(PageParameter<OrderItemDTO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<OrderItemDTO> orderItemDTOList = new Eql().select("listOrderItemPage").params(pageParameter.getParameter()).returnType(OrderItemDTO.class).limit(page).execute();
        if(orderItemDTOList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),orderItemDTOList);
        }else {
            return null;
        }
    }

    /**
     * @Author MengZiJie
     * @Description 更新服务项状态
     * @Data 2018/11/29 16:31
     * @Param [orderItemDTO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderItemStatus(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateOrderItemStatus").params(orderItemDTO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderItemStatus").params(orderItemDTO).returnType(Integer.class).execute();
    }
}
