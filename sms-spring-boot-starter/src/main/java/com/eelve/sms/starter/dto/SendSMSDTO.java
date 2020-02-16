package com.eelve.sms.starter.dto;

import lombok.Data;

/**
 * @ClassName SendSMSDTO
 * @Description TDO核心参数
 * @Author zhao.zhilue
 * @Date 2020/2/16 12:05
 * @Version 1.0
 **/
@Data
public class SendSMSDTO {
    /**
     * 模板ID
     */
    private String templateid;
    /**
     * 参数
     */
    private String param;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 用户穿透ID，可以为空
     */
    private String uid;
}
