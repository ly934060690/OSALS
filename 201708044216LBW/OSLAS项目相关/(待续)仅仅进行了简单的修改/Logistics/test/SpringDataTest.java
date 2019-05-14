import edu.zut.cs.software.dao.GoodDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Auther: LBW
 * @Date: 2019/5/14
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class SpringDataTest {

    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

    DataSource dataSource = null;
    GoodDao goodDao = null;
    {
        goodDao = (GoodDao) ctx.getBean(GoodDao.class);
    }


    @Test
    public void TestConnection() throws SQLException
    {
        dataSource = (DataSource) ctx.getBean(DataSource.class);
        dataSource.getConnection();
    }

    @Test
    public void TestJparepository()
    {
        goodDao.findByGoodId("1010");
    }

}
