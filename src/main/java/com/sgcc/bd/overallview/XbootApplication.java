package com.sgcc.bd.overallview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Exrickx
 */
@SpringBootApplication
//启用缓存
@EnableCaching
//启用异步
@EnableAsync
//启用自带定时任务
@EnableScheduling
public class XbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(XbootApplication.class, args);


    }
}
