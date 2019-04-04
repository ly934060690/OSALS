package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public class AccountDao implements IAccountDao {

    private QueryRunner runner;

    public AccountDao(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllAccount() {
        return null;
    }

    public Account findAccountById(Integer accountId) {
        return null;
    }

    public void saveAccount(Account account) {

    }

    public void updateAccount(Account account) {

    }

    public void deleteAccount(Integer accountId) {

    }
}
