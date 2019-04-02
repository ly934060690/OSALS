package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现
 */
public class AccountServiceImpl implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.age = age;
        this.name = name;
        this.birthday = birthday;
    }
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行\n"+"姓名: "+name+" 年龄:"+age+" 日期："+birthday);
    }
}
