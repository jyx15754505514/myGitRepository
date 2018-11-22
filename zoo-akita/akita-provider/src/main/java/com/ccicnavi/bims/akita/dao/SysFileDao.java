package com.ccicnavi.bims.akita.dao;

import com.ccicnavi.bims.akita.pojo.SysFileParallel;
import com.ccicnavi.bims.akita.pojo.SysFile;

import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 地区管理
 * @Date 16:48 2018/11/14
 */
public interface SysFileDao {

    /**新增*/
    Integer insertSysFile(SysFile sysFile) throws Exception;

    //查询
    List<SysFile> listSysFile()throws Exception;

   //新增到并联表
   Integer insertFileFastSys(SysFileParallel fileFastSys) throws Exception;

}
