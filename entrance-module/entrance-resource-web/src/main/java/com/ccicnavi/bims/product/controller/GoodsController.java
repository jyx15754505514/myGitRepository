package com.ccicnavi.bims.product.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.GoodsService;
import com.ccicnavi.bims.product.pojo.GoodsDO;
import com.ccicnavi.bims.product.pojo.GoodsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description: 商品信息
 * @author: guojinxu
 * @create: 2018/11/22 20:03
 */
@Slf4j
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Reference(timeout = 30000)
    GoodsService goodsService;
    @Reference(timeout = 30000)
    IdWorkerService idWorkerService;

    /**
     * @Author guojinxu
     * @Description 查询商品信息
     * @Date 2018/11/22 20:09
     * @Param [goodsDO]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/listGoodsDO",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listGoodsDO(@RequestBody GoodsDO goodsDO){
        log.info("查询商品信息 入参 goodsDO={}", JSON.toJSONString(goodsDO));
        try {
            List<GoodsDO> goodsDOList = goodsService.listGoodsDO(goodsDO);
            return ResultT.success(goodsDOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * @Author guojinxu
     * @Description 添加商品信息
     * @Date 2018/11/22 20:11
     * @Param [goodsDO]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/saveGoodsDO",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveGoodsDO(@RequestBody GoodsDO goodsDO){
        goodsDO.setGoodsUuid(idWorkerService.getId(new Date()));
        log.info("添加商品信息 入参 goodsDO={}", JSON.toJSONString(goodsDO));
        try {
            int count = goodsService.saveGoodsDO(goodsDO);
            return ResultT.success(count);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * @Author guojinxu
     * @Description 删除商品信息
     * @Date 2018/11/22 20:14
     * @Param [goodsDO]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/removeGoodsDO",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT removeGoodsDO(@RequestBody GoodsDTO goodsDTO){
        log.info("删除商品信息 入参 goodsDTO={}", JSON.toJSONString(goodsDTO));
        try {
            int count = goodsService.removeGoodsDO(goodsDTO);
            return ResultT.success(count);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /**
     * @Author guojinxu
     * @Description 修改商品信息
     * @Date 2018/11/22 20:17
     * @Param [goodsDO]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/updateGoodsDO",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateGoodsDO(@RequestBody GoodsDO goodsDO){
        log.info("修改商品信息 入参 goodsDO={}", JSON.toJSONString(goodsDO));
        try {
            int count = goodsService.updateGoodsDO(goodsDO);
            return ResultT.success(count);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
     * @Author guojinxu
     * @Description 根据主键查询商品信息
     * @Date 2018/11/23 10:00
     * @Param [goodsDO]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/getGoodsDO",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getGoodsDO(@RequestBody GoodsDO goodsDO){
        log.info("根据主键查询商品信息 入参 goodsDO={}", JSON.toJSONString(goodsDO));
        try {
            GoodsDO goodsDO1 = goodsService.getGoodsDO(goodsDO);
            return ResultT.success(goodsDO1);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /**
     * @Author guojinxu
     * @Description 分页查询商品信息
     * @Date 2018/11/23 10:07
     * @Param [goodsDOPageParameter]
     * @return com.ccicnavi.bims.common.ResultT
     **/
   @RequestMapping(value = "/listGoodsPage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
   public ResultT listGoodsPage(@RequestBody PageParameter<GoodsDO> goodsDOPageParameter){
        log.info("分页查询商品信息 入参 goodsDOPageParameter={}",JSON.toJSONString(goodsDOPageParameter));
       try {
           PageBean<GoodsDO> goodsDOPageBean = goodsService.listGoodsPage(goodsDOPageParameter);
           return ResultT.success(goodsDOPageBean);
       } catch (Exception e) {
           e.printStackTrace();
           return ResultT.failure(ResultCode.LIST_FAILURE);
       }
   }

}
