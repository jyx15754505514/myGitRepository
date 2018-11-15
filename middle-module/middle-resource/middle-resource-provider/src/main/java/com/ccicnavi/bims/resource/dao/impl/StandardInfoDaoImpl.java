package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.dao.StandardInfoDao;
import com.ccicnavi.bims.resource.pojo.StandardInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StandardInfoDaoImpl implements StandardInfoDao{

    /**
     * 列表查询（标准）
     */
    @Override
    public List<StandardInfoDO> listStandardInfoDO(StandardInfoDO standardInfoDO)  {
        List<StandardInfoDO> standardInfoDOList = null;
        try{
            standardInfoDOList =  EqlUtils.getInstance("DEFAULT").select("listStandardInfo").params(standardInfoDO).returnType(StandardInfoDO.class).execute();
        }catch (Exception e){
            //日志打印
            log.error("",e);
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
            num =  EqlUtils.getInstance("DEFAULT").insert("insertStandardInfo").params(standardInfoDO).returnType(Integer.class).execute();
        }catch (Exception e){
            //日志打印
            log.error("",e);
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
            num =  EqlUtils.getInstance("DEFAULT").update("updateStandardInfo").params(standardInfoDO).returnType(Integer.class).execute();
        }catch (Exception e){
            //日志打印
            log.error("",e);
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
            num =  EqlUtils.getInstance("DEFAULT").delete("deleteStandardInfo").params(standardInfoDO).returnType(Integer.class).execute();
        }catch (Exception e){
            //日志打印
            log.error("",e);
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
            getStandardInfoDO = EqlUtils.getInstance("DEFAULT").selectFirst("getStandardInfo").params(standardInfoDO).returnType(StandardInfoDO.class).execute();
        }catch (Exception e){
            //日志打印
            log.error("",e);
            e.printStackTrace();
        }
        return getStandardInfoDO;
    }

}
