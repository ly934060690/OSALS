package edu.zut.cs.lbw.test;

import edu.zut.cs.lbw.logistics.repository.DataBase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @Auther: LBW
 * @Date: 2019/4/3
 * @Description: com.logistics.lbw.test
 * @version: 1.0
 */
public class AppTest
{
    ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

    DataBase dataBase = null;

    {
        DataBase dataBase = (DataBase)ctx.getBean(DataSource.class);
    }

    @Test
    public void testDataBase()      //已经测试通过！！
    {
        dataBase.GoodsPrint();
    }
}
