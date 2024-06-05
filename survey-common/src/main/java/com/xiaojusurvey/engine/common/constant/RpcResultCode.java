package com.xiaojusurvey.engine.common.constant;

public class RpcResultCode {

    public static final Integer SUCCESS = 200;   // 成功
    public static final Integer ERROR = 500;   // 服务端异常

    public static final Integer AUTHENTICATION_FAILED = 1001;  // 未授权
    public static final Integer PARAMETER_ERROR = 1002;  // 参数有误
    public static final Integer NO_PERMISSION = 1003;  // 没有操作权限

    public static final Integer USER_EXISTS = 2001;  // 用户已存在
    public static final Integer USER_NOT_EXISTS = 2002;  // 用户不存在
    public static final Integer USER_PASSWORD_WRONG = 2003;  // 用户名或密码错误
    public static final Integer NO_SURVEY_PERMISSION = 3001;  // 没有问卷权限
    public static final Integer SURVEY_STATUS_TRANSFORM_ERROR = 3002;  // 问卷状态转换报错
    public static final Integer SURVEY_TYPE_ERROR = 3003;  // 问卷类型错误
    public static final Integer SURVEY_NOT_FOUND = 3004;  // 问卷不存在
    public static final Integer SURVEY_CONTENT_NOT_ALLOW = 3005;  // 存在禁用内容
    public static final Integer CAPTCHA_INCORRECT = 4001;  // 验证码不正确

    public static final Integer RESPONSE_SIGN_ERROR = 9001;  // 签名不正确
    public static final Integer RESPONSE_CURRENT_TIME_NOT_ALLOW = 9002;  // 当前时间不允许提交
    public static final Integer RESPONSE_OVER_LIMIT = 9003;  // 超出限制
    public static final Integer RESPONSE_SCHEMA_REMOVED = 9004;  // 问卷已删除
    public static final Integer RESPONSE_DATA_DECRYPT_ERROR = 9005;  // 问卷已删除

    public static final Integer UPLOAD_FILE_ERROR = 5001;  // 上传文件错误
}
