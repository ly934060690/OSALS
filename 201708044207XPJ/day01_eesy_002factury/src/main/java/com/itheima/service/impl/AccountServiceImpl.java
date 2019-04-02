package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

/**
 * 账户的业务层实现
 */
public class AccountServiceImpl implements IAccountService {

    //private IAccountDao accountDao = new AccountDaoImpl();

    private IAccountDao accountDao =(IAccountDao) BeanFactory.getBean("accountDao");

//        private  int i = 1;  很少包含类成员变量

    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
