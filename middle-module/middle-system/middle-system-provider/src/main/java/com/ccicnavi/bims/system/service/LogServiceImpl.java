package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.LogDao;
import com.ccicnavi.bims.system.pojo.LogDO;
import com.ccicnavi.bims.system.service.api.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/* *
 * @Author MengZiJie
 * @Description 日志详情
 * @Date 17:54 2018/11/14
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao logDao;

    /* *
     * @Author MengZiJie
     * @Description 查询日志详情
     * @Date 17:55 2018/11/14
     * @Param [logDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.LogDO>
     */
    @Override
    public List<LogDO> listLog(LogDO logDO) {
        return logDao.listLog(logDO);
    }

    /* *
     * @Author MengZiJie
     * @Description 获取指定日志
     * @Date 17:55 2018/11/14
     * @Param [logDO]
     * @Return com.ccicnavi.bims.system.pojo.LogDO
     */
    @Override
    public LogDO getLog(LogDO logDO) {
        return logDao.getLog(logDO);
    }

    /** *
     * @Author MengZiJie
     * @Description 新增日志
     * @Date 17:55 2018/11/14
     * @Param [logDO]
     * @Return int
     */
    @Override
    public int insertLog(LogDO logDO) {
        return logDao.insertLog(logDO);
    }

    /* *
     * @Author MengZiJie
     * @Description 更新日志
     * @Date 17:55 2018/11/14
     * @Param [logDO]
     * @Return int
     */
    @Override
    public int updateLog(LogDO logDO) {
        return logDao.updateLog(logDO);
    }

    /* *
     * @Author MengZiJie
     * @Description 删除日志
     * @Date 17:56 2018/11/14
     * @Param [logDO]
     * @Return int
     */
    @Override
    public int deleteLog(LogDO logDO) {
        return logDao.deleteLog(logDO);
    }
}
