package com.xiaojusurvey.engine.common.rpc;

import com.xiaojusurvey.engine.common.constant.RpcResultCode;
import com.xiaojusurvey.engine.common.exception.ExceptionDescriptor;
import lombok.Data;

import java.io.Serializable;

@Data
public class RpcResult<T> implements Serializable {

    private static final long serialVersionUID = -3324016200311008221L;

    private Integer code = -1;

    private String msg;

    private T data;

    private Boolean success;

    private ExceptionDescriptor exceptionDescriptor;

    public static <T> RpcResult<T> ok() {
        return new RpcResult(RpcResultCode.SUCCESS, "ok", null, true);
    }

    public static <T> RpcResult<T> ok(T data) {
        return new RpcResult(RpcResultCode.SUCCESS, "ok", data, true);
    }

    public static <T> RpcResult<T> fail(String msg, ExceptionDescriptor descriptor) {
        return new RpcResult(RpcResultCode.ERROR, msg, null, descriptor, false);
    }

    public static <T> RpcResult<T> fail(String msg) {
        return new RpcResult(RpcResultCode.ERROR, msg, null, false);
    }

    public static <T> RpcResult<T> fail(ExceptionDescriptor descriptor) {
        return new RpcResult(RpcResultCode.ERROR, descriptor != null ? descriptor.getInfo() : "服务端异常", null, descriptor, false);
    }

    public RpcResult() {
    }

    public RpcResult(int code, String msg, T data, Boolean success) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = success;
    }

    public RpcResult(int code, String msg, T data, ExceptionDescriptor exceptionDescriptor, Boolean success) {
        this(code, msg, data, success);
        this.exceptionDescriptor = exceptionDescriptor;
    }
}
