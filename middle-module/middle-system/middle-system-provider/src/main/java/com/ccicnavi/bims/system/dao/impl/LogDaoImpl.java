package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.LogDao;
import com.ccicnavi.bims.system.pojo.LogDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
/* *
 * @Author MengZiJie
 * @Description 日志管理
 * @Date 16:28 2018/11/14
 */
@Slf4j
@Service
public class LogDaoImpl implements LogDao {

    /* *
     * @Author MengZiJie
     * @Description 查询日志
     * @Date 16:28 2018/11/14
     * @Param [logDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.LogDO>
     */
    @Override
    public List<LogDO> listLog(LogDO logDO) {
        return EqlUtils.getInstance("druid").select("listLog").params(logDO).returnType(LogDO.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 获取指定日志
     * @Date 16:31 2018/11/14
     * @Param [logDO]
     * @Return com.ccicnavi.bims.system.pojo.LogDO
     */
    @Override
    public LogDO getLog(LogDO logDO) {
        return EqlUtils.getInstance("druid").selectFirst("getLog").params(logDO).returnType(LogDO.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 添加日志
     * @Date 16:34 2018/11/14
     * @Param [logDO]
     * @Return int
     */
    @Override
    public int insertLog(LogDO logDO) {
        return EqlUtils.getInstance("druid").insert("insertLog").params(logDO).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 更新日志
     * @Date 16:35 2018/11/14
     * @Param [logDO]
     * @Return int
     */
    @Override
    public int updateLog(LogDO logDO) {
        return EqlUtils.getInstance("druid").update("updateLog").params(logDO).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 删除日志
     * @Date 16:37 2018/11/14
     * @Param [logDO]
     * @Return int
     */
    @Override
    public int deleteLog(LogDO logDO) {
        return EqlUtils.getInstance("druid").delete("deleteLog").params(logDO).execute();
    }
}
