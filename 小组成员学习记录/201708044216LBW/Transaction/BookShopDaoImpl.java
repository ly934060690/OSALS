package spring.tx;

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
        //验证库存
        String sql2 = "SELECT stock from book_stock where isbn = ? ";
        int stock = jdbcTemplate.queryForObject(sql2 , Integer.class , isbn);

        if(stock == 0)
        {
            throw new BookStockException("库存不足，请及时补货！");
        }

        String sql = "update book_stock set stock = stock - 1 where isbn = ?";
        jdbcTemplate.update(sql ,isbn);
    }

    @Override
    public void updateUserAccount(String username, int price)
    {
        //验证余额是否足够

        String sql2 = "SELECT balance from account1 where username = ? ";
        int balance = jdbcTemplate.queryForObject(sql2 , Integer.class , username);

        if(balance < price)
        {
            throw new UserAccountException("用户余额不足，请及时充值！");
        }

        String sql = "update account1 set balance = balance - ? where username = ? ";

        jdbcTemplate.update(sql , price , username);
     }

    @Override
    public String findUserAccount()
    {
        String sql = "select username from account1 ";

        return jdbcTemplate.queryForObject(sql , String.class );
    }
}
