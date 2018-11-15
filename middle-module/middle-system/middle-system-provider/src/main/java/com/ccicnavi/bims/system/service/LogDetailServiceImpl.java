package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.LogDetailDao;
import com.ccicnavi.bims.system.pojo.LogDetailDO;
import com.ccicnavi.bims.system.service.api.LogDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/* *
 * @Author MengZiJie
 * @Description 日志详情
 * @Date 18:33 2018/11/14
 */
@Slf4j
@Service
public class LogDetailServiceImpl implements LogDetailService {

    @Autowired
    LogDetailDao LogDetailDao;

    /* *
     * @Author MengZiJie
     * @Description 获取日志信息
     * @Date 18:36 2018/11/14
     * @Param [logDetailDO]
     * @Return com.ccicnavi.bims.system.pojo.LogDetailDO
     */
    @Override
    public LogDetailDO getLogDetail(LogDetailDO logDetailDO) {
        LogDetailDO logDetail = null;
        try {
            logDetail = LogDetailDao.getLogDetail(logDetailDO);
        } catch (Exception e) {
            log.debug("获取日志详情失败",e);
            e.printStackTrace();
        }
        return logDetail;
    }

    /* *
     * @Author MengZiJie
     * @Description 添加日志详情
     * @Date 18:36 2018/11/14
     * @Param [logDetailDO]
     * @Return int
     */
    @Override
    public Integer insertLogDetail(LogDetailDO logDetailDO) {
        int logDetail = 0;
        try {
            logDetail = LogDetailDao.insertLogDetail(logDetailDO);
        } catch (Exception e) {
            log.debug("添加日志详情失败",e);
            e.printStackTrace();
        }
        return logDetail;
    }

    /* *
     * @Author MengZiJie
     * @Description 更新日志详情
     * @Date 18:36 2018/11/14
     * @Param [logDetailDO]
     * @Return int
     */
    @Override
    public Integer updateLogDetail(LogDetailDO logDetailDO) {
        int logDetail = 0;
        try {
            logDetail = LogDetailDao.updateLogDetail(logDetailDO);
        } catch (Exception e) {
            log.debug("更新日志详情失败",e);
            e.printStackTrace();
        }
        return logDetail;
    }

    /* *
     * @Author MengZiJie
     * @Description 删除日志详情
     * @Date 18:36 2018/11/14
     * @Param [logDetailDO]
     * @Return int
     */
    @Override
    public Integer deleteLogDetail(LogDetailDO logDetailDO) {
        int logDetail = 0;
        try {
            logDetail = LogDetailDao.deleteLogDetail(logDetailDO);
        } catch (Exception e) {
            log.debug("删除日志详情失败",e);
            e.printStackTrace();
        }
        return logDetail;
    }
}
