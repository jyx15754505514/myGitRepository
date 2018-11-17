package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.LogDO;
import com.ccicnavi.bims.system.pojo.LogDTO;
import com.ccicnavi.bims.system.pojo.LogDetailDO;

import java.util.List;

/**
 * @Auther: mzj
 * @Date: 2018/11/14 09:37
 * @Description:日志详情
 */
public interface LogDetailDao {

    /**获取指定的日志详情*/
    LogDetailDO getLogDetail(LogDetailDO logDetailDO) throws Exception;
    /**新增日志详情信息*/
    Integer insertLogDetail(LogDTO logDTO) throws Exception;
    /**更新日志详情信息*/
    Integer updateLogDetail(LogDTO logDTO) throws Exception;
    /**删除日志详情*/
    Integer deleteLogDetail(LogDTO logDTO) throws Exception;
}
