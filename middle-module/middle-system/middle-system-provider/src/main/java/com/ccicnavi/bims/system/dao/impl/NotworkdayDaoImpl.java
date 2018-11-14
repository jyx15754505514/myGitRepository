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

    private final static Logger log = LoggerFactory.getLogger(NotworkdayDaoImpl.class);

    @Override
    public List<NotworkdayDO> listNotworkday(NotworkdayDO notworkday) throws Exception{
        return EqlUtils.getInstance("DEFAULT").select("listNotworkday").params(notworkday).returnType(NotworkdayDO.class).execute();
    }

    @Override
    public Integer insertNotworkday(NotworkdayDO notworkday) throws Exception{
        return EqlUtils.getInstance("DEFAULT").insert("insertNotworkday").params(notworkday).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateNotworkday(NotworkdayDO notworkday) throws Exception{
        return EqlUtils.getInstance("DEFAULT").insert("updateNotworkday").params(notworkday).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteNotworkday(NotworkdayDO notworkday) throws Exception{
        return EqlUtils.getInstance("DEFAULT").insert("deleteNotworkday").params(notworkday).returnType(Integer.class).execute();
    }

    @Override
    public NotworkdayDO getNotworkday(NotworkdayDO notworkday) throws Exception{
        return EqlUtils.getInstance("DEFAULT").selectFirst("getNotworkday").params(notworkday).returnType(NotworkdayDO.class).execute();
    }
}
