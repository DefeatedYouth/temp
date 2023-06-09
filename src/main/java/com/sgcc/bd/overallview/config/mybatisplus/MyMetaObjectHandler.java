package com.sgcc.bd.overallview.config.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 字段填充审计
 * @author Exrick
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

//        this.setFieldValByName("createBy", "", metaObject);
        this.setFieldValByName("createTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

//        this.setFieldValByName("updateTime", new Date(), metaObject);
//        this.setFieldValByName("updateBy", "", metaObject);
    }
}

