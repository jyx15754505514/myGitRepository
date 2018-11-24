package com.ccicnavi.bims.product.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.StandardInfoService;
import com.ccicnavi.bims.product.pojo.StandardInfoDO;
import com.ccicnavi.bims.product.pojo.StandardInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品标准信息管理
 * @author: lvqiru
 * @create: 2018-11-21 20:00
 */
@RestController
@RequestMapping("/productStandardInfo")
@Slf4j
public class ProductStandardInfoController {

    @Reference(timeout = 30000)
    private StandardInfoService standardInfoService;

    /**
     * 保存产品标准信息
     * @Author lvqiru
     * @Date  2018/11/21 20:00
     * @Param [StandardInfoDTO]   封装请求参数的实体对象
     * @return com.ccicnavi.bims.common.ResultT   返回的结果类
     **/
    @RequestMapping(value = "saveStandardInfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveStandardInfo(@RequestBody StandardInfoDTO psiDto){
        log.info("开始保存产品标准信息 Param: " + JSON.toJSONString(psiDto) + " Time: " + new Date());
        try {
            Integer count = standardInfoService.insertStandardInfo(psiDto);
            if (count > 0) {
                log.info("保存产品标准信息结果: " + "新增数据条数 " + count);
                return ResultT.success("保存数据成功");
            } else {
                log.error("保存产品标准信息异常");
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("保存产品标准信息异常");
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * 移除产品标准信息
     * @Author lvqiru
     * @Date  2018/11/21 20:00
     * @Param [StandardInfoDTO]   封装请求参数的实体对象
     * @return com.ccicnavi.bims.common.ResultT   返回的结果类
     **/
    @RequestMapping(value = "removeStandardInfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT removeStandardInfo(@RequestBody StandardInfoDTO psiDto){
        log.info("开始移除产品标准信息 Param: " + JSON.toJSONString(psiDto) + " Time: " + new Date());
        try {
            Integer count = standardInfoService.deleteStandarInfo(psiDto);
            if (count > 0) {
                log.info("移除产品标准信息结果: " + "移除数据条数 " + count);
                return ResultT.success("移除数据成功");
            } else {
                log.error("移除产品标准信息异常");
                return ResultT.failure(ResultCode.DELETE_FAILURE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("移除产品标准信息异常");
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /**
     * 修改产品标准信息
     * @Author lvqiru
     * @Date  2018/11/21 20:00
     * @Param [StandardInfoDTO]   封装请求参数的实体对象
     * @return com.ccicnavi.bims.common.ResultT   返回的结果类
     **/
    @RequestMapping(value = "updateStandardInfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateStandardInfo(@RequestBody StandardInfoDTO psiDto){
        log.info("开始修改产品标准信息 Param: " + JSON.toJSONString(psiDto) + " Time: " + new Date());
        try {
            Integer count = standardInfoService.updateStandarInfo(psiDto);
            if (count > 0) {
                log.info("修改产品标准信息结果: " + "修改数据条数 " + count);
                return ResultT.success("修改数据成功");
            } else {
                log.error("修改产品标准信息异常");
                return ResultT.failure(ResultCode.UPDATE_FAILURE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("修改产品标准信息异常");
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
     * 查询产品标准信息
     * @Author lvqiru
     * @Date  2018/11/21 20:00
     * @Param [StandardInfoDTO]   封装请求参数的实体对象
     * @return com.ccicnavi.bims.common.ResultT   返回的结果类
     **/
    @RequestMapping(value = "getStandardInfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getStandardInfo(@RequestBody StandardInfoDTO psiDto){
        log.info("开始查询产品标准信息 Param: " + JSON.toJSONString(psiDto) + " Time: " + new Date());
        try {
            StandardInfoDO standardInfoDo = standardInfoService.getStandardInfo(psiDto);
            if (null == standardInfoDo) {
                log.error("查询产品标准信息异常");
                return ResultT.failure(ResultCode.GET_FAILURE);
            }
            log.info("查询产品标准信息结果: " + JSON.toJSONString(psiDto));
            return ResultT.success(standardInfoDo);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询产品标准信息异常");
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /**
     * 查询产品标准信息列表
     * @Author lvqiru
     * @Date  2018/11/21 20:00
     * @Param [StandardInfoDTO]   封装请求参数的实体对象
     * @return com.ccicnavi.bims.common.ResultT   返回的结果类
     **/
    @RequestMapping(value = "listStandardInfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listStandardInfo(@RequestBody StandardInfoDTO psiDto){
        log.info("开始查询产品标准信息列表 Param: " + JSON.toJSONString(psiDto) + " Time: " + new Date());
        try {
            List<StandardInfoDO> productStandardInfoList = standardInfoService.listStandardInfo(psiDto);
            if (null == productStandardInfoList) {
                log.error("查询产品标准信息列表异常");
                return ResultT.failure(ResultCode.LIST_FAILURE);
            }
            log.info("查询产品标准信息列表结果: " + JSON.toJSONString(productStandardInfoList));
            return ResultT.success(productStandardInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询产品标准信息列表异常");
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * 分页查询产品标准信息
     * @Author lvqiru
     * @Date  2018/11/21 20:00
     * @Param [StandardInfoDTO]   封装请求参数的实体对象
     * @return com.ccicnavi.bims.common.ResultT   返回的结果类
     **/
    @RequestMapping(value = "pageStandardInfo",method = RequestMethod.POST)
    public ResultT pageStandardInfo(@RequestBody PageParameter<StandardInfoDTO> pageParameter){
        log.info("开始分页查询产品标准信息 Param: " + pageParameter.getParameter() + " Time: " + new Date());
        try {
            PageBean<StandardInfoDO> productStandardInfoList = standardInfoService.listStandardInfoPage(pageParameter);
            log.info("分页查询产品标准信息结果: " + JSON.toJSONString(productStandardInfoList));
            return ResultT.success(productStandardInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("分页查询产品标准信息异常");
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }
}
