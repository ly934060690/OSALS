package spring.tx;

/**
 * @Auther: LBW
 * @Date: 2019/4/21
 * @Description: com.atguigu.spring.tx
 * @version: 1.0
 */
public class BookStockException  extends RuntimeException
{
    /**
     *
     */
    private static final  long serialVersionUID = 1L;

    public BookStockException() {
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }

    public BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
