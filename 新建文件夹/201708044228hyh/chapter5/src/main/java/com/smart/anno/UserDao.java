package com.smart.anno;

import org.springframework.stereotype.Component;

/**
 * @Author:
 * @Description: 使用注解定义Bean @Component等同于<bean id="userDao" class="com.smart.anno.UserDao"/>
 * @Date:Created in 17:38 2019/4/29
 * @Modified By:
 */
@Component("userDao")
public class UserDao {
}
