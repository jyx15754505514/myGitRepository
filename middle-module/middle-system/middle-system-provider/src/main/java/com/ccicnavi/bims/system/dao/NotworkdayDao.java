package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;


/**
 * @program: bims-backend
 * @description: 非工作日dao接口
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
public interface NotworkdayDao {
	
	/**
     * 查询非工作日信息
     * @param parameter
     * @return PageBean<Notworkday>
     * @throws Exception
     */
    public PageBean<NotworkdayDO> listNotworkday(PageParameter parameter) throws Exception;

    /**
     * 新增非工作日
     * @param notworkday
     * @return Integer
     * @throws Exception
     */
    public Integer insertNotworkday(NotworkdayDO notworkday)throws  Exception;

    /**
     * 更新非工作日信息
     * @param notworkday
     * @return Integer
     * @throws Exception
     */
    public Integer updateNotworkday(NotworkdayDO notworkday)throws Exception;

    /**
     * 删除非工作日信息
     * @param notworkday
     * @return Integer
     * @throws Exception
     */
    public Integer deleteNotworkday(NotworkdayDO notworkday)throws Exception;

    /**
     * 根据主键查询非工作日信息
     * @param notworkday
     * @return Notworkday
     * @throws Exception
     */
    public NotworkdayDO getNotworkday(NotworkdayDO notworkday)throws Exception;

}