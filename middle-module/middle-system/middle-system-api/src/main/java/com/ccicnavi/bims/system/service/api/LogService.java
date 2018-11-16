package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.LogDO;
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
    List<LogDO> listLog(LogDO logDO);
    /* *
     * @Author MengZiJie
     * @Description 获取指定日志
     * @Date 17:51 2018/11/14
     * @Param [logDO]
     * @Return com.ccicnavi.bims.system.pojo.LogDO
     */
    LogDO getLog(LogDO logDO);
    /* *
     * @Author MengZiJie
     * @Description 新增日志
     * @Date 17:51 2018/11/14
     * @Param [logDO]
     * @Return java.lang.Integer
     */
    Integer insertLog(LogDO logDO);
    /* *
     * @Author MengZiJie
     * @Description 更新日志
     * @Date 17:51 2018/11/14
     * @Param [logDO]
     * @Return java.lang.Integer
     */
    Integer updateLog(LogDO logDO);
    /* *
     * @Author MengZiJie
     * @Description 删除日志
     * @Date 17:51 2018/11/14
     * @Param [logDO]
     * @Return java.lang.Integer
     */
    Integer deleteLog(LogDO logDO);
}
