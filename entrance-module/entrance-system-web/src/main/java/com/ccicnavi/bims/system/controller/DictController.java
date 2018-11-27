package com.ccicnavi.bims.system.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.Constants;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;
import com.ccicnavi.bims.system.service.api.DictTypeService;
import com.ccicnavi.bims.system.service.api.DictValueService;
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
 * @description: 数据字典
 * @author: LiJie
 * @create: 2018-11-26 22:28
 */
@RequestMapping(value = "/dict")
@RestController
public class DictController {

    private final static Logger log = LoggerFactory.getLogger(DictController.class);

    @Reference(timeout = 30000)
    private DictValueService dictValueService;

    @Reference(timeout = 30000)
    private DictTypeService dictTypeService;

    /**
     * @Author LiJie
     * @Description 根据数据字典的类型查询对应的值
     * @Date 21:57 2018/11/26
     * @Param [dictTypeDTO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/listDictValue", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listDict(@RequestBody DictTypeDTO dictTypeDTO) {
        try {
            if (!StringUtils.isEmpty(dictTypeDTO.getDictParentUuid())) {//确保传入了数据字典type的UUID
                dictTypeDTO.setPublicOrgUuid(Constants.PUBLIC_ORGUUID);//设置公共所属机构
                List<DictValueDO> dictTypeList = dictValueService.listDictValue(dictTypeDTO);
                if (!StringUtils.isEmpty(dictTypeList)) {
                    return ResultT.success(dictTypeList);
                }
            } else {
                ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
        } catch (Exception e) {
            log.error("根据字典类别编号查询字典信息失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


    /**
     * @Author LiJie
     * @Description 根据所属公司机构和产品线的ID查询其下的产品分类信息
     * @Date 21:57 2018/11/26
     * @Param [dictTypeDTO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/listDictType", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listDictType(@RequestBody DictTypeDTO dictTypeDTO) {
        try {
            //必传条件约束判断
            if (!StringUtils.isEmpty(dictTypeDTO.getOrgUuid()) && !StringUtils.isEmpty(dictTypeDTO.getProdCatalogUuid())) {
                dictTypeDTO.setPublicOrgUuid(Constants.PUBLIC_ORGUUID);//设置公共所属机构
                List<DictTypeDO> dictTypeList = dictTypeService.listDictType(dictTypeDTO);
                if (!StringUtils.isEmpty(dictTypeList)) {
                    return ResultT.success(dictTypeList);
                }
            } else {
                ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
        } catch (Exception e) {
            log.error("根据字典类别编号查询字典信息失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }



    /**
     * 新增数据字典数值
     *
     * @param dictValueDO
     * @return
     * @Author LiJie
     */
    @RequestMapping(value = "/insertDictValue", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertDictValue(@RequestBody DictValueDO dictValueDO) {
        try {
            Integer integer = dictValueService.insertDictValue(dictValueDO);
            if (integer > 0) {
                return ResultT.success("新增字典数值成功~");
            }
        } catch (Exception e) {
            log.error("新增字典数值失败", e);
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /**
     * @Description: 修改字典类型
     * @Param: [dictTypeDTO]
     * @return: com.ccicnavi.bims.common.ResultT
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    @RequestMapping(value = "/updateDictValue", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateDictValue(@RequestBody DictValueDO dictValueDO) {
        try {
            Integer integer = dictValueService.updateDictValue(dictValueDO);
            if (integer > 0) {
                return ResultT.success("修改字典类型成功~");
            }
        } catch (Exception e) {
            log.error("修改字典类型失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**
     * @Description: 删除字典数值
     * @Param: [dictTypeDTO]
     * @return: com.ccicnavi.bims.common.ResultT
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    @RequestMapping(value = "/deleteDictValue", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteDictType(@RequestBody DictTypeDTO dictTypeDTO) {
        try {
            if (!StringUtils.isEmpty(dictTypeDTO.getValueUuids())) {
                Integer count = dictTypeService.deleteDictType(dictTypeDTO);
                if (count > 0) {
                    return ResultT.success("删除字典数值成功~");
                }
            }
        } catch (Exception e) {
            log.error("删除字典数值失败", e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }

}
