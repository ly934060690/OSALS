package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {


    public void saveAccount() {

        System.out.println("accountDao1创建成功"+'\n'+"accountDao1-账户保存成功！");
    }
}
