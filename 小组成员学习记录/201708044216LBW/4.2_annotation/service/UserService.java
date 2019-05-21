package com.atguigu.spring.beans.annotation.service;

import com.atguigu.spring.beans.annotation.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @Auther: LBW
 * @Date: 2019/4/2
 * @Description: com.atguigu.spring.beans.annotation.service
 * @version: 1.0
 */
@Service("userService") //相当于在bean中配置id
public class UserService
{
    private UserRepository userRepository;
    public void add()
    {
        System.out.println("UserService add...");
        userRepository.save();
    }
}
