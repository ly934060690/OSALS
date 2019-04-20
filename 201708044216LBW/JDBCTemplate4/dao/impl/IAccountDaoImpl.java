package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/19
 * @Description: com.itheima.dao.impl
 * @version: 1.0
 */
public class IAccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    /*
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    */

    public Account FindAccountByid(Integer id) {
      List<Account> accounts = getJdbcTemplate().query("SELECT * from account where id = ?" , new BeanPropertyRowMapper<Account>(Account.class) , id);
      if(accounts.isEmpty())
          return null;
      else
          return accounts.get(0);
    }

    public Account FindAccountByname(String name) {
        List<Account> accounts = getJdbcTemplate().query("SELECT * from account where name = ?" , new BeanPropertyRowMapper<Account>(Account.class) , name);

        if(accounts.isEmpty())
            return null;
        if(accounts.size() > 1)
            throw  new RuntimeException("结果集不唯一");
        return accounts.get(0);
    }

    public void  UpdateAccount(Account account) {
        getJdbcTemplate().update("update account set name =? , money = ? , id = ?", account.getName() , account.getMoney() , account.getId());
    }

}
