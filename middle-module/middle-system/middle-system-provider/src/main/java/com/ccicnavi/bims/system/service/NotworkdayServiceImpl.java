package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.NotworkdayDao;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;
import com.ccicnavi.bims.system.service.api.NotworkdayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: bims-backend
 * @description: 非工作日api实现类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
@Service
@Slf4j
public class NotworkdayServiceImpl implements NotworkdayService {

    @Autowired
    private NotworkdayDao notworkdayDao;

    /*
    * 根据条件查询非工作日
    * @Author zhaotao
    * @Date  2018/11/16 16:55
    * @Param [parameter]
    * @return com.ccicnavi.bims.common.ResultT
    **/
    @Override
    public ResultT listNotworkday(PageParameter parameter) {
        try {
            PageBean<NotworkdayDO> pageBean = notworkdayDao.listNotworkday(parameter);
            if(pageBean != null) {
                return ResultT.success(pageBean);
            }
        } catch (Exception e) {
            log.error("根据条件查询非工作日失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /*
    * 新增非工作日
    * @Author zhaotao
    * @Date  2018/11/16 16:58
    * @Param [notworkday]
    * @return java.lang.Integer
    **/
    @Override
    public Integer insertNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.insertNotworkday(notworkday);
        } catch (Exception e) {
            log.error("新增非工作日失败", e);
            return null;
        }
    }

    /*
    * 更新非工作日
    * @Author zhaotao
    * @Date  2018/11/16 16:58
    * @Param [notworkday]
    * @return java.lang.Integer
    **/
    @Override
    public Integer updateNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.updateNotworkday(notworkday);
        } catch (Exception e) {
            log.error("更新非工作日失败", e);
            return null;
        }
    }

    /*
    * 删除非工作日
    * @Author zhaotao
    * @Date  2018/11/16 16:58
    * @Param [notworkday]
    * @return java.lang.Integer
    **/
    @Override
    public Integer deleteNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.deleteNotworkday(notworkday);
        } catch (Exception e) {
            log.error("删除非工作日失败", e);
            return null;
        }
    }

    /*
    * 获取指定非工作日
    * @Author zhaotao
    * @Date  2018/11/16 16:57
    * @Param [notworkday]
    * @return com.ccicnavi.bims.system.pojo.NotworkdayDO
    **/
    @Override
    public NotworkdayDO getNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.getNotworkday(notworkday);
        } catch (Exception e) {
            log.error("获取指定非工作日失败", e);
        }
        return null;
    }

}
