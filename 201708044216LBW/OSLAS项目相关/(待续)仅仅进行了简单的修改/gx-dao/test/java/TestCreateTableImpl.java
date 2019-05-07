import edu.zut.cs.software.dao.CreateTable;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: LBW
 * @Date: 2019/5/5
 * @Description: test
 * @version: 1.0
 */

public class TestCreateTableImpl
{
    ApplicationContext ctx = new AnnotationConfigApplicationContext("ApplicationContext.xml");
    CreateTable createTable = null;

    {
        CreateTable createTable = (CreateTable) ctx.getBean(CreateTable.class);
    }

    @Test
    public void testCreateTableImpl()     //测试已经通过但是仍无法解决找不到容器的问题
    {
        createTable.CreateTableByJDBC();
    }

}
