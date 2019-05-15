package com.zcw.service.dao.impl.Account;

import com.zcw.service.dao.AccountDao;
import com.zcw.service.factory.BeanFactory;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements AccountDao {
//    private AccountDao accountDao = new AccountDaoImpl();
private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
