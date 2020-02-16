package com.eelve.sms.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName SmsProperties
 * @Description TDO 自动配置的参数
 * @Author zhao.zhilue
 * @Date 2020/2/16 12:05
 * @Version 1.0
 **/
@Data
@ConfigurationProperties(prefix = "ucpaassms-config")
public class SmsProperties {
    private String appid;
    private String accountSid;
    private String authToken;
}
