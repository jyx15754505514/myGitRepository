package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.AreaDO;
import com.ccicnavi.bims.system.service.api.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * @Author MengZiJie
 * @Description 地区管理
 * @Date 9:16 2018/11/16
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    private final static Logger log = LoggerFactory.getLogger(AreaController.class);

    @Reference
    AreaService areaService;

    /**
     * @Author MengZiJie
     * @Description 查询地区
     * @Date 21:46 2018/11/15
     * @Param [areaDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/listArea",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listArea(@RequestBody AreaDO areaDO){
        List<AreaDO> areaDOS = null;
        try {
            areaDOS = areaService.listArea(areaDO);
            return ResultT.success(areaDOS);
        } catch (Exception e) {
            log.error("查询地区失败",e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * @Author MengZiJie
     * @Description 获取地区
     * @Date 10:12 2018/11/16
     * @Param [areaDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/getArea",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getArea(@RequestBody AreaDO areaDO){
        AreaDO areaDOS = null;
        try {
            areaDOS = areaService.getArea(areaDO);
            return ResultT.success(areaDOS);
        } catch (Exception e) {
            log.error("获取地区失败",e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /**
     * @Author MengZiJie
     * @Description 添加地区
     * @Date 10:25 2018/11/16
     * @Param [areaDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/insertArea",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertArea(@RequestBody AreaDO areaDO){
        try {
            Integer integer = areaService.insertArea(areaDO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("添加地区失败",e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * @Author MengZiJie
     * @Description 更新地区
     * @Date 10:27 2018/11/16
     * @Param [areaDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/updateArea",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateArea(@RequestBody AreaDO areaDO){
        try {
            Integer integer = areaService.updateArea(areaDO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("更新地区失败",e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
     * @Author MengZiJie
     * @Description 删除地区
     * @Date 10:28 2018/11/16
     * @Param [areaDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/deleteArea",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteArea(@RequestBody AreaDO areaDO){
        try {
            Integer integer = areaService.deleteArea(areaDO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("删除地区失败",e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

}
