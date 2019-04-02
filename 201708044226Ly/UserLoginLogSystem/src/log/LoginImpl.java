package log;
import java.util.logging.Logger;
public class LoginImpl implements Login{
	public void login() {
		Logger logger=Logger.getLogger(LogAdvice.class.getName());
		logger.info("==========π‹¿Ì‘±µ«¬º==========");	
	}
}
