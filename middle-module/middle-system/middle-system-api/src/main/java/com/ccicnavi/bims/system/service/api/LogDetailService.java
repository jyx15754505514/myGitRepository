package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.LogDTO;
import com.ccicnavi.bims.system.pojo.LogDetailDO;

/* *
 * @Author MengZiJie
 * @Description 日志详情
 * @Date 17:53 2018/11/14
 */
public interface LogDetailService {

    /* *
     * @Author MengZiJie
     * @Description 获取日志详情
     * @Date 17:53 2018/11/14
     * @Param [logDetailDO]
     * @Return com.ccicnavi.bims.system.pojo.LogDetailDO
     */
    LogDetailDO getLogDetail(LogDetailDO logDetailDO);
    /* *
     * @Author MengZiJie
     * @Description 新增日志详情
     * @Date 17:53 2018/11/14
     * @Param [logDetailDO]
     * @Return java.lang.Integer
     */
    Integer insertLogDetail(LogDTO logDTO);
    /* *
     * @Author MengZiJie
     * @Description 更新日志详情
     * @Date 17:53 2018/11/14
     * @Param [logDetailDO]
     * @Return java.lang.Integer
     */
    Integer updateLogDetail(LogDTO logDTO);
    /* *
     * @Author MengZiJie
     * @Description 删除日志
     * @Date 17:53 2018/11/14
     * @Param [logDetailDO]
     * @Return java.lang.Integer
     */
    Integer deleteLogDetail(LogDTO logDTO);
}
