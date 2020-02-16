package com.eelve.sms.starter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @ClassName RestTemplateConfig
 * @Description TDO RestTemplateConfig配置
 * @Author zhao.zhilue
 * @Date 2020/2/16 12:05
 * @Version 1.0
 **/
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate( ) {
        return new RestTemplate();
    }
}
