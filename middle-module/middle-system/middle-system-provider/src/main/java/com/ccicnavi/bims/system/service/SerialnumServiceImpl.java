package com.ccicnavi.bims.system.service;

import com.alibaba.druid.sql.dialect.db2.ast.stmt.DB2SelectQueryBlock;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.sso.api.SSOService;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.sso.common.result.ReturnT;
import com.ccicnavi.bims.system.constant.SerialnumCfgType;
import com.ccicnavi.bims.system.dao.SerialnumDao;
import com.ccicnavi.bims.system.dao.impl.SerialnumDaoImpl;
import com.ccicnavi.bims.system.pojo.*;
import com.ccicnavi.bims.system.service.api.SerialnumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 20:19
 * @Description: 业务规则编号管理
 */
@Slf4j
@Service
public class SerialnumServiceImpl implements SerialnumService {

//    @Reference(timeout = 1000000,url = "dubbo://127.0.0.1:20880")
    @Reference
    IdWorkerService idWorkerService;
//    @Reference(timeout = 1000000,url = "dubbo://127.0.0.1:20896")
    @Reference
    SSOService ssoService;
    @Autowired
    SerialnumDao serialnumDao;

    /**
     *
     * 功能描述: 分页查询业务规则编码信息
     *
     * @param: pageParameter
     * @return: PageBean<SerialnumCfgDO>
     * @date: 2018/11/20 20:38
     * @auther: CongZhiYuan
     */
    @Override
    public PageBean<SerialnumCfgDO> listSerialnumCfg(PageParameter<SerialnumCfgDO> pageParameter) throws Exception {
        try {
            return serialnumDao.listSerialnumCfg(pageParameter);
        } catch (Exception e) {
            log.error("查询失败",e);
        }
        return new PageBean<>(0,0,0,0,0,new ArrayList<SerialnumCfgDO>());
    }
    /**
     *
     * 功能描述: 获取业务编码规则配置信息
     *
     * @param: serialnumCfgDTO
     * @return:
     * @date: 2018/11/20 20:41
     * @auther: CongZhiYuan
     */
    @Override
    public SerialnumCfgDTO getSerialnumCfg(SerialQueryDTO serialQueryDTO) throws Exception {
        try {
            SerialnumCfgDO serialnumCfgDO = serialnumDao.getSerialnumCfg(serialQueryDTO);
            List<SerialnumCfgItemDO> itemList = serialnumDao.getSeriItemList(serialQueryDTO.getSncUuid());
            SerialnumCfgDTO dto = new SerialnumCfgDTO();
            BeanUtils.copyProperties(serialnumCfgDO, dto);
            dto.setItems(itemList);
            return dto;
        } catch (Exception e) {
            log.error("获取业务编码规则失败",e);
            return null;
        }
    }

    /**
     *
     * 功能描述: 添加业务编码规则配置信息
     *
     * @param: serialnumCfgDTO
     * @return:
     * @date: 2018/11/20 20:41
     * @auther: CongZhiYuan
     */
    @Override
    public void addSerialnumCfg(SerialnumCfgDTO serialnumCfgDTO) throws Exception {
        log.info("更新业务编码规则,serialnumCfgDTO={}", serialnumCfgDTO);
        SerialnumCfgDO cfgDO = new SerialnumCfgDO();
        BeanUtils.copyProperties(serialnumCfgDTO, cfgDO);
        String sncUuid = idWorkerService.getId(new Date());
        cfgDO.setSncUuid(sncUuid);
        serialnumDao.insertSerialnumCfg(cfgDO);
        for(SerialnumCfgItemDO serialnumCfgItemDO:serialnumCfgDTO.getItems()){
            String sncdUuid = idWorkerService.getId(new Date());
            serialnumCfgItemDO.setSncdUuid(sncdUuid);
            serialnumCfgItemDO.setSncUuid(sncUuid);
            serialnumDao.insertSerialnumCfgItem(serialnumCfgItemDO);
        }
        log.info("创建业务编码规则完成");
    }

    /**
     *
     * 功能描述: 添加业务编码规则配置信息
     *
     * @param: serialnumCfgDTO
     * @return:
     * @date: 2018/11/20 20:41
     * @auther: CongZhiYuan
     */
    @Override
    public Integer updateSerialnumCfg(SerialnumCfgDTO serialnumCfgDTO) throws Exception {
        log.info("更新业务编码规则,serialnumCfgDTO={}", serialnumCfgDTO);
        SerialnumCfgDO cfgDO = new SerialnumCfgDO();
        BeanUtils.copyProperties(serialnumCfgDTO, cfgDO);
        int rtnval = serialnumDao.updateSerialnumCfg(cfgDO);//更新cfg数据
        serialnumDao.deleteSerialnumCfgItem(serialnumCfgDTO.getSncUuid());//先删除原有表达式
        for(SerialnumCfgItemDO serialnumCfgItemDO:serialnumCfgDTO.getItems()){
            String sncdUuid = idWorkerService.getId(new Date());
            serialnumCfgItemDO.setSncdUuid(sncdUuid);
            serialnumCfgItemDO.setSncUuid(serialnumCfgDTO.getSncUuid());
            serialnumDao.insertSerialnumCfgItem(serialnumCfgItemDO);//插入新表达式
        }
        log.info("更新业务编码规则完成");
        return rtnval;
    }

