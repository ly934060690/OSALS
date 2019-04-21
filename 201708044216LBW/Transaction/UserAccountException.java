package spring.tx;

/**
 * @Auther: LBW
 * @Date: 2019/4/21
 * @Description: com.atguigu.spring.tx
 * @version: 1.0
 */
public class UserAccountException extends RuntimeException{

    /**
     *
     */
    private static final  long serialVersionUID = 1L;

    public UserAccountException() {
    }

    public UserAccountException(String message) {
        super(message);
    }

    public UserAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccountException(Throwable cause) {
        super(cause);
    }

    public UserAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
