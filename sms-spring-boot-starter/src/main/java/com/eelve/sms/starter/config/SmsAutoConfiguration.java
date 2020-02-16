package com.eelve.sms.starter.config;

import com.eelve.sms.starter.SmsService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SmsAutoConfiguration
 * @Description TDO 短信自动配置类
 * @Author zhao.zhilue
 * @Date 2020/2/16 12:05
 * @Version 1.0
 **/
@Configuration  //注释使类成为bean的工厂
@EnableConfigurationProperties(SmsProperties.class) //使@ConfigurationProperties注解生效
public class SmsAutoConfiguration {
    @Bean
    public SmsService getBean(SmsProperties smsProperties){
        SmsService smsService = new SmsService(smsProperties);
        return smsService;
    }
}
