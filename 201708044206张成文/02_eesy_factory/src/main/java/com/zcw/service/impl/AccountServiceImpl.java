package com.zcw.service.impl;

import com.zcw.service.AccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountService accountDao = new AccountServiceImpl();
    public void saveAccount() {

        accountDao.saveAccount();
    }
}
