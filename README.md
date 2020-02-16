# ucpass-spring-boot-starter

## 介绍
**ucpass能力封装，包括短信、语音**
## 环境

### sms-spring-boot-starter
#### JDK:1.8
#### Spring-Boot:2.2.4
#### Fastjson:1.2.61

## 使用方法

### 1.加入**sms-spring-boot-starter**短信依赖
### 2.编写配置
~~~yaml
ucpaassms-config:
  account-sid:  //这里填写平台获取的ID和KEY
  auth-token:   //这里填写平台获取的ID和KEY
  appid:        //这里填写平台获取的ID和KEY
~~~
### 3.编写测试类
~~~java
package com.eelve.ucpaassms.controller;

import com.eelve.sms.starter.SmsService;
import com.eelve.sms.starter.dto.SendSMSDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TDO
 * @Author zhao.zhilue
 * @Date 2020/2/16 12:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/sms")
public class TestController {

    @Autowired
    private SmsService smsService;

    @RequestMapping(value = "/sendsmsTest",method = RequestMethod.GET)
    public String sendsmsTest(){
        //创建传输类设置参数
        SendSMSDTO sendSMSDTO  = new SendSMSDTO();
        sendSMSDTO.setMobile("18888888888");     //手机号
        sendSMSDTO.setTemplateid("531705"); //模板
        sendSMSDTO.setParam("9623");      //参数
        return smsService.sendSMS(sendSMSDTO);
    }

}
~~~
