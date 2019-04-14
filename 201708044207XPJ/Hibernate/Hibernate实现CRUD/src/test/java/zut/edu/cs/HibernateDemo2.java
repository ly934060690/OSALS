package zut.edu.cs;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import zut.edu.cs.dao.Customer;
import zut.edu.cs.hibernate.HiberbateUtils;

/**
 * hibernate工具类的测试
 */
public class HibernateDemo2 {
    /**
     * save Object
     */
    @Test
    public void save(){
        Session session = HiberbateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("刘研");
        session.save(customer);

        transaction.commit();
        session.close();
    }

    /**
     * select
     */
    @Test
    public void select(){
        Session session = HiberbateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        //使用get查询
        Customer customer = session.get(Customer.class,1l);
        System.out.println(customer);
        //使用load查询:懒查询，只有对象用到时才会执行SQL语句
//        Customer customer = session.load(Customer.class,1l);
//        System.out.println(customer);

        transaction.commit();
        session.close();
    }

    /**
     *修改
     */
    @Test
    public void demo3(){
        Session session = HiberbateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //创建对象，进行修改
        /*Customer customer = new Customer();
        customer.setCust_id(6l);
        customer.setCust_name("邢朋举");
        session.update(customer);*/
        //查找对象，然后进行修改(推荐)
        Customer customer =session.get(Customer.class,6l);
        customer.setCust_id(6l);
        customer.setCust_name("举哥哥");
        customer.setCust_mobile("17339453033");
        session.update(customer);

        transaction.commit();
        session.close();
    }

    @Test
    public void demo4(){
        Session session = HiberbateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        //直接创建对象，删除
        /*
        Customer customer = new Customer();
        customer.setCust_id(6l);
        customer.setCust_name("举哥哥");
        session.delete(customer);*/
        //先查找，再删除
        Customer customer = session.get(Customer.class,6l);
        session.delete(customer);

        transaction.commit();
        session.close();
    }

    /**
     * 保存或更新
     */
    @Test
    public void demo5(){
        Session session = HiberbateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        /*Customer customer = new Customer();
        customer.setCust_name("李博文");
        session.saveOrUpdate(customer);*/

        Customer customer = new Customer();
        customer.setCust_name("李博文");
        customer.setCust_id(14l);
        session.saveOrUpdate(customer);

        transaction.commit();
        session.close();
    }

}
