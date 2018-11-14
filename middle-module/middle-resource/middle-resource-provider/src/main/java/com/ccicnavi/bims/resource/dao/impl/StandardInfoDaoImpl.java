package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.dao.StandardInfoDao;
import com.ccicnavi.bims.resource.pojo.StandardInfoDO;
import com.google.common.annotations.VisibleForTesting;
import org.n3r.eql.Eql;

import java.util.List;

public class StandardInfoDaoImpl implements StandardInfoDao{

    /**
     * 列表查询（标准）
     */
    @Override
    public List<StandardInfoDO> listStandardInfoDO(StandardInfoDO standardInfoDO)  {
        List<StandardInfoDO> standardInfoDOList = null;
        try{
            standardInfoDOList =  new Eql().select("listStandardInfo").params(standardInfoDO).returnType(StandardInfoDO.class).execute();
        }catch (Exception e){
            //日志打印

            e.printStackTrace();
        }
        return standardInfoDOList;
    }

    /**
     * 新增（标准）
     * @param standardInfoDO
     * @return
     * @
     */
    @Override
    public Integer insertStandardInfoDO(StandardInfoDO standardInfoDO)  {
        int num = 0;
        try{
            num =  new Eql().insert("insertStandardInfo").params(standardInfoDO).returnType(Integer.class).execute();
        }catch (Exception e){
            //日志打印

            e.printStackTrace();
        }
        return num;
    }

    /**
     * 更新（标准）
     * @param standardInfoDO
     * @return
     * @
     */
    @Override
    public Integer updateStandardInfoDO(StandardInfoDO standardInfoDO)  {
        int num = 0;
        try{
            num =  new Eql().update("updateStandardInfo").params(standardInfoDO).returnType(Integer.class).execute();
        }catch (Exception e){
            //日志打印

            e.printStackTrace();
        }
        return num;
    }

    /**
     * 删除（标准）
     * @param standardInfoDO
     * @return
     * @
     */
    @Override
    public Integer deleteStandardInfoDO(StandardInfoDO standardInfoDO)  {
        int num = 0;
        try{
            num =  new Eql().delete("deleteStandardInfo").params(standardInfoDO).returnType(Integer.class).execute();
        }catch (Exception e){
            //日志打印

            e.printStackTrace();
        }
        return num;
    }

    /**
     * 根据主键或者名称获取（标准）
     * @param standardInfoDO
     * @return
     * @
     */
    @Override
    public StandardInfoDO getStandardInfoDO(StandardInfoDO standardInfoDO)  {
        StandardInfoDO getStandardInfoDO = null;
        try{
            getStandardInfoDO = new Eql().selectFirst("getStandardInfo").params(standardInfoDO).returnType(StandardInfoDO.class).execute();
        }catch (Exception e){
            //日志打印

            e.printStackTrace();
        }
        return getStandardInfoDO;
    }

}
