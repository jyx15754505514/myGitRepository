package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.LogDO;
import java.util.List;

/**
 * @Auther: mzj
 * @Date: 2018/11/14 09:37
 * @Description:日志
 */
public interface LogDao {

    /**查询所有的日志*/
    List<LogDO> listLog(LogDO logDO) throws Exception;
    /**获取指定的日志*/
    LogDO getLog(LogDO logDO) throws Exception;
    /**新增日志信息*/
    int insertLog(LogDO logDO) throws Exception;
    /**更新日志信息*/
    int updateLog(LogDO logDO) throws Exception;
    /**删除日志*/
    int deleteLog(LogDO logDO) throws Exception;
}
