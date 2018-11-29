package com.ccicnavi.bims.common.service.com.ccicnavi.bims.common;
/*
*@Param:
*@description: 该类的作用描述
*@return: 
*@author: WangGengXiang
*@create: 2018/11/29 15:39
*/
public class ConstantMiddleCode {

    //委托单--未提交
    public static  String ORDER_FORM_NOT_SUBMITTED = "0";
    //委托单--待评审
    public static  String ORDER_FORM_PENDING_REVIEW = "5";
    //委托单--已评审
    public static  String ORDER_FORM_REVIEWED = "10";
    //委托单--已作废
    public static  String ORDER_FORM_INVALID = "15";

    //开工单--待开工
    public static  String WORK_ORDER_TO_BE_STARTED = "0";
    //开工单--已开工
    public static  String WORK_ORDER_ALREADY_STARTED = "5";

    //派单分包--待派工
    public static  String DISPATCH_SUBCONTRACT_DISPATCHED_WORKER = "0";
    //派单分包--已派单
    public static  String DISPATCH_SUBCONTRACT_SENT_LIST = "5";
    //派单分包--终止
    public static  String DISPATCH_SUBCONTRACT_TERMINATION = "10";

    //服务实施--待开工
    public static  String SERVICE_IMPLEMENTATION_TO_BE_STARTED = "0";
    //服务实施--开工中
    public static  String SERVICE_IMPLEMENTATION_START_UP = "5";
    //服务实施--已完工
    public static  String SERVICE_IMPLEMENTATION_COMPLETED = "10";
    //服务实施--终止
    public static  String SERVICE_IMPLEMENTATION_TERMINATION = "15";

    //证书管理--未出证
    public static  String CERTIFICATE_MANAGEMENT_NO_EVIDENCE = "0";
    //证书管理--出证中
    public static  String CERTIFICATE_MANAGEMENT_OUT_OF_EVIDENCE = "5";
    //证书管理--已出证
    public static  String CERTIFICATE_MANAGEMENT_EVIDENCE_HAS_BEEN_ISSUED = "10";


}
