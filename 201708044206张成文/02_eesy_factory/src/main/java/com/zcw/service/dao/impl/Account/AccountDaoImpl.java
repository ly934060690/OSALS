package com.zcw.service.dao.impl.Account;

import com.zcw.service.dao.AccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements AccountDao {
    private AccountDao accountDao = new AccountDaoImpl();
    public void savaAccount() {
        System.out.println("保存了账户");
    }
}
