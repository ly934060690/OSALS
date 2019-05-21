package zut.edu.cs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import zut.edu.cs.dao.Customer;


public class HibernateDem1 {

    @Test
    public void Demo1(){
        //1.加载Hinernate的核心配置文件hibernate.cgf.xml
        Configuration configuration = new Configuration().configure();
            //此处可以手动加载映射文件
            //configuration.addResource("hibernate.hbm.xml");
        //2.创建一个SessionFactory对象，类似JDBC中的连接池  SessionFactory是重量级的，一般一个项目加载一次，内部维护了连接池和二级缓存（有默认的连接池）线程安全
            //需要工具类和连接池
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //3.通过SessionFactory获取Session对象，类似JDBC中的Connection
        Session session = sessionFactory.openSession();
        //4.手动开启事务
        Transaction transaction = session.beginTransaction();
        //5.编写代码

        Customer customer = new Customer();
        customer.setCust_name("张成文");

        session.save(customer);

        //6.事务提交
        transaction.commit();
        //7.资源释放
        session.close();
    }
}
