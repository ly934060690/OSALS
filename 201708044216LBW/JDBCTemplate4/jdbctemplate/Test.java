package com.itheima.jdbctemplate;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: LBW
 * @Date: 2019/4/19
 * @Description: com.itheima.jdbctemplate
 * @version: 1.0
 */
public class Test
{
    public static void main(String[] args)
    {

        ApplicationContext atc = new ClassPathXmlApplicationContext("bean.xml");

        IAccountDao accountDao = (IAccountDao) atc.getBean("accountDao");


        Account account = accountDao.FindAccountByid(1);
        System.out.println(account);

        Account account1 = accountDao.FindAccountByname("gx");
        System.out.println(account1);


    }

}
