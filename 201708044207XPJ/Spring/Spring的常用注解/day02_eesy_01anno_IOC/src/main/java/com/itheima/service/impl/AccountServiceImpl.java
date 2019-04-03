package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现
 *
 * <bean id = "accountService" class = "com.itheima.service.impl.AccountServiceImpl"></bean>
 *
 * 以下为注解的集中方式
 * 用于创建对象的
 *      作用和xml配置文件中编写一个bean标签的功能一样
 *      @Component(通过构造方法或者是默认构造方法创建的bean对象)
 *          作用：用于把当前对象存入spring容器
 *          属性：
 *              value：指定bean的id，默认为类名首字母该小写
 *          @Controller:一般用在表现层
 *          @Service:一般用在业务层
 *          @Repository:一般用在持久层
 *     Compoment、Controller、Service和Repository功能一模一样
 *
 * 用于注入数据的
 *      作用和xml配置文件中bean标签中的<property>标签的作用一样
 *      @Autowired:
 *          作用：自动按照类型注入 ，只要容器中有唯一的一个bean对象和要注入的变量类型匹配，就可以注入成功
 *              如果没有则报错；如果有多个匹配时,只是用此注解则无法解决
 *          出现位置：
 *              可以使变量上，也可以是方法上
 *          细节：
 *              在使用注解注入时，set方法就是不必须的了
 *      @Qualifier:
 *          作用：在按照类中注入的基础上在按照名称注入，它给类成员注入时不能单独使用，但是再给方法注入时可以单独使用
 *          属性：value用于表示注入bean的id
 *      @Resource:
 *          作用：直接按照bean的id注入
 *          属性： name指定bean的id
 *      以上三种注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用这三种来实现
 *      并且集合类的注入只能通过xml注入
 *
 *      @value
 *          用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值，它可以使用Spring中spEl(也就是spring的el表达式)
 *
 * 用于改变作用范围的
 *      作用和bean标签中使用scope属性实现的功能一样
 *      @Scope
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围取值，eg:singleton prototype
 * 和生命周期相关
 *      作用就和bean标签中使用init-method 和 destory-method的作用一样
 *      @PreDestory     :   用于指定销毁方法
 *      @PostConstruct    :   用于指定初始化方法
 */
@Component
@Scope(value = "singleton")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name="accountDao1")
    private IAccountDao accountDao = null;    //变量名称作为bean对象的id

    public AccountServiceImpl(){
        System.out.println("AccountService对象创建成功！");
    }
    @PostConstruct
    public void init(){
        System.out.println("AccountService-初始化方法执行了");
    }
    @PreDestroy
    public void destory(){
        System.out.println("AccountService-销毁方法执行了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
