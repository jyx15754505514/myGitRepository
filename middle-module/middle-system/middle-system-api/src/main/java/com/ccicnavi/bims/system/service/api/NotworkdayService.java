package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;

/**
 * @program: bims-backend
 * @description: 非工作日api接口
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
public interface NotworkdayService {
	
	/**
     * 查询非工作日信息
     * @param parameter
     * @return ResultT
     * @throws Exception
     */
    public ResultT listNotworkday(PageParameter parameter);

    /**
     * 新增非工作日
     * @param notworkday
     * @return Integer
     * @throws Exception
     */
    public Integer insertNotworkday(NotworkdayDO notworkday);

    /**
     * 更新非工作日信息
     * @param notworkday
     * @return Integer
     * @throws Exception
     */
    public Integer updateNotworkday(NotworkdayDO notworkday);

    /**
     * 删除非工作日信息
     * @param notworkday
     * @return Integer
     * @throws Exception
     */
    public Integer deleteNotworkday(NotworkdayDO notworkday);

    /**
     * 根据主键查询非工作日信息
     * @param notworkday
     * @return Notworkday
     * @throws Exception
     */
    public NotworkdayDO getNotworkday(NotworkdayDO notworkday);

}