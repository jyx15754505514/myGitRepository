package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.LogDetailDao;
import com.ccicnavi.bims.system.pojo.LogDTO;
import com.ccicnavi.bims.system.pojo.LogDetailDO;
import com.ccicnavi.bims.system.service.api.LogDetailService;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
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
    private LogDetailDao LogDetailDao;

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
            log.error("获取日志详情失败",e);
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
    public Integer insertLogDetail(LogDTO logDTO) {
        Integer logDetail = null;
        EqlTran aDefault = null;
        try {
            logDetail = LogDetailDao.insertLogDetail(logDTO,aDefault);
        } catch (Exception e) {
            log.error("添加日志详情失败",e);
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
    public Integer updateLogDetail(LogDTO logDTO) {
        Integer logDetail = null;
        EqlTran aDefault = null;
        try {
            logDetail = LogDetailDao.updateLogDetail(logDTO,aDefault);
        } catch (Exception e) {
            log.error("更新日志详情失败",e);
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
    public Integer deleteLogDetail(LogDTO logDTO) {
        Integer logDetail = null;
        EqlTran aDefault = null;
        try {
            logDetail = LogDetailDao.deleteLogDetail(logDTO,aDefault);
        } catch (Exception e) {
            log.error("删除日志详情失败",e);
        }
        return logDetail;
    }
}