    /**
     *
     * 功能描述:删除业务编码规则
     *
     * @param: serialnumUuid
     * @return: busSerialnumNo
     * @date:  2018/11/20 20:48
     * @auther: CongZhiYuan
     */
    @Override
    public Integer deleteSerialnumCfg(String serialnumUuid) throws Exception {
        log.info("删除业务编码规则,serialnumUuid={}", serialnumUuid);
        int rtnval = serialnumDao.deleteSerialnumCfg(serialnumUuid);//删除cfg数据
//        serialnumDao.deleteSerialnumCfgItem(serialnumUuid);//不必删除，cfg不显示，item即不可见。
        log.error("删除业务编码规则完成");
        return rtnval;
    }

    /**
     *
     * 功能描述: 根据业务规则编号获取业务编码
     *
     * @param: sncUuid
     * @param: token
     * @return: busSerialnumNo
     * @date:  2018/11/20 20:50
     * @auther: CongZhiYuan
     */
    @Override
    public String getBusSerialnumNo(String sncUuid, String token) throws Exception {
        return this.getBusSerialnumNo(sncUuid, null, token);
    }

    /**
     *
     * 功能描述: 根据业务规则编号获取业务编码
     *
     * @param: sncUuid
     * @return: busSerialnumNo
     * @date:  2018/11/20 20:50
     * @auther: CongZhiYuan
     */
    @Override
    public synchronized String getBusSerialnumNo(String sncUuid, String busUuid, String token) throws Exception {
        String busiNo = "";
        try {
            ReturnT<SSOUser> ssoUser = ssoService.logincheck(token);

            /*if(ssoUser==null||ssoUser.getData()==null){
                log.info("获取用户信息失败...");
                return "";
            }*/
            SerialQueryDTO serialQueryDTO = new SerialQueryDTO();
            serialQueryDTO.setSncUuid(sncUuid);
            serialQueryDTO.setBusUuid(busUuid);
//            serialQueryDTO.setOrgUuid(ssoUser.getData().getOrgUuid());//暂定，后由用户信息获得
//            serialQueryDTO.setAppSysUuid(ssoUser.getData().getAppSysUuid());//暂定，后由用户信息获得
//            serialQueryDTO.setProdCatalogUuid(ssoUser.getData().getProdCatalogUuid());//暂定，后由用户信息获得
            serialQueryDTO.setOrgUuid("0102");
            serialQueryDTO.setAppSysUuid("bims");
            serialQueryDTO.setProdCatalogUuid("test");
            SerialnumCfgDO cfgDO = serialnumDao.getSerialnumCfg(serialQueryDTO);
            List<SerialnumCfgItemDO> itemList = serialnumDao.getSeriItemList(serialQueryDTO.getSncUuid());
            SerialnumDO serialnumDO = new SerialnumDO();
            serialnumDO.setSncUuid(serialQueryDTO.getSncUuid());
            serialnumDO.setOrgUuid(serialQueryDTO.getOrgUuid());
            serialnumDO.setBusUuid(serialQueryDTO.getBusUuid());
            SerialnumDO busiSerialDO = serialnumDao.getSerialnumDO(serialnumDO);
            //根据查询规则信息生成业务编码
            if(cfgDO!=null&&itemList!=null&&!itemList.isEmpty()){
                busiNo = this.getBusiSerialNo(ssoUser.getData(), cfgDO, itemList, busiSerialDO, busUuid);
            }else{
                log.info("业务编码规则错误...");
            }
        } catch (Exception e) {
            log.error("获取业务编码规则失败",e);
        }
        return busiNo;
    }

