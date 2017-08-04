package com.pyb.DataSource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在方法上使用，用于指定使用哪个数据源
 */
@Documented  
@Retention(RetentionPolicy.RUNTIME)  
@Target({ ElementType.TYPE, ElementType.METHOD})   
public @interface TargetDataSource {
    String value();
}
