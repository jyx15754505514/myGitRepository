package com.ccicnavi.bims.dict.test;

import com.ccicnavi.bims.system.dao.impl.DictValueDaoImpl;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-27 09:08
 */
public class DictDaoImplTest {

    @Test
    public void testListDistValue(){
        DictValueDaoImpl dictValueDaoImpl=new DictValueDaoImpl();
        DictTypeDTO dictTypeDTO=new DictTypeDTO();
        dictTypeDTO.setProdCatalogUuid("CATALOG_SYSCER");
        dictTypeDTO.setDictParentUuid("ACTIVITY");
        List<DictValueDO> dictValueDOS = dictValueDaoImpl.listDictValue(dictTypeDTO);
        System.out.println(dictValueDOS);
    }


    /**
     * @Author LiJie
     * @Description  {一句话描述}
     * @Date 22:41 2018/11/27
     * @Param []
     * @Return void
     */
    @Test
    public void  testDelDistValue(){
        DictValueDaoImpl dictValueDaoImpl=new DictValueDaoImpl();
        DictTypeDTO dictTypeDTO=new DictTypeDTO();
        List<String> list=new ArrayList<String>();
        list.add("ACTIVITY_1");
        list.add("ACTIVITY_2");
        list.add("ACTIVITY_3");
        dictTypeDTO.setValueUuids(list);
        dictTypeDTO.setOrgUuid("CCIC");
        dictTypeDTO.setAppSysUuid("BIMS2.0");
        Integer integer = dictValueDaoImpl.deleteDictValue(dictTypeDTO);
        System.out.println(integer);
    }



}
