package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.NotworkdayDao;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
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

   /*
   * 根据条件查询非工作日
   * @Author zhaotao
   * @Date  2018/11/16 15:13
   * @Param [parameter]
   * @return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.system.pojo.NotworkdayDO>
   **/
    @Override
    public PageBean<NotworkdayDO> listNotworkday(PageParameter parameter) throws Exception{
        EqlPage eqlPage = new EqlPage(parameter.getStartIndex(), parameter.getPageRows());
        List<NotworkdayDO> notworkdayList = new Eql().select("listNotworkday").params(parameter.getParameter()).returnType(NotworkdayDO.class).execute();
        if(notworkdayList != null) {
            return new PageBean<NotworkdayDO>(eqlPage.getTotalRows(),eqlPage.getTotalPages(), eqlPage.getCurrentPage(), eqlPage.getPageRows(), eqlPage.getStartIndex(), notworkdayList);
        }else {
            return null;
        }
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
        return new Eql().insert("insertNotworkday").params(notworkday).returnType(Integer.class).execute();
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
        return new Eql().update("updateNotworkday").params(notworkday).returnType(Integer.class).execute();
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
        return new Eql().delete("deleteNotworkday").params(notworkday).returnType(Integer.class).execute();
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
        return new Eql("DEFAULT").selectFirst("getNotworkday").params(notworkday).returnType(NotworkdayDO.class).execute();
    }


}
