package com.eelve.sms.starter.enums;

import lombok.Getter;

/**
 * @author zhao.zhilue
 * @Description:  云之讯发送接口地址枚举
 * @date 2020/2/1612:01
 */
@Getter
public enum ENUM_SMSAPI_URL {
    /**
     * 单条发送调用地址
     */
    SENDSMS("https://open.ucpaas.com/ol/sms/sendsms"),
    /**
     * 批量发送调用地址
     */
    SENDBATCHSMS("https://open.ucpaas.com/ol/sms/sendsms_batch");
    private String url;
    ENUM_SMSAPI_URL(String url) {
        this.url = url;
    }
}
