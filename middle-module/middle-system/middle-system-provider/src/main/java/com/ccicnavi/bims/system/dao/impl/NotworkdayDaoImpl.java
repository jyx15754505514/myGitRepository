package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.NotworkdayDao;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @program: bims-backend
 * @description: 非工作日dao实现类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
@Service
public class NotworkdayDaoImpl implements NotworkdayDao {


   /**
   * 根据条件查询非工作日
   * @Author zhaotao
   * @Date  2018/11/15 15:54
   * @Param [notworkday]
   * @return java.util.List<com.ccicnavi.bims.system.pojo.NotworkdayDO>
   **/
    @Override
    public List<NotworkdayDO> listNotworkday(NotworkdayDO notworkday) throws Exception{
        return EqlUtils.getInstance("DEFAULT").select("listNotworkday").params(notworkday).returnType(NotworkdayDO.class).execute();
    }

    /**
    * 新增非工作日
    * @Author zhaotao
    * @Date  2018/11/15 15:58
    * @Param [notworkday]
    * @return java.lang.Integer
    **/
    @Override
    public Integer insertNotworkday(NotworkdayDO notworkday) throws Exception{
        return EqlUtils.getInstance("DEFAULT").insert("insertNotworkday").params(notworkday).returnType(Integer.class).execute();
    }

    /**
    * 更新制定或批量更新非工作日
    * @Author zhaotao
    * @Date  2018/11/15 15:59
    * @Param [notworkday]
    * @return java.lang.Integer
    **/
    @Override
    public Integer updateNotworkday(NotworkdayDO notworkday) throws Exception{
        return EqlUtils.getInstance("DEFAULT").insert("updateNotworkday").params(notworkday).returnType(Integer.class).execute();
    }

    /**
    * 逻辑删除制定或批量逻辑删除非工作日 
    * @Author zhaotao
    * @Date  2018/11/15 16:00
    * @Param [notworkday]
    * @return java.lang.Integer
    **/
    @Override
    public Integer deleteNotworkday(NotworkdayDO notworkday) throws Exception{
        return EqlUtils.getInstance("DEFAULT").insert("deleteNotworkday").params(notworkday).returnType(Integer.class).execute();
    }

    /**
    * 获取制定的非工作日
    * @Author zhaotao
    * @Date  2018/11/15 16:00
    * @Param [notworkday]
    * @return com.ccicnavi.bims.system.pojo.NotworkdayDO
    **/
    @Override
    public NotworkdayDO getNotworkday(NotworkdayDO notworkday) throws Exception{
        return EqlUtils.getInstance("DEFAULT").selectFirst("getNotworkday").params(notworkday).returnType(NotworkdayDO.class).execute();
    }
}
