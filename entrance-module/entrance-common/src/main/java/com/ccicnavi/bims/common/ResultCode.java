package com.ccicnavi.bims.common;
import java.util.ArrayList;
import java.util.List;


public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(1, "成功"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),

    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),
    SSO_LOGIN_FAILURE(20006, "SSO服务登录失败"),
    USER_LOGIN_FAILURE(20007, "用户登录失败"),
    USER_LOGIN_OUT(20008, "用户登录超时"),
    USER_NOT_LOGIN(20009, "用户未登录"),
    USER_CANT_ACCESS(20010, "无权限访问"),
    USER_NOT_INITIALPASSWORD(20011, "恢复初始密码失败"),
    USER_ALLOT_ROLE(20012, "分配角色失败"),
    USER_SAVE_USER(20013, "新建用户失败"),
    USER_LOGIN_EXCEPTION(20014, "SSO登录异常"),
    USER_LOGINOUT_EXCEPTION(20015, "SSO退出登录异常"),
    USER_LOGINCHECK_EXCEPTION(20016, "SSO教研登录异常"),
    USER_CHECKACCESS_EXCEPTION(20017, "SSO教研权限异常"),






    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题"),
    COLLECTION_OF_FAILURE(30002, "收藏失败"),
    COLLECTION_OF_SUCCESS(30003, "关注成功"),
    UNFOLLOW_OF_SUCCESS(30004, "取消关注成功"),
    COLLECTION_OF_EXCEPTION(30005, "关注异常"),
    INSERT_FUND_CONTRAST_FAILURE(30006, "添加对比基金失败"),
    FUND_CONTRAST_EXISTED(30007, "此对比基金已存在"),
    DELETE_FUND_CONTRAST_FAILURE(30008, "清除对比基金失败"),
    DELETE_PORTFOLIO_FUND_FAILURE(30009, "删除组合基金失败"),
    LIST_FAILURE(30010, "根据条件查询失败"),
    ADD_FAILURE(30011, "添加失败"),
    DELETE_FAILURE(30012, "删除失败"),
    UPDATE_FAILURE(30013, "修改失败"),
    GET_FAILURE(30014, "获取指定信息失败"),
    VERIFY_CUSTINFO_ONLY_FAILURE(30015,"客户相关信息唯一性验证失败"),
    CUST_NAME_REPEAT(30016,"客户名称重复"),
    CUST_CODE_REPEAT(30017,"客户代码重复"),
    CUST_USCC_REPEAT(30018,"客户统一社会信用代码重复"),

    SERIAL_CFG_GET_FAILURE(30018, "查询业务规则信息出错"),
    SERIAL_CFG_ADD_FAILURE(30019, "添加业务规则信息出错"),
    SERIAL_CFG_MODIFY_FAILURE(30020, "修改业务规则信息出错"),
    SERIAL_CFG_REMOVE_FAILURE(30021, "删除业务规则信息出错"),
    RENEW_FAILURE(30022, "更新失败"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),

    /* 数据错误：50001-599999 */
    RESULE_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001, "无访问权限");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

    //校验重复的code值
    public static void main(String[] args) {
        ResultCode[] ApiResultCodes = ResultCode.values();
        List<Integer> codeList = new ArrayList<Integer>();
        for (ResultCode ApiResultCode : ApiResultCodes) {
            if (codeList.contains(ApiResultCode.code)) {
                System.out.println(ApiResultCode.code);
            } else {
                codeList.add(ApiResultCode.code());
            }
        }
    }
}