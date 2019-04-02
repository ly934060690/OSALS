package log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestLog {
	public static void main(String[] args) {
		ApplicationContext acx = new ClassPathXmlApplicationContext("log/bean.xml");
		Login login = (Login) acx.getBean("CGLIBProxyFactoryBean");//由代理工厂生成代理对象
		login.login();
	}
}