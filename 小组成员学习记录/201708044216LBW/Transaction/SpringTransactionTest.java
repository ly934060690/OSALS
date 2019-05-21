package spring.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/14
 * @Description: com.atguigu.spring.tx
 * @version: 1.0
 */
public class SpringTransactionTest
{
    private ApplicationContext app = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        app = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        bookShopDao = (BookShopDao) app.getBean(BookShopDao.class);
        bookShopService = (BookShopService) app.getBean(BookShopService.class);
        cashier =  app.getBean(Cashier.class);

    }
    @Test
    public void testBookShopDaoFindPriceByIsbn()
    {
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }

    @Test
    public void testBookShopDaoUpdateBookStock()
    {
        bookShopDao.updateBookStock("1002");
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void testBookShopDaoupdateUserAccount()
    {
        bookShopDao.updateUserAccount("AA",10);
        //bookShopDao.updateUserAccount("AA",1000);
    }

    @Test
    public void testBookShopService()
    {
        bookShopService.purchase("AA" , "1001");
    }

    @Test
    public void testTransactionalCashier()
    {
        cashier.checkout("AA" , Arrays.asList("1001" , "1002"));
    }

    /*
    @Test
    public void testUserAccount()
    {
        bookShopDao.findUserAccount();
    }
    */
}
