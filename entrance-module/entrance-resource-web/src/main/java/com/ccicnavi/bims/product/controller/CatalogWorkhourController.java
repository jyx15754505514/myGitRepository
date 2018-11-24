package com.ccicnavi.bims.product.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CatalogWorkhourService;
import com.ccicnavi.bims.product.pojo.CatalogWorkhourDO;
import com.ccicnavi.bims.product.pojo.CatalogWorkhourDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-21 18:04
 */
@RestController
@RequestMapping("/catalogWorkhour")
public class CatalogWorkhourController {

    private final static Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Reference(timeout = 30000)
    CatalogWorkhourService catalogWorkhourService;


    /**
     * 查询全部产品线对应工时工资信息()
     *
     * @return
     */
    @RequestMapping(value = "/listAllCatalogWorkhour", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listAllCatalogWorkhour(@RequestBody CatalogWorkhourDO catalogWorkhour) {
        try {
            List<CatalogWorkhourDO> catalogWorkhourList = catalogWorkhourService.listCatalogWorkhour(catalogWorkhour);
            return ResultT.success(catalogWorkhourList);
        } catch (Exception e) {
            log.error("查询产品线对应工时工资信息失败~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


    /**
     * 分页查询产品线对应工时工资
     * @return
     */
    @RequestMapping(value = "/listCatalogWorkhourPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCatalogWorkhourPage(@RequestBody PageParameter<CatalogWorkhourDO> pageParameter) {
        try {
            PageBean<CatalogWorkhourDO> catalogWorkhourList = catalogWorkhourService.listCatalogWorkhourPage(pageParameter);
            return ResultT.success(catalogWorkhourList);
        } catch (Exception e) {
            log.error("根据父级ID查询出子级产品线对应工时工资~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


    /**
     * 根据主键查询对应产品线对应工时工资信息
     * @return
     */
    @RequestMapping(value = "/getCatalogWorkhour", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getCatalogWorkhour(@RequestBody CatalogWorkhourDO catalogWorkhourDO) {
        try {
            if (StringUtils.isEmpty(catalogWorkhourDO.getProdCatalogUuid())) {
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
            CatalogWorkhourDO catalogWorkhour = catalogWorkhourService.getCatalogWorkhour(catalogWorkhourDO);
            if (catalogWorkhour != null) {
                return ResultT.success(catalogWorkhour);
            }
        } catch (Exception e) {
            log.error("根据主键查询产品线对应工时工资失败", e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }


    /**
     * 保存产品线对应工时工资信息
     * @return
     */
    @RequestMapping(value = "/saveCatalogWorkhour", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveCatalogWorkhour(@RequestBody CatalogWorkhourDO catalogWorkhourDO) {
        try {
            Integer count = catalogWorkhourService.saveCatalogWorkhour(catalogWorkhourDO);
            if (count > 0) {
                return ResultT.success("新增产品线对应工时工资成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增产品线对应工时工资失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * 修改产品线对应工时工资信息
     * @return
     */
    @RequestMapping(value = "/updateCatalogWorkhour", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateCustomer(@RequestBody CatalogWorkhourDO catalogWorkhourDO) {
        try {
            Integer count = catalogWorkhourService.updateCatalogWorkhour(catalogWorkhourDO);
            if (count > 0) {
                return ResultT.success("修改产品线对应工时工资成功");
            } else {
                return ResultT.failure(ResultCode.UPDATE_FAILURE);
            }
        } catch (Exception e) {
            log.error("修改产品线对应工时工资失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }


    /**
     * 删除产品线对应工时工资信息
     *
     * @return
     */
    @RequestMapping(value = "/removeCatalogWorkhour", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT removeCatalogWorkhour(@RequestBody CatalogWorkhourDTO catalogWorkhourDTO) {
        try {
            if (StringUtils.isEmpty(catalogWorkhourDTO.getProdCatalogUuid())) {
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            } else {
                Integer count = catalogWorkhourService.removeCatalogWorkhour(catalogWorkhourDTO);
                if (count > 0) {
                    return ResultT.success("删除产品线对应工时工资成功");
                } else {
                    return ResultT.failure(ResultCode.DELETE_FAILURE);
                }
            }
        } catch (Exception e) {
            log.error("删除产品线对应工时工资信息失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }


}
