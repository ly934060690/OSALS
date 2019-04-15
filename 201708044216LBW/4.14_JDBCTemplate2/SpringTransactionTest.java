package com.atguigu.spring.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

    {
        app = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        bookShopDao = (BookShopDao) app.getBean(BookShopDao.class);
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
    }

    @Test
    public void testBookShopDaoupdateUserAccount()
    {
        bookShopDao.updateUserAccount("AA",10);
    }
}
