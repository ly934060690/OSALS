package spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: LBW
 * @Date: 2019/4/21
 * @Description: com.atguigu.spring.tx
 * @version: 1.0
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService{
    @Autowired
    private BookShopDaoImpl bookShopDao;
    int price;

    @Transactional    //事务注解
    @Override
    public void purchase(String name, String isbn) {

        //获取书的单价
        price = bookShopDao.findBookPriceByIsbn(isbn);

        //更新书的库存
        bookShopDao.updateBookStock(isbn);

        //更新账户的余额
        bookShopDao.updateUserAccount(name , price);
    }
}
