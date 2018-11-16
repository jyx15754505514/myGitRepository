package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.LogDao;
import com.ccicnavi.bims.system.dao.LogDetailDao;
import com.ccicnavi.bims.system.pojo.LogDO;
import com.ccicnavi.bims.system.pojo.LogDTO;
import com.ccicnavi.bims.system.service.api.LogService;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/* *
 * @Author MengZiJie
 * @Description 日志详情
 * @Date 17:54 2018/11/14
 */
@Slf4j
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Autowired
    private LogDetailDao logDetailDao;

    /* *
     * @Author MengZiJie
     * @Description 查询日志详情
     * @Date 17:55 2018/11/14
     * @Param [logDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.LogDO>
     */
    @Override
    public ResultT listLog(PageParameter<LogDTO> pageParameter) {
        PageBean<LogDTO> listLog = null;
        try {
            listLog =logDao.listLog(pageParameter);
            if(listLog != null){
                return ResultT.success(listLog);
            }
        } catch (Exception e) {
            log.error("获取日志失败",e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /* *
     * @Author MengZiJie
     * @Description 获取指定日志
     * @Date 17:55 2018/11/14
     * @Param [logDO]
     * @Return com.ccicnavi.bims.system.pojo.LogDO
     */
    @Override
    public ResultT getLog(LogDTO logDTO) {
        LogDTO logdo = null;
        try {
            logdo = logDao.getLog(logDTO);
            if(logdo != null){
                return ResultT.success(logdo);
            }
        } catch (Exception e) {
            log.debug("获取日志失败",e);
            e.printStackTrace();
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }

    /** *
     * @Author MengZiJie
     * @Description 新增日志
     * @Date 17:55 2018/11/14
     * @Param [logDO]
     * @Return int
     */
    @Override
    public ResultT insertLog(LogDTO logDTO) {
        EqlTran aDefault = EqlUtils.getInstance("DEFAULT").newTran();
        Integer countLog = null;
        Integer countLogDetail = null;
        try {
            aDefault.start();
            countLog = logDao.insertLog(logDTO);
            countLogDetail = logDetailDao.insertLogDetail(logDTO);
            if(countLog > 0 && countLogDetail >0){
                aDefault.commit();
                return ResultT.success();
            }
        } catch (Exception e) {
            log.error("添加日志失败",e);
            aDefault.rollback();
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /* *
     * @Author MengZiJie
     * @Description 更新日志
     * @Date 17:55 2018/11/14
     * @Param [logDO]
     * @Return int
     */
    @Override
    public ResultT updateLog(LogDTO logDTO) {
        EqlTran aDefault = EqlUtils.getInstance("DEFAULT").newTran();
        Integer countLog = null;
        Integer countLogDetail = null;
        try {
            aDefault.start();
            countLog = logDao.updateLog(logDTO);
            countLogDetail = logDetailDao.updateLogDetail(logDTO);
            if(countLog > 0 && countLogDetail >0){
                aDefault.commit();
                return ResultT.success();
            }
        } catch (Exception e) {
            log.error("更新日志失败",e);
            e.printStackTrace();
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /* *
     * @Author MengZiJie
     * @Description 删除日志
     * @Date 17:56 2018/11/14
     * @Param [logDO]
     * @Return int
     */
    @Override
    public ResultT deleteLog(LogDTO logDTO) {
        EqlTran aDefault = EqlUtils.getInstance("DEFAULT").newTran();
        Integer countLog = null;
        Integer countLogDetail = null;
        try {
            aDefault.start();
            countLog = logDao.deleteLog(logDTO);
            countLogDetail = logDetailDao.deleteLogDetail(logDTO);
            if(countLog > 0 && countLogDetail > 0){
                aDefault.commit();
                return ResultT.success();
            }
        } catch (Exception e) {
            log.debug("删除日志失败",e);
            e.printStackTrace();
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }
}
