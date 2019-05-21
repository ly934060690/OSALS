package com.itheima.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
        jt.update("insert into account(name , money)values (? , ?)", "gxgx" , "2342434");

        //更新
        jt.update("update account set name = ? , money = ? where id = ? ", "lbw" , "5675675" , 4);
        //删除
        jt.update("delete from account where id = ?" , 112);



    }

}
