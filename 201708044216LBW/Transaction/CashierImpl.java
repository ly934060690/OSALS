package spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/21
 * @Description: spring.tx
 * @version: 1.0
 */
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    /**
     * 事务的传播方法
     * MANDATORY  默认值是使用调用方法的事务
     * isolation  来设置
     * @param username
     * @param isbns
     */
    @Transactional(propagation = Propagation.MANDATORY,
    isolation = Isolation.READ_COMMITTED)
    @Override
    public void checkout(String username, List<String> isbns)
    {
         for(String isbn :isbns)
         {
             bookShopService.purchase(username , isbn);
         }
    }
}

