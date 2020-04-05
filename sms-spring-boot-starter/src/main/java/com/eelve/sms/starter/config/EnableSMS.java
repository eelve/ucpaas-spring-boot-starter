package com.eelve.sms.starter.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhao.zhilue
 * @Description: 启动短信配置
 * @date 2020/4/5 16:51
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SmsAutoConfiguration.class)
public @interface EnableSMS {

}
