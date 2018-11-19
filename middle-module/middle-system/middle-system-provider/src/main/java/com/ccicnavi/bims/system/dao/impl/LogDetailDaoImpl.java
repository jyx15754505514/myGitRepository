package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.LogDetailDao;
import com.ccicnavi.bims.system.pojo.LogDO;
import com.ccicnavi.bims.system.pojo.LogDTO;
import com.ccicnavi.bims.system.pojo.LogDetailDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
/* *
 * @Author MengZiJie
 * @Description 日志管理
 * @Date 16:28 2018/11/14
 */
@Slf4j
@Service
public class LogDetailDaoImpl implements LogDetailDao {

    /* *
     * @Author MengZiJie
     * @Description 获取日志详情
     * @Date 17:13 2018/11/14
     * @Param [logDetailDO]
     * @Return com.ccicnavi.bims.system.pojo.LogDO
     */
    @Override
    public LogDetailDO getLogDetail(LogDetailDO logDetailDO) {
        return EqlUtils.getInstance("DEFAULT").selectFirst("getLogDetail").params(logDetailDO).returnType(LogDetailDO.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 添加详情信息
     * @Date 17:15 2018/11/14
     * @Param [logDetailDO]
     * @Return int
     */
    @Override
    public Integer insertLogDetail(LogDTO logDTO, EqlTran tran) {
        return EqlUtils.getInstance("DEFAULT").useTran(tran).insert("insertLogDetail").params(logDTO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 更新日志详情信息
     * @Date 17:18 2018/11/14
     * @Param [logDetailDO]
     * @Return int
     */
    @Override
    public Integer updateLogDetail(LogDTO logDTO, EqlTran tran) {
        return EqlUtils.getInstance("DEFAULT").useTran(tran).update("updateLogDetail").params(logDTO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 删除日志详情信息
     * @Date 17:19 2018/11/14
     * @Param [logDetailDO]
     * @Return int
     */
    @Override
    public Integer deleteLogDetail(LogDTO logDTO, EqlTran tran) {
        return EqlUtils.getInstance("DEFAULT").useTran(tran).delete("deleteLogDetail").params(logDTO).returnType(Integer.class).execute();
    }

}
