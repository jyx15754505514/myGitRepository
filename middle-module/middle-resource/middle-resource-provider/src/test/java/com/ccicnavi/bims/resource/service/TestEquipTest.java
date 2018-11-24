import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.impl.EquipTestDaoImpl;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;
import com.ccicnavi.bims.resource.pojo.EquipTestDTO;
import org.junit.Test;
import java.util.List;

/**
  * @author songyateng
  * @description 测试设备检定信息
  * @date 2018/11/23 17:00
  */
public class TestEquipTest {

    /**
      * @author songyateng
      * @description 根据设备检定信息主键获取设备检定信息
      * @date 2018/11/23 17:04
      */
    @Test
    public void getEquipTest(){
        try {
            EquipTestDaoImpl equipUseDaoImpl = new EquipTestDaoImpl();
            EquipTestDO equipUseDO = new EquipTestDO();
            equipUseDO.setEquipTestUuid("woshizhujian");
            EquipTestDO equipTest = equipUseDaoImpl.getEquipTest(equipUseDO);
            System.err.println(equipTest);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
      * @author songyateng
      * @description 根据uuids查询设备信息
      * @date 2018/11/24 9:25
      */
    @Test
    public void getEquipTestList(){
        try {
            EquipTestDaoImpl equipUseDaoImpl = new EquipTestDaoImpl();
            EquipTestDTO equipUseDTO = new EquipTestDTO();
            List<EquipTestDO> equipTestList = equipUseDaoImpl.getEquipTestList(equipUseDTO);
            System.err.println(equipTestList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /**
      * @author songyateng
      * @description 设备检定信息查询
      * @date 2018/11/24 9:31
      */
    @Test
    public void listEquipTest(){
        try {
            PageParameter<EquipTestDO> pageParameter = new PageParameter();
            EquipTestDO equipUseDO = new EquipTestDO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(1);
            pageParameter.setStartPage(1);
            EquipTestDaoImpl equipUseDaoImpl = new EquipTestDaoImpl();
            PageBean<EquipTestDO> equipTestDOPageBean = equipUseDaoImpl.listEquipTest(pageParameter);
            System.err.println(equipTestDOPageBean);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
      * @author songyateng
      * @description 新增设备检定信息
      * @date 2018/11/24 9:34
      */
    @Test
    public void insertEquipTest(){
        try {
            EquipTestDaoImpl equipUseDaoImpl = new EquipTestDaoImpl();
            EquipTestDO equipUseDO = new EquipTestDO();
            equipUseDO.setEquipTestUuid("nihao");
            equipUseDO.setEquipUuid("woshiuuid");
            equipUseDO.setIsDeleted("N");
            equipUseDO.setProdCatalogUuid("chanpinxianid");
            equipUseDO.setOrgUuid("guishujigouid");
            equipUseDO.setAppSysUuid("yingyongxitongid");
            System.err.print(equipUseDaoImpl.insertEquipTest(equipUseDO, null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
      * @author songyateng
      * @description 更新设备检定信息
      * @date 2018/11/24 9:39
      */
    @Test
    public void updateEquipTest(){
        try {
            EquipTestDaoImpl equipUseDaoImpl = new EquipTestDaoImpl();
            EquipTestDO equipUseDO = new EquipTestDO();
            equipUseDO.setEquipTestUuid("nihao");
            equipUseDO.setEquipUuid("beixiugai");
            equipUseDO.setIsDeleted("N");
            equipUseDO.setProdCatalogUuid("beixiugai");
            equipUseDO.setOrgUuid("beixiugai");
            equipUseDO.setAppSysUuid("beixiugai");
            System.err.print(equipUseDaoImpl.updateEquipTest(equipUseDO, null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
      * @author songyateng
      * @description 根据设备领用归还信息主键删除设备领用归还信息
      * @date 2018/11/24 9:43
      */
    @Test
    public void deleteEquipTest(){
        try {
            EquipTestDaoImpl equipUseDaoImpl = new EquipTestDaoImpl();
            EquipTestDTO equipTestDTO = new EquipTestDTO();
            equipTestDTO.setEquipTestUuid("nihao");
            System.err.print(equipUseDaoImpl.deleteEquipTest(equipTestDTO, null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /**
      * @author songyateng
      * @description 
      * @date 2018/11/24 9:47
      */
    @Test
    public void listEquipTestDTO(){
        try {
            PageParameter<EquipTestDTO> pageParameter = new PageParameter();
            EquipTestDTO equipTestDTO = new EquipTestDTO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(1);
            pageParameter.setStartPage(1);
            EquipTestDaoImpl equipUseDaoImpl = new EquipTestDaoImpl();
            PageBean<EquipTestDTO> equipTestDTOPageBean = equipUseDaoImpl.listEquipTestDTO(pageParameter);
            System.out.println(equipTestDTOPageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
