package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/19
 * @Description: com.itheima.dao.impl
 * @version: 1.0
 */
@Repository
public class IAccountDaoImpl2 implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Account FindAccountByid(Integer id) {
      List<Account> accounts = jdbcTemplate.query("SELECT * from account where id = ?" , new BeanPropertyRowMapper<Account>(Account.class) , id);
      if(accounts.isEmpty())
          return null;
      else
          return accounts.get(0);
    }

    public Account FindAccountByname(String name) {
        List<Account> accounts = jdbcTemplate.query("SELECT * from account where name = ?" , new BeanPropertyRowMapper<Account>(Account.class) , name);

        if(accounts.isEmpty())
            return null;
        if(accounts.size() > 1)
            throw  new RuntimeException("结果集不唯一");
        return accounts.get(0);
    }

    public void  UpdateAccount(Account account) {
        jdbcTemplate.update("update account set name =? , money = ? , id = ?", account.getName() , account.getMoney() , account.getId());
    }


}
