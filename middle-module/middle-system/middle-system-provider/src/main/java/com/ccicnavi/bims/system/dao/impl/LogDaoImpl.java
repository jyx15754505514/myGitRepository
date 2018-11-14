package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.dao.LogDao;
import com.ccicnavi.bims.system.pojo.LogDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class LogDaoImpl implements LogDao {

    Eql eql = new Eql();
    /**查询所有的日志*/
    @Override
    public List<LogDO> listLog(LogDO logDO) {
        return eql.select("listLog").params(logDO).returnType(LogDO.class).execute();
    }

    /**获取指定的日志*/
    @Override
    public LogDO getLog(LogDO logDO) {
        return eql.selectFirst("getLog").params(logDO).returnType(LogDO.class).execute();
    }

    /**添加日志*/
    @Override
    public int insertLog(LogDO logDO) {
        return eql.insert("insertLog").params(logDO).execute();
    }

    /**更新日志*/
    @Override
    public int updateLog(LogDO logDO) {
        return eql.update("updateLog").params(logDO).execute();
    }

    /**删除日志*/
    @Override
    public int deleteLog(LogDO logDO) {
        return eql.delete("deleteLog").params(logDO).execute();
    }


    public static void main(String[] args) {
        List<Map<String, Object>> map = new Eql().select("listLog").execute();
        System.out.print(map);
    }

}
