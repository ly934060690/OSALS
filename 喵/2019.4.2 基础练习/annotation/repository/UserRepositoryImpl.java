package com.atguigu.spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * @Auther: LBW
 * @Date: 2019/4/2
 * @Description: com.atguigu.spring.beans.annotation.repository
 * @version: 1.0
 */
@Repository("userRepository" ) //相当于在bean中配置id
public class UserRepositoryImpl implements UserRepository
{
    @Override
    public void save()
    {
        System.out.println("UserRepository Save...");
    }
}
