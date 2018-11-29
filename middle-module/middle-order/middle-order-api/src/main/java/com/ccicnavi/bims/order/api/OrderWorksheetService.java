package com.ccicnavi.bims.order.api;


import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderWorksheetDTO;

/*
* 工作单
* @Author zhaotao
* @Date  2018/11/29 15:13
* @Param 
* @return 
**/
public interface OrderWorksheetService {

    /**
    *@Description: 查询工作单
    *@Param: [pageParameter]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangxingbiao
    *@date: 2018/11/29
    */
    ResultT listOrderWorksheet(PageParameter<OrderWorksheetDTO> pageParameter)throws Exception;
    /**
    *@Description: 新增工作单
    *@Param: [orderWorksheetDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/29
    */
    Integer insertOrderWorksheet(OrderWorksheetDTO orderWorksheetDTO) throws Exception;
    /**
    *@Description: 删除工作单
    *@Param: [orderWorksheetDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/29
    */
    Integer deleteOrderWorksheet(OrderWorksheetDTO orderWorksheetDTO) throws Exception;
    /**
    *@Description: 更新工作单
    *@Param: [orderWorksheetDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/29
    */
    Integer updateOrderWorksheet(OrderWorksheetDTO orderWorksheetDTO) throws Exception;



    //  ====================================================派单分包========================================================



















































































































































































































































































 //  ====================================================服务实施代码========================================================







    
}
