package com.itheima.service.impl;

import com.itheima.service.IAccountService;

/**
 * 账户的业务层实现
 */
public class AccountServiceImpl implements IAccountService {


    public AccountServiceImpl(){
        System.out.println("对象创建成功！");
    }
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行");
    }
}
