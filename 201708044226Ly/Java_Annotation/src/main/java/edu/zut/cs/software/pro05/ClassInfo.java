package edu.zut.cs.software.pro05;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//可以得知这个注解会一直存在，也就是在程序运行中时候，这个注解还是有效的；
@Target(ElementType.TYPE)
//说明ClassInfo注解的是作用于类、接口或enum声明的；
@Documented
//说明ClassInfo信息可以被写入Javadoc文档中;
public @interface ClassInfo {
    String author() default "ly";
    String date();
    String comments();
}
