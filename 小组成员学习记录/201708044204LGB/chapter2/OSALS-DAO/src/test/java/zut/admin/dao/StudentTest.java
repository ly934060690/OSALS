package zut.admin.dao;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;
import java.sql.SQLException;
//Configuration("classpath:applicationContextTest-resources.xml")
@ContextConfiguration(locations = "classpath:applicationContextTest-resources.xml")
public class StudentTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void  TestJparepository()
    {
        studentDao.findByNumber(5);
        //System.out.println(good);
    }

}
