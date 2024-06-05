package com.xiaojusurvey.engine.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * 异常信息封装
 */

@Component
public class ExceptionDescriptorBuilder {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionDescriptorBuilder.class);

    private String ipAddress;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${config.showExceptionMsg:true}")
    private boolean showExceptionMsg;

    public ExceptionDescriptorBuilder() {
        try {
            ipAddress = Inet4Address.getLocalHost()
                    .getHostAddress();
        } catch (UnknownHostException e) {
            logger.error("获取ip地址失败");
        }
    }

    public ExceptionDescriptor build(Exception ex) {
        if (!showExceptionMsg) return null;

        String traceId = null;
        try {
            traceId = MDC.get("traceId");
        } catch (Exception e) {

        }
        return ExceptionDescriptor.newFromException(ex, this.applicationName, this.ipAddress, ex.getMessage(), traceId);
    }
}
