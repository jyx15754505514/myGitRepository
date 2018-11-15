package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.LogDO;
import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 日志管理
 * @Date 17:51 2018/11/14
 */
public interface LogService {

    /**查询所有的日志*/
    List<LogDO> listLog(LogDO logDO);
    /**获取指定的日志*/
    LogDO getLog(LogDO logDO);
    /**新增日志信息*/
    Integer insertLog(LogDO logDO);
    /**更新日志信息*/
    Integer updateLog(LogDO logDO);
    /**删除日志*/
    Integer deleteLog(LogDO logDO);
}
