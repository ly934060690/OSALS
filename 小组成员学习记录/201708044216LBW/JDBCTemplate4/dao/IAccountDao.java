package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * @Auther: LBW
 * @Date: 2019/4/19
 * @Description: com.itheima.dao
 * @version: 1.0
 */
public interface IAccountDao {

    Account FindAccountByid(Integer id);

    Account FindAccountByname(String name);

    void UpdateAccount(Account account);


}