    /**
     *
     * 功能描述: 根据业务规则编号获取业务编码
     *
     * @param: cfgDO
     * @param: itemList
     * @param: busiSerialDO
     * @return: busSerialnumNo
     * @date:  2018/11/20 20:50
     * @auther: CongZhiYuan
     */
    public String getBusiSerialNo(SSOUser user, SerialnumCfgDO cfgDO, List<SerialnumCfgItemDO> itemList, SerialnumDO busiSerialDO, String businessNo){
        StringBuffer busiSerialNo = new StringBuffer("");
        StringBuffer serialStr = new StringBuffer("");
        String snUuid = "";
        if(busiSerialDO==null){
            snUuid = idWorkerService.getId(new Date());
        }else{
            snUuid = busiSerialDO.getSnUuid();
        }
        if(businessNo==null){
            businessNo = "";
        }
        for(SerialnumCfgItemDO item:itemList){
            if(item.getSncdType().equals(SerialnumCfgType.DATE)){//日期类型格式化处理
                DateFormat df = new SimpleDateFormat(item.getSncdValue());
                busiSerialNo.append(df.format(new Date()));
            }else if(item.getSncdType().equals(SerialnumCfgType.TEXT)){//自定义文本直接拼接
                busiSerialNo.append(item.getSncdValue());
            }else if(item.getSncdType().equals(SerialnumCfgType.SYS)){//待用户信息完善再实现
                busiSerialNo.append(this.getSysCfgValue(item.getSncdValue(), user));
            }else if(item.getSncdType().equals(SerialnumCfgType.OLD)){//原业务编号
                busiSerialNo.append(businessNo);
            }else if(item.getSncdType().equals(SerialnumCfgType.N)){//解析当前序号
                int sncLength = cfgDO.getSncLength();
                int sncStep = cfgDO.getSncStep();
                String sncPeriod = cfgDO.getSncPeriod();
                /*if(busiSerialDO!=null&& !StringUtils.isEmpty(sncPeriod)){//超过周期，序号重新翻牌
                    DateFormat df = new SimpleDateFormat(sncPeriod);
                    int currTime = Integer.parseInt(df.format(new Date()));
                    int beginTime = Integer.parseInt(busiSerialDO.getSeqYmd());
                    if(currTime!=beginTime){
                        busiSerialDO.setSeqId((Integer.parseInt(cfgDO.getSncInitValue())-cfgDO.getSncStep().intValue())+"");
                        busiSerialDO.setSeqYmd(currTime+"");
                    }
                }
                int seqNo = cfgDO.getSncInitValue()==null?0:Integer.parseInt(cfgDO.getSncInitValue());
                if(busiSerialDO!=null){//系统中已含有业务序号信息
                    seqNo = Integer.parseInt(busiSerialDO.getSeqId());
                    seqNo = seqNo + sncStep;
                }*/
                //redis请求接口，获取业务序号
                String seqNo = idWorkerService.getBusinessNumber(snUuid, cfgDO.getSncInitValue(), sncStep+"", sncPeriod);

                for(int i=0;i<sncLength-(seqNo+"").length();i++){
                    serialStr.append("0");
                }
                serialStr.append(seqNo);
                busiSerialNo.append(serialStr.toString());
            }
            else{//无法匹配直接拼接
                busiSerialNo.append(item.getSncdValue());
            }
        }
        if(busiSerialDO==null){
            busiSerialDO = new SerialnumDO();
            BeanUtils.copyProperties(cfgDO, busiSerialDO);

//            String snUuid = new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date());
            busiSerialDO.setSnUuid(snUuid);
            if(!StringUtils.isEmpty(businessNo)){
                busiSerialDO.setBusUuid(businessNo);
            }
            /*busiSerialDO.setSeqId(serialStr.toString());
            if(cfgDO.getSncPeriod()!=null){
                DateFormat df = new SimpleDateFormat(cfgDO.getSncPeriod());
                busiSerialDO.setSeqYmd(df.format(new Date()));
            }*/
            serialnumDao.insertSerialnum(busiSerialDO);
        }/*else{//翻牌更新(采用redis生成序号后，不需要更新serialnum)
            busiSerialDO.setSeqId(serialStr.toString());
            serialnumDao.updateSerialnum(busiSerialDO);
        }*/
        return busiSerialNo.toString();
    }

    public String getSysCfgValue(String type, SSOUser user){
        String sysValue = "";
        switch (type){
            case SerialnumCfgType.JG1:
                if(user.getOrgCode().length()>=7){
                    sysValue = user.getOrgCode().substring(3,5);
                }else{
                    sysValue = type;
                }
                break;
            case SerialnumCfgType.JG2:
                if(user.getOrgCode().length()>=7){
                    sysValue = user.getOrgCode().substring(5,7);
                }else{
                    sysValue = type;
                }
                break;
            case SerialnumCfgType.BMBH:
                sysValue = user.getOrgCode();
                break;
            case SerialnumCfgType.UN:
                sysValue = user.getLoginName();
                break;
            case SerialnumCfgType.GH:
                sysValue = "";//未提供
                break;
        }
        return sysValue;
    }
}
