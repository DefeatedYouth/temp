package com.sgcc.bd.overallview.config.interceptor;

import com.sgcc.bd.overallview.config.properties.IgnoredUrlsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Exrickx
 */
@Configuration
@Slf4j
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Autowired
    private IgnoredUrlsProperties ignoredUrlsProperties;

    @Autowired
    private LimitRaterInterceptor limitRaterInterceptor;
    @Autowired
    private UserInfoInterceptor userInfoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(limitRaterInterceptor);
        // 配置拦截的路径
        ir.addPathPatterns("/**");
        // 配置不拦截的路径 避免加载css也拦截（可根据实际情况放开限流配置或拦截路径）
        ir.excludePathPatterns(ignoredUrlsProperties.getLimitUrls());

        // 注册拦截器
        InterceptorRegistration userInfoReg = registry.addInterceptor(userInfoInterceptor);
        // 配置拦截的路径
        userInfoReg.addPathPatterns("/**");
        // 配置不拦截的路径 避免加载css也拦截（可根据实际情况放开限流配置或拦截路径）
        userInfoReg.excludePathPatterns(ignoredUrlsProperties.getLimitUrls());
        userInfoReg.excludePathPatterns(ignoredUrlsProperties.getUrls());


    }

    /**
     * 使用此方法, 以下 spring-boot: jackson时间格式化 配置 将会失效
     * spring.jackson.time-zone=GMT+8
     * spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
     * 原因: 会覆盖 @EnableAutoConfiguration 关于 WebMvcAutoConfiguration 的配置
     * */
//     @Override
//     public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//             MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//             ObjectMapper objectMapper = converter.getObjectMapper();
//             // 生成JSON时,将所有Long转换成String
////             SimpleModule simpleModule = new SimpleModule();
////                 simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
////                 simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
////             objectMapper.registerModule(simpleModule);
//             // 时间格式化
//             objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//             objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//             // 设置格式化内容
//             converter.setObjectMapper(objectMapper);
//             converters.add(0, converter);
//         }
}
