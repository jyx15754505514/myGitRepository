package com.ccicnavi.bims.product.service.api;

import com.ccicnavi.bims.system.pojo.NotworkdayDO;

import java.util.List;


public interface NotworkdayService {
	
	/**
     * 查询非工作日信息
     * @param notworkday
     * @return List<Notworkday>
     * @throws Exception
     */
    public List<NotworkdayDO> listNotworkday(NotworkdayDO notworkday) throws Exception;

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