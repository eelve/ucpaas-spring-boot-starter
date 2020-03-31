# ucpass-spring-boot-starter

## 介绍
[云之讯](https://office.ucpaas.com/about/index.html)，**ucpass能力封装，包括短信、语音**
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
        sendSMSDTO.setTemplateid("55555"); //模板
        sendSMSDTO.setParam("9999");      //参数
        return smsService.sendSMS(sendSMSDTO);
    }

}
~~~
## Tips
在引入自己封装的Starter的时候,有的人会报错****类的bean没有找到问题,是因为@SpringBootApplication扫描包的范围是启动类所在同级包和子包,但是不包括第三方的jar包.如果需要扫描maven依赖添加的Jar,我们就要单独使用@ComponentScan注解扫描包.
针对这种情况解决方式有两种:

第一种:是你封装的Starter项目下父级包名称和测试项目的父级包名一样,例如这两个项目包名都叫com.eelve,这样可以不使用@ComponentScan注解,很显然这样做有局限性,不推荐.

第二种:是可以单独使用@ComponentScan注解扫描第三方包,但是这里一定要注意@SpringBootApplication注解等价于默认属性使用@Configuration+@EnableAutoConfiguration+@ComponentScan,如果@SpringBootApplication和@ComponentScan注解同时存在，那么@SpringBootApplication注解中@ComponentScan的扫描范围会被覆盖,所以单独使用@ComponentScan的话,必须在该注解上配置项目需要扫描的包的所有范围,即项目包路径+依赖包路径.
~~~yaml
/**
 * @ComponentScan注解扫描多个包下示例
 */
@ComponentScan({"com.test","sms.test"})
~~~

# License
Released under the [MIT](LICENSE) License.

