package com.atguigu.spring.tx;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Auther: LBW
 * @Date: 2019/4/14
 * @Description: com.atguigu.spring.tx
 * @version: 1.0
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql = "select price from  book where isbn = ?";

        return jdbcTemplate.queryForObject(sql , Integer.class , isbn);
    }

    @Override
    public void updateBookStock(String isbn) {
        String sql = "update book_stock set stock = stock - 1 where isbn = ?";
        jdbcTemplate.update(sql ,isbn);
    }

    @Override
    public void updateUserAccount(String username, int price)
    {
        String sql = "update account1 set balance = balance - price where username = ? ";
        jdbcTemplate.update(sql ,username ,price );
    }
}
