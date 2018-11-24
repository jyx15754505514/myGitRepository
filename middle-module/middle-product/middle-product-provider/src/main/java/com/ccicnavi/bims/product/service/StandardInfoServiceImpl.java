package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.StandardInfoService;
import com.ccicnavi.bims.product.dao.StandardInfoDao;
import com.ccicnavi.bims.product.pojo.StandardInfoDO;
import com.ccicnavi.bims.product.pojo.StandardInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: bims-backend
 * @description:  产品线标准信息 ServiceImpl
 * @author: lvqiru
 * @create: 2018-11-21 20:00
 */
@Service
@Slf4j
public class StandardInfoServiceImpl implements StandardInfoService {

    @Autowired
    private StandardInfoDao standardInfoDao;

    @Override
    public Integer insertStandardInfo(StandardInfoDTO psiDto) {
        try {
            return standardInfoDao.insertStandardInfo(psiDto);
        } catch (Exception e) {
            log.error("保存产品标准信息异常");
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Integer deleteStandarInfo(StandardInfoDTO psiDto) {
        try {
            String stdUuids = psiDto.getStdUuid();
            if (!StringUtils.isEmpty(stdUuids)) {
                psiDto.setUuids(stdUuids.split("\\s+|,"));
                return standardInfoDao.deleteStandarInfo(psiDto);
            }
        } catch (Exception e) {
            log.error("移除产品标准信息异常");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer updateStandarInfo(StandardInfoDTO psiDto) {
        try {
            return standardInfoDao.updateStandarInfo(psiDto);
        } catch (Exception e) {
            log.error("修改产品标准信息异常");
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public StandardInfoDO getStandardInfo(StandardInfoDTO psiDto) {
        try {
            return standardInfoDao.getStandardInfo(psiDto);
        } catch (Exception e) {
            log.error("查询产品标准信息异常");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<StandardInfoDO> listStandardInfo(StandardInfoDTO psiDto) {
        try {
            return standardInfoDao.listStandardInfo(psiDto);
        } catch (Exception e) {
            log.error("查询产品标准信息列表异常");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PageBean<StandardInfoDO> listStandardInfoPage(PageParameter<StandardInfoDTO> pageParameter) {
        try {
            return standardInfoDao.listStandardInfoPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询产品信息异常");
            e.printStackTrace();
            return null;
        }
    }
}
