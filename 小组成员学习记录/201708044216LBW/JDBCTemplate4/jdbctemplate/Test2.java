package com.itheima.jdbctemplate;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/19
 * @Description: com.itheima.jdbctemplate
 * @version: 1.0
 */
public class Test2
{
    public static void main(String[] args) {

        ApplicationContext atc = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = (JdbcTemplate) atc.getBean("jdbcTemplate");
        //保存
     //   jt.update("insert into account(name , money)values (? , ?)", "gxgx" , "2342434");

        //更新
     //   jt.update("update account set name = ? , money = ? where id = ? ", "lbw" , "5675675" , 4);
        //删除
      //  jt.update("delete from account where id = ?" , 112);

        //查询所有
        //List<Account> accounts = jt.query("select * from account where money > ?" ,new BeanPropertyRowMapper<Account>(Account.class), 234352);
        List<Account> accounts = jt.query("select * from account where money > ?" ,new AccountRowMapper(), 234352);
        for(Account account: accounts)
        {
            System.out.println(account);
        }
        //查询返回一行一列
        /**
         * 这里的第二个参数控制返回的参数
         */
       Integer i =  jt.queryForObject("SELECT count(*) from account where money > ?" ,Integer.class, 1000);
        System.out.println(i);
    }

}

/**
 * 定义封装策略   RowMapper里面有mapRow方法所以必须要实现这个方法
 */
class AccountRowMapper implements RowMapper<Account>
{

    /**
     * 把结构集中的数据封装到Account中，再由spring将每个account加到集合中
     * sping中的RowMapper可以将数据中的每一行数据封装成用户定义的类。
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();

        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}