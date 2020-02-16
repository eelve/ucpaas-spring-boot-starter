package com.eelve.sms.starter;

import com.alibaba.fastjson.JSONObject;
import com.eelve.sms.starter.config.SmsProperties;
import com.eelve.sms.starter.enums.ENUM_SMSAPI_URL;
import com.eelve.sms.starter.dto.SendSMSDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName SmsService
 * @Description TDO 短信核心配置类
 * @Author zhao.zhilue
 * @Date 2020/2/16 12:02
 * @Version 1.0
 **/
public class SmsService {

    @Autowired
    private RestTemplate restTemplate;
    private String appid;
    private String accountSid;
    private String authToken;


    /**
     * 初始化
     */
    public SmsService(SmsProperties smsProperties) {
       this.appid = smsProperties.getAppid();
       this.accountSid = smsProperties.getAccountSid();
       this.authToken = smsProperties.getAuthToken();
    }

    /**
     * 单独发送
     */
    public String sendSMS(SendSMSDTO sendSMSDTO){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", accountSid);
        jsonObject.put("token", authToken);
        jsonObject.put("appid", appid);
        jsonObject.put("templateid", sendSMSDTO.getTemplateid());
        jsonObject.put("param", sendSMSDTO.getParam());
        jsonObject.put("mobile", sendSMSDTO.getMobile());
        if (sendSMSDTO.getUid()!=null){
            jsonObject.put("uid",sendSMSDTO.getUid());
        }else {
            jsonObject.put("uid","");
        }
        String json = JSONObject.toJSONString(jsonObject);
        //使用restTemplate进行访问远程Http服务
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
        String result = restTemplate.postForObject(ENUM_SMSAPI_URL.SENDSMS.getUrl(), httpEntity, String.class);
        return result;
    }

    /**
     * 群体发送
     */
    public String sendBatchSMS(SendSMSDTO sendSMSDTO){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", accountSid);
        jsonObject.put("token", authToken);
        jsonObject.put("appid", appid);
        jsonObject.put("templateid", sendSMSDTO.getTemplateid());
        jsonObject.put("param", sendSMSDTO.getParam());
        jsonObject.put("mobile", sendSMSDTO.getMobile());
        if (sendSMSDTO.getUid()!=null){
            jsonObject.put("uid",sendSMSDTO.getUid());
        }else {
            jsonObject.put("uid","");
        }
        String json = JSONObject.toJSONString(jsonObject);
        //使用restTemplate进行访问远程Http服务
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
        String result = restTemplate.postForObject(ENUM_SMSAPI_URL.SENDBATCHSMS.getUrl(), httpEntity, String.class);
        return result;
    }
}
