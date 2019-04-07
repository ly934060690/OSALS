package com.zcw.service.impl;

import com.zcw.service.AccountService;
import com.zcw.service.dao.AccountDao;
import com.zcw.service.factory.BeanFactory;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    //private AccountDao accountDao = new AccountServiceImpl();
    private AccountDao accountDao =(AccountDao) BeanFactory.getBean("accountDao");
    public void saveAccount() {

        accountDao.saveAccount();
    }
}
