package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.LogDO;
import com.ccicnavi.bims.system.pojo.LogDTO;

import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 日志管理
 * @Date 17:51 2018/11/14
 */
public interface LogService {

    /* *
     * @Author MengZiJie
     * @Description 查询所有日志
     * @Date 17:51 2018/11/14
     * @Param [logDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.LogDO>
     */
    ResultT listLog(PageParameter<LogDTO> pageParameter);
    /* *
     * @Author MengZiJie
     * @Description 获取指定日志
     * @Date 17:51 2018/11/14
     * @Param [logDO]
     * @Return com.ccicnavi.bims.system.pojo.LogDO
     */
    ResultT getLog(LogDTO logDTO);
    /* *
     * @Author MengZiJie
     * @Description 新增日志
     * @Date 17:51 2018/11/14
     * @Param [logDO]
     * @Return java.lang.Integer
     */
    ResultT insertLog(LogDTO logDTO);
    /* *
     * @Author MengZiJie
     * @Description 更新日志
     * @Date 17:51 2018/11/14
     * @Param [logDO]
     * @Return java.lang.Integer
     */
    ResultT updateLog(LogDTO logDTO);
    /* *
     * @Author MengZiJie
     * @Description 删除日志
     * @Date 17:51 2018/11/14
     * @Param [logDO]
     * @Return java.lang.Integer
     */
    ResultT deleteLog(LogDTO logDTO);
}
