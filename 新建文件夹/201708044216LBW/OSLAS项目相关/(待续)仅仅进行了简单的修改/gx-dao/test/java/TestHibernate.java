/**
 * @Auther: LBW
 * @Date: 2019/5/6
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */

import edu.zut.cs.software.domian.Good;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class TestHibernate
{

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        //创建配置对象
        Configuration config = new Configuration().configure();
        /*
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config .getProperties()).build();
        */
        //创建会话工厂对象
        sessionFactory = config.buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();

    }
    /*
    @After
    public void destory() {
        transaction.commit(); //提交事务
        session.close(); //关闭会话
        sessionFactory.close(); //关闭会话工厂
    }
    */

    @Test
    public void testSaveStudents() {

        Good g = new Good("1" , "牛仔裤" , 200);
        session.save(g); //保存对象进入数据库
    }
}