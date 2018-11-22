package com.ccicnavi.bims.product.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.MinItemService;
import com.ccicnavi.bims.product.api.MinItemStdService;
import com.ccicnavi.bims.product.api.MinItemTestService;
import com.ccicnavi.bims.product.pojo.*;
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
 * @description: 最小服务项管理
 * @author: LiJie
 * @create: 2018-11-21 16:31
 */
@RestController
@RequestMapping("/minItem")
public class MinItemController {


    private final static Logger log = LoggerFactory.getLogger(MinItemController.class);

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20884")
    MinItemService minItemService;

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20884")
    MinItemStdService minItemStdService;

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20884")
    MinItemTestService minItemTestService;

    /**
     * 查询全部最小服务项信息()
     *
     * @return
     */
    @RequestMapping(value = "/listAllMinItem", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listAllMinItem(@RequestBody MinItemDO minItem) {
        try {
            List<MinItemDO> CustInvoiceList = minItemService.listMinItem(minItem);
            return ResultT.success(CustInvoiceList);
        } catch (Exception e) {
            log.error("查询最小服务项信息失败~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


    /**
     * 分页查询最小服务项
     *
     * @return
     */
    @RequestMapping(value = "/listMinItemPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listMinItemPage(@RequestBody PageParameter<MinItemDO> pageParameter) {
        try {
            PageBean<MinItemDO> minItemList = minItemService.listMinItemPage(pageParameter);
            return ResultT.success(minItemList);
        } catch (Exception e) {
            log.error("根据父级ID查询出子级最小服务项~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


    /**
     * 根据主键查询对应最小服务项信息
     *
     * @return
     */
    @RequestMapping(value = "/getMinItem", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getMinItem(@RequestBody MinItemDO minItemDO) {
        try {
            if (StringUtils.isEmpty(minItemDO.getMinItemUuid())) {
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
            MinItemDO minItem = minItemService.getMinItem(minItemDO);
            if (minItem != null) {
                return ResultT.success(minItem);
            }
        } catch (Exception e) {
            log.error("根据主键查询最小服务项失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


    /**
     * 保存最小服务项信息
     *
     * @return
     */
    @RequestMapping(value = "/saveMinItem", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveMinItem(@RequestBody MinItemDO minItemDO) {
        try {
            Integer count = minItemService.saveMinItem(minItemDO);
            if (count > 0) {
                return ResultT.success("新增最小服务项成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增最小服务项失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * 修改最小服务项信息
     *
     * @return
     */
    @RequestMapping(value = "/updateMinItem", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateCustomer(@RequestBody MinItemDO minItemDO) {
        try {
            Integer count = minItemService.updateMinItem(minItemDO);
            if (count > 0) {
                return ResultT.success("修改最小服务项成功");
            } else {
                return ResultT.failure(ResultCode.UPDATE_FAILURE);
            }
        } catch (Exception e) {
            log.error("修改最小服务项失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }


    /**
     * 删除最小服务项信息
     *
     * @return
     */
    @RequestMapping(value = "/removeMinItem", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT removeMinItem(@RequestBody MinItemDTO minItemDTO) {
        try {
            if (StringUtils.isEmpty(minItemDTO.getMinItemUuid())) {
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            } else {
                Integer count = minItemService.removeMinItem(minItemDTO);
                if (count > 0) {
                    return ResultT.success("删除最小服务项成功");
                } else {
                    return ResultT.failure(ResultCode.DELETE_FAILURE);
                }
            }
        } catch (Exception e) {
            log.error("删除最小服务项信息失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /***
     * ——————————————最小服务项与标准关系服务管理——————————————
     */
    /**
     * 保存最小服务项与标准关系信息
     *
     * @return
     */
    @RequestMapping(value = "/saveMinItemStd", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveMinItemStd(@RequestBody MinItemStdDO minItemStdDO) {
        try {
            Integer count = minItemStdService.saveMinItemStd(minItemStdDO);
            if (count > 0) {
                return ResultT.success("新增最小服务项与标准关系成功~");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增最小服务项与标准关系失败~", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * 删除最小服务项与标准关系信息
     *
     * @return
     */
    @RequestMapping(value = "/removeMinItemStd", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT removeMinItemStd(@RequestBody MinItemStdDO minItemStdDO) {
        try {
            Integer count = minItemStdService.removeMinItemStd(minItemStdDO);
            if (count > 0) {
                return ResultT.success("删除最小服务项与标准关系成功~");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("删除最小服务项与标准关系失败~", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }


    /***
     * ——————————————最小服务项与检测指标关系服务管理——————————————
     */
    /**
     * 保存最小服务项与检测指标关系信息
     *
     * @return
     */
    @RequestMapping(value = "/saveMinItemTest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveMinItemTest(@RequestBody MinItemTestDO minItemTestDO) {
        try {
            Integer count = minItemTestService.saveMinItemTest(minItemTestDO);
            if (count > 0) {
                return ResultT.success("新增最小服务项与检测指标关系成功~");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增最小服务项与检测指标关系失败~", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * 删除最小服务项与检测指标关系信息
     *
     * @return
     */
    @RequestMapping(value = "/removeMinItemTest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT removeMinItemTest(@RequestBody MinItemTestDO minItemTestDO) {
        try {
            Integer count = minItemTestService.removeMinItemTest(minItemTestDO);
            if (count > 0) {
                return ResultT.success("删除最小服务项与检测指标关系成功~");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("删除最小服务项与检测指标关系失败~", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * 根据最小服务项ID和所属机构ID查询出对应的检测指标信息
     *
     * @return
     */
    @RequestMapping(value = "/findTestItemByMinItemUuid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT findTestItemByMinItemUuid(@RequestBody MinItemTestDO minItemTestDO) {
        try {
            List<TestItemDO> testItemByMinItemUuid = minItemTestService.findTestItemByMinItemUuid(minItemTestDO);
            return ResultT.success(testItemByMinItemUuid);
        } catch (Exception e) {
            log.error("根据最小服务项ID和所属机构ID查询出对应的检测指标信息失败~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


}
