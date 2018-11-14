package com.ccicnavi.bims.system.dao.impl;




import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.NotworkdayDao;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NotworkdayDaoImpl implements NotworkdayDao {

    private final static Logger log = LoggerFactory.getLogger(NotworkdayDaoImpl.class);

    @Override
    public List<NotworkdayDO> listNotworkday(NotworkdayDO notworkday){
        try{
            return EqlUtils.getInstance("druid").select("listNotworkday").params(notworkday).returnType(NotworkdayDO.class).execute();
        }catch (Exception e) {
            log.error("",e);
            return null;
        }
    }

    @Override
    public Integer insertNotworkday(NotworkdayDO notworkday){
        try{
            return EqlUtils.getInstance("druid").insert("insertNotworkday").params(notworkday).returnType(Integer.class).execute();
        }catch (Exception e) {
            log.error("",e);
            return null;
        }
    }

    @Override
    public Integer updateNotworkday(NotworkdayDO notworkday){
        try{
            return EqlUtils.getInstance("druid").insert("updateNotworkday").params(notworkday).returnType(Integer.class).execute();
        }catch (Exception e) {
            log.error("",e);
            return null;
        }
    }

    @Override
    public Integer deleteNotworkday(NotworkdayDO notworkday){
        try{
            return EqlUtils.getInstance("druid").insert("deleteNotworkday").params(notworkday).returnType(Integer.class).execute();
        }catch (Exception e) {
            log.error("",e);
            return null;
        }
    }

    @Override
    public NotworkdayDO getNotworkday(NotworkdayDO notworkday){
        try{
            return EqlUtils.getInstance("druid").selectFirst("getNotworkday").params(notworkday).returnType(NotworkdayDO.class).execute();
        }catch (Exception e) {
            log.error("",e);
            return null;
        }
    }
}
