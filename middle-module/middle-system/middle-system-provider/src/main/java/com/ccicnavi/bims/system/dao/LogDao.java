package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.LogDO;
import com.ccicnavi.bims.system.pojo.LogDTO;

import java.util.List;

/**
 * @Auther: mzj
 * @Date: 2018/11/14 09:37
 * @Description:日志
 */
public interface LogDao {

    /**查询所有的日志*/
    PageBean<LogDTO> listLog(PageParameter<LogDTO> pageParameter) throws Exception;
    /**获取指定的日志*/
    LogDTO getLog(LogDTO logDTO) throws Exception;
    /**新增日志信息*/
    Integer insertLog(LogDTO logDTO) throws Exception;
    /**更新日志信息*/
    Integer updateLog(LogDTO logDTO) throws Exception;
    /**删除日志*/
    Integer deleteLog(LogDTO logDTO) throws Exception;
}
