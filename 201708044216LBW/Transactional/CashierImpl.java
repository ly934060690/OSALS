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
     * 1.MANDATORY  默认值是使用调用方法的事务
     * 2.isolation  来设置事务的隔离级别
     * 默认情况下spring的声明式事务对所有的运行时异常进行回滚
     * 3.RollbackFor/RollbackForClassName  通过设置哪些异常回滚
     * 4.使用readOnly 指定事务是否为只读，说明这个事务只读取数据不更新数据，
     * 可以帮助数据库引擎优化事务，设置为 readOnly = true
     * 5.使用 timeout 指定强制回滚之前事务可以占用多长时间
     * @param username
     * @param isbns
     */
    @Transactional(propagation = Propagation.MANDATORY,
    isolation = Isolation.READ_COMMITTED ,
            noRollbackFor = {UserAccountException.class} ,
            readOnly = false ,
    timeout = 1)
    @Override
    public void checkout(String username, List<String> isbns)
    {
         for(String isbn :isbns)
         {
             bookShopService.purchase(username , isbn);
         }
    }
}

