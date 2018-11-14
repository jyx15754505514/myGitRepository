package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.LogDao;
import com.ccicnavi.bims.system.pojo.LogDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
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
        List<LogDO> listLog = null;
        try {
            listLog = EqlUtils.getInstance("druid").select("listLog").params(logDO).returnType(LogDO.class).execute();
        } catch (Exception e) {
            log.debug("",e);
            e.printStackTrace();

        }
        return listLog;
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
        LogDO logdo = null;
        try {
            logdo = EqlUtils.getInstance("druid").selectFirst("getLog").params(logDO).returnType(LogDO.class).execute();
        } catch (Exception e) {
            log.debug("",e);
            e.printStackTrace();
        }
        return logdo;
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
        int countLog = 0;
        try {
            countLog = EqlUtils.getInstance("druid").insert("insertLog").params(logDO).execute();
        } catch (Exception e) {
            log.debug("",e);
            e.printStackTrace();
        }
        return countLog;
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
        int countLog  = 0;
        try {
            countLog = EqlUtils.getInstance("druid").update("updateLog").params(logDO).execute();
        } catch (Exception e) {
            log.debug("",e);
            e.printStackTrace();
        }
        return countLog;
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
        int countLog = 0;
        try {
            countLog = EqlUtils.getInstance("druid").delete("deleteLog").params(logDO).execute();
        } catch (Exception e) {
            log.debug("",e);
            e.printStackTrace();
        }
        return countLog;
    }



    @Test
    public void testFindAll(){

    }


}
