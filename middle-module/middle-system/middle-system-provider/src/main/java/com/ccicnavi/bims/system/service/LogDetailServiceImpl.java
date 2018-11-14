package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.LogDetailDao;
import com.ccicnavi.bims.system.pojo.LogDetailDO;
import com.ccicnavi.bims.system.service.api.LogDetailService;
import org.springframework.beans.factory.annotation.Autowired;

/* *
 * @Author MengZiJie
 * @Description 日志详情
 * @Date 18:33 2018/11/14
 */
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
        return LogDetailDao.getLogDetail(logDetailDO);
    }

    /* *
     * @Author MengZiJie
     * @Description 添加日志详情
     * @Date 18:36 2018/11/14
     * @Param [logDetailDO]
     * @Return int
     */
    @Override
    public int insertLogDetail(LogDetailDO logDetailDO) {
        return LogDetailDao.insertLogDetail(logDetailDO);
    }

    /* *
     * @Author MengZiJie
     * @Description 更新日志详情
     * @Date 18:36 2018/11/14
     * @Param [logDetailDO]
     * @Return int
     */
    @Override
    public int updateLogDetail(LogDetailDO logDetailDO) {
        return LogDetailDao.updateLogDetail(logDetailDO);
    }

    /* *
     * @Author MengZiJie
     * @Description 删除日志详情
     * @Date 18:36 2018/11/14
     * @Param [logDetailDO]
     * @Return int
     */
    @Override
    public int deleteLogDetail(LogDetailDO logDetailDO) {
        return LogDetailDao.deleteLogDetail(logDetailDO);
    }
}
