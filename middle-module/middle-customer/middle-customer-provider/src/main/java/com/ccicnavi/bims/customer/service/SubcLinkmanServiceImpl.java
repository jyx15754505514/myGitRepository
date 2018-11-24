package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.customer.api.SubcLinkmanService;
import com.ccicnavi.bims.customer.dao.SubLinkmanDao;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDO;
import com.ccicnavi.bims.customer.pojo.SubLinkmanDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 22:07
 * @Description:
 */
@Slf4j
public class SubcLinkmanServiceImpl implements SubcLinkmanService {
    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;

    @Autowired
    SubLinkmanDao subLinkmanDao ;
    /**
     * @Author FanDongSheng
     * @Description 分包联系人查询失败
     * @Date 22:11 2018/11/23
     * @Param [subcontractorDTO]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubLinkmanDO>
     */
    @Override
    public List<SubLinkmanDO> listSubcLinkman(SubcontractorDTO subcontractorDTO)  {
        List<SubLinkmanDO> listSubcLinkman = null;
        try {
            listSubcLinkman = subLinkmanDao.listSubLinkman(subcontractorDTO);
        } catch (Exception e) {
            log.error("查询分包联系人失败",e);
        }
        return listSubcLinkman;
    }
    /**
     * @Author FanDongSheng
     * @Description 分包方添加联系人
     * @Date 22:12 2018/11/23
     * @Param [subLinkman]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertSubcLinkman(SubLinkmanDO subLinkmanDO) {
        try {
            String linkmanUuid = idWorkerService.getId(new Date());
            subLinkmanDO.setLinkmanUuid(linkmanUuid);
            return subLinkmanDao.insertSubLinkman(subLinkmanDO,null);
        } catch (Exception e) {
            log.error("查询分包联系人添加失败",e);
        }
        return null;
    }
    /**
     * @Author FanDongSheng
     * @Description 分包方联系人删除 支持批量删除功能
     * @Date 22:15 2018/11/23
     * @Param [subLinkmanDTO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteSubcLinkman(SubLinkmanDTO subLinkmanDTO)  {
        try {
            return subLinkmanDao.deleteSubLinkman(subLinkmanDTO,null);
        } catch (Exception e) {
            log.error("删除分包方联系人信息",e);
        }
        return null;
    }
    /**
     * @Author FanDongSheng
     * @Description 更新分包方联系人信息
     * @Date 22:15 2018/11/23
     * @Param [subLinkman]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateSubcLinkman(SubLinkmanDO subLinkmanDO) {
        try {
            return subLinkmanDao.updateSubLinkman(subLinkmanDO,null);
        } catch (Exception e) {
            log.error("修改分包方联系人信息",e);
        }
        return null;
    }
    /**
     * @Author FanDongSheng
     * @Description 分包方指定联系人信息查看
     * @Date 22:18 2018/11/23
     * @Param [subLinkman]
     * @Return com.ccicnavi.bims.customer.pojo.SubLinkmanDO
     */
    @Override
    public SubLinkmanDO getSubcLinkman(SubLinkmanDO subLinkman) {
        try {
            return subLinkmanDao.getSubLinkman(subLinkman);
        } catch (Exception e) {
            log.error("分包方指定联系人信息查看",e);
        }
        return null;
    }
}
