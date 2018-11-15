package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.LogDetailDO;

/* *
 * @Author MengZiJie
 * @Description 日志详情
 * @Date 17:53 2018/11/14
 */
public interface LogDetailService {

    /**获取指定的日志详情*/
    LogDetailDO getLogDetail(LogDetailDO logDetailDO) throws Exception;
    /**新增日志详情信息*/
    Integer insertLogDetail(LogDetailDO logDetailDO) throws Exception;
    /**更新日志详情信息*/
    Integer updateLogDetail(LogDetailDO logDetailDO) throws Exception;
    /**删除日志详情*/
    Integer deleteLogDetail(LogDetailDO logDetailDO) throws Exception;
}
