package edu.zut.cs.software.pro04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  自定义一个 Java 注解
 *  1. @Retention(RetentionPolicy.RUNTIME)
 *     运行时读取并处理注解信息
 *  2. @Target(ElementType.METHOD)
 *     自定义注解只能修饰方法
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CustomAnno {

}
