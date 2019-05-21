package com.zcw.service.ui;

import com.zcw.service.AccountService;
import com.zcw.service.dao.AccountDao;
import com.zcw.service.factory.BeanFactory;
import com.zcw.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //AccountService as = new AccountServiceImpl();
        AccountService as = (AccountService) BeanFactory.getBean("accountService");
        as.saveAccount();
    }

}
