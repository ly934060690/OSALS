package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 *模拟一个工厂类（该类可能存在于jar包之中，我们无法通过修改源码的方式提供牧人构造函数）
 */
public class staticFactory {

    public static IAccountService getAccountService(){
        return  new AccountServiceImpl();
    }
}
