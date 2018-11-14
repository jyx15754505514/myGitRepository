package com.ccicnavi.bims.resource.dao.impl;


import com.ccicnavi.bims.resource.dao.SealDao;
import com.ccicnavi.bims.resource.pojo.SealDO;
import org.n3r.eql.Eql;
import java.util.List;

public class SealDaoImpl implements SealDao{

    /**
     * 列表查询（封识）
     */
    @Override
    public List<SealDO> listSealDO(SealDO sealDO){
        List<SealDO> sealList = null;
        try{
            sealList =  new Eql().select("listSeal").params(sealDO).returnType(SealDO.class).execute();
        }catch (Exception e){
            //日志打印

            e.printStackTrace();
        }
        return sealList;
    }

    /**
     * 新增（封识）
     * @param sealDO
     * @return
     * @throws Exception
     */
    @Override
    public Integer insertSealDO(SealDO sealDO) {
        int num = 0;
        try{
            num =  new Eql().insert("insertSeal").params(sealDO).returnType(Integer.class).execute();
        }catch (Exception e){
            //日志打印

            e.printStackTrace();
        }
        return num;
    }

    /**
     * 更新（封识）
     * @param sealDO
     * @return
     * @throws Exception
     */
    @Override
    public Integer updateSealDO(SealDO sealDO) {
        int num = 0;
        try{
            num =  new Eql().update("updateSeal").params(sealDO).returnType(Integer.class).execute();
        }catch (Exception e){
            //日志打印

            e.printStackTrace();
        }
        return num;
    }

    /**
     * 删除（封识）
     * @param sealDO
     * @return
     * @throws Exception
     */
    @Override
    public Integer deleteSealDO(SealDO sealDO) {
        int num = 0;
        try{
            num =  new Eql().delete("deleteSeal").params(sealDO).returnType(Integer.class).execute();
        }catch (Exception e){
            //日志打印

            e.printStackTrace();
        }
        return num;
    }

    /**
     * 根据主键或者名称获取（封识）
     * @param sealDO
     * @return
     * @throws Exception
     */
    @Override
    public SealDO getSealDO(SealDO sealDO) {
        SealDO getSeal = null;
        try {
            getSeal = new Eql().selectFirst("getSeal").params(sealDO).returnType(SealDO.class).execute();
        } catch (Exception e) {
            //日志打印

            e.printStackTrace();
        }
        return getSeal;
    }




}
