package atguigu.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/9
 * @Description: atguigu.spring.aop.impl
 * @version: 1.0
 */
@Aspect
@Component
public class Aspectx
{
    //声明该方是前置通知，在目标方法开始前执行
    //@Before("execution( public int atguigu.spring.aop.impl.AtithmeticCalutorImpl.add(int , int ))")
    @Before("execution( public * atguigu.spring.aop.impl.AtithmeticCalutorImpl.*(int , int ))")
    public void beforeMethod(JoinPoint joinPoint)
    {
        String methodname = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("前置事务通知:" + "这个方法名为：" + methodname + "方法的参数为：" + args);
    }

}
