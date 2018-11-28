package com.ccicnavi.bims.orderItem.service;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.impl.OrderItemCostDaoImpl;
import com.ccicnavi.bims.order.dao.impl.OrderItemDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderItemCostDO;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author MengZiJie
 * @Description 服务项测试
 * @Date 17:32 2018/11/22
 */
@Slf4j
public class TestOrderItem {

    /**
     * @Author MengZiJie
     * @Description 分配任务
     * @Date 17:50 2018/11/22
     * @Param []
     * @Return void
     */
    @Test
    public void assignOrderItem(){
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        try {
            eqlTran.start();
            orderItemDTO.setOrderItemUuid("orderItemUuidTest");
            orderItemDTO.setReceOrgUuid("BeiJing");
            orderItemDTO.setReceOrgName("中检物业");
            orderItemDTO.setReceUserUuid("admin");
            Integer orderItem = orderItemDaoImpl.updateOrderItem(orderItemDTO, eqlTran);
            if (orderItem > 0) {
                eqlTran.commit();
            }
            System.out.println("分配成功"+orderItem);
        } catch (Exception e) {
            log.error(" 分配失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
    }

    /**
     * @Author MengZiJie
     * @Description 外包任务
     * @Date 17:50 2018/11/22
     * @Param []
     * @Return void
     */
    @Test
    public void outsourcOrderItem(){
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
        OrderItemCostDaoImpl orderItemCostDaoImpl = new OrderItemCostDaoImpl();
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        OrderItemCostDO orderItemCostDO = new OrderItemCostDO();
        OrderItemCostDO orderItemCostDOSecond = new OrderItemCostDO();
        List<OrderItemCostDO> arr = new ArrayList<>();
        Integer itemCost = null;
        try {
            eqlTran.start();
            orderItemDTO.setOrderItemUuid("orderItemUuidTest");
            orderItemDTO.setReceOrgUuid("BeiJing");
            orderItemDTO.setReceOrgName("中检物业");
            orderItemDTO.setReceUserUuid("admin");
            orderItemDTO.setIsSubpkg("Y");
            orderItemDTO.setIsSubpkgMgr("Y");
            Integer orderItem = orderItemDaoImpl.updateOrderItem(orderItemDTO, eqlTran);
            System.out.println("item！"+orderItem);
            orderItemCostDO.setItemCostUuid("costUuid");
            orderItemCostDO.setCostFee(12000);
            orderItemCostDOSecond.setItemCostUuid("costUuidSecond");
            orderItemCostDOSecond.setCostFee(12000);
            arr.add(orderItemCostDO);
            arr.add(orderItemCostDOSecond);
            orderItemDTO.setOrderItemCostDO(arr);
            if (orderItemDTO.getOrderItemCostDO().size() > 0) {
                List<OrderItemCostDO> orderItemCostDOThree = orderItemDTO.getOrderItemCostDO();
                for (int i = 0;i < orderItemCostDOThree.size();i++) {
                    itemCost = orderItemCostDaoImpl.updateOrderItemCost(orderItemCostDOThree.get(i), eqlTran);
                }
            }
            System.out.println("cost!"+itemCost);
        } catch (Exception e) {
            log.error("外包失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
    }

    /**
     * @Author songyateng
     * @Description 测试删除服务项
     * @Date 2018/11/28 10:50
     */
    @Test
    public void deleteOrderItem(){
        try {
            OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setOrderItemUuid("1811271707532");
            System.err.println(orderItemDaoImpl.deleteOrderItem(orderItemDTO,null));
        } catch (Exception e){
            log.error("测试删除服务项失败" ,e);
        }
    }
    /**
     * 业务查询分页列表
     **/
    @Test
    public void listOrderItemPage(){
        OrderItemDaoImpl orderItemDaoImpl =new OrderItemDaoImpl();
        try {
            PageParameter<OrderItemDTO> pageParameter = new PageParameter();
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(2);
            pageParameter.setStartPage(1);
            orderItemDTO.setAppSysUuid("yewu2.0");
            orderItemDTO.setProdCatalogUuid("yewu2.0");
            orderItemDTO.setOrgUuid("yewu2.0");
            pageParameter.setParameter(orderItemDTO);
            PageBean<OrderItemDTO> certPaperDOPageBean = orderItemDaoImpl.listOrderItemPage(pageParameter);
            System.out.println(certPaperDOPageBean);
        } catch (Exception e) {
            log.error("业务查询分页列表失败",e);
        }
    }

}
