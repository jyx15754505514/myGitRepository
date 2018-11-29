package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderWorksheetDTO;
import org.n3r.eql.EqlTran;
/**
 * @Author songyateng
 * @Description 工作单
 * @Date 15:49 2018/11/21
 */

public interface OrderWorksheetDao {
    /**
     * @Author songyateng
     * @Description 添加工作单信息
     * @Date 15:49 2018/11/21
     * @Param
     * @Return
     */
    Integer insertOrderWorksheet(OrderWorksheetDTO orderWorksheetDTO, EqlTran tran) throws Exception;

    /**
     * @Author songyateng
     * @Description 删除工作单
     * @Date 20:06 2018/11/21
     * @Param [orderWorksheetDTO, tran]
     * @Return java.lang.Integer
     */
    Integer deleteOrderWorksheet(OrderWorksheetDTO orderWorksheetDTO,EqlTran tran) throws Exception;

    /**
     * @Author songyateng
     * @Description 修改工作单
     * @Date 16:16 2018/11/21
     * @Param
     * @Return
     */
    Integer updateOrderWorksheet(OrderWorksheetDTO orderReviewDTO, EqlTran tran) throws Exception;
    /**
     * @Author zhangxingbiao
     * @Description 查询工作单
     * @Date 16:16 2018/11/21
     * @Param
     * @Return
     */
    public PageBean<OrderWorksheetDTO> listOrderWorksheet(PageParameter<OrderWorksheetDTO> pageParameter) throws Exception;

}
