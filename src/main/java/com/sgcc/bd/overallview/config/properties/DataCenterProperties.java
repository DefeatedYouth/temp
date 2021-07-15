package com.sgcc.bd.overallview.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/7/15
 * @desc
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "datacenter.businessapi")
public class DataCenterProperties {
    //开发环境：pms.pms30dev.com.cn 测试环境 http://dwzyzt.cloudjs.dev.com.cn
     String getway;
     String appId;
     String appSecret;
     String accessToken;

}
