package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.MinItemService;
import com.ccicnavi.bims.product.dao.MinItemDao;
import com.ccicnavi.bims.product.pojo.MinItemDO;
import com.ccicnavi.bims.product.pojo.MinItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 最小服务项接口实现
 * @author: LiJie
 * @create: 2018-11-19 18:25
 */
@Service
@Slf4j
public class MinItemServiceImpl implements MinItemService {

    @Autowired
    MinItemDao minItemDao;


    @Override
    public List<MinItemDO> listMinItem(MinItemDTO minItemDTO) {
        try {
            return minItemDao.listMinItem(minItemDTO);
        } catch (Exception e) {
            log.error("查询最小服务项失败~", e);
            return null;
        }
    }

    @Override
    public int saveMinItem(MinItemDO minItem) {
        try {
            return minItemDao.saveMinItem(minItem);
        } catch (Exception e) {
            log.error("保存最小服务项失败~", e);
            return 0;
        }
    }

    @Override
    public int removeMinItem(MinItemDTO minItemDTO) {
        try {
            if (!StringUtils.isEmpty(minItemDTO.getMinItemUuid())) {
                minItemDTO.setUuids(minItemDTO.getMinItemUuid().split(","));
                return minItemDao.removeMinItem(minItemDTO);
            }
        } catch (Exception e) {
            log.error("删除最小服务项失败~", e);
        }
        return 0;
    }

    @Override
    public int updateMinItem(MinItemDO minItem) {
        try {
            return minItemDao.updateMinItem(minItem);
        } catch (Exception e) {
            log.error("修改最小服务项失败~", e);
            return 0;
        }
    }

    @Override
    public MinItemDO getMinItem(MinItemDO minItem) {
        try {
            return minItemDao.getMinItem(minItem);
        } catch (Exception e) {
            log.error("根据主键获取最小服务项失败~", e);
            return null;
        }
    }

    @Override
    public PageBean<MinItemDO> listMinItemPage(PageParameter<MinItemDTO> pageParameter) {
        try {
            return minItemDao.listMinItemPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询最小服务项失败~", e);
            return null;
        }
    }
}
