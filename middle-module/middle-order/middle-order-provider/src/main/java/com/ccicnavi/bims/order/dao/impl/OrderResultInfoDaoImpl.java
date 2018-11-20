package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderResultInfoDao;
import com.ccicnavi.bims.order.pojo.OrderResultInfoDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
/* *
 * @Author heibin
 * @Description 证书结果
 * @Date 15:02 2018/11/20
 */
@Service
public class OrderResultInfoDaoImpl implements OrderResultInfoDao {
    /* *
     * @Author heibin
     * @Description 新增证书结果
     * @Date 15:06 2018/11/20
     * @Param [orderResultInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("insertOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
        }
        return eql.update("insertOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
    }
    /* *
     * @Author heibin
     * @Description 更新证书结果
     * @Date 15:06 2018/11/20
     * @Param [orderResultInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("updateOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
    }
    /* *
     * @Author heibin
     * @Description 删除证书结果
     * @Date 15:55 2018/11/20
     * @Param [orderResultInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
        }
        return eql.update("deleteOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
    }
}
