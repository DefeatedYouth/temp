package com.sgcc.bd.overallview.config.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Exrickx
 */
@Configuration
@MapperScan({"cn.exrick.xboot.modules.*.dao"})
public class MybatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
//        page.setLimit(1000);
        page.setDbType(DbType.POSTGRE_SQL);
        return  page;
    }
}
