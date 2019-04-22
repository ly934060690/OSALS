package spring.tx;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/21
 * @Description: spring.tx
 * @version: 1.0
 */
public interface Cashier {
    public void checkout(String username , List<String> isbn);

}
