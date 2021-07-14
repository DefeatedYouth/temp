package com.sgcc.bd.overallview.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/4/25
 * @desc
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "applocal.currentuser")
public class DefaultUserProperties {
    String currentUserId = "deZhangguorongxxx";
    String currentAccount = "deZhangguorongxxx";
    String currentRealName = "deZhangguorongxxx";
    String currentOrgId = "deZhangguorongxxx";
    String currentOrgPath = "deZhangguorongxxx";
    String currentOrgName = "deZhangguorongxxx";
}
