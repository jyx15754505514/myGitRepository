package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.dao.LogDao;

import org.junit.jupiter.api.Test;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * 日志管理
 * @Date 2018/11/13 19 56
 * @Auther mzj
 */
@Service
public class LogDaoImpl implements LogDao {

    /**查询所有的日志信息*/
    /*@Override
    public List<LogDO> listLog(LogDO logDO) {
        return new Eql().select("listLog").returnType(Object.class).execute();
    }*/

    /**获取指定的日志*/
    /*@Override
    public LogDO getLog(LogDO logDO) {
        return new Eql().selectFirst("getLog").returnType(LogDO.class).execute();
    }*/
    @Test
    public void testFindAll(){
        Map<String,Object> listLog = new Eql().select("listLog").execute();
        System.out.print(listLog);
    }

    public static void main(String[] args) {
        Map<String,Object> listLog = new Eql().select("listLog").execute();
        System.out.print(listLog);
    }
}
