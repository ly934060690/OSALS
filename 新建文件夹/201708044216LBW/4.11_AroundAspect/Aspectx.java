package atguigu.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
    /*
    //声明该方是前置通知，在目标方法开始前执行
    //@Before("execution( public int atguigu.spring.aop.impl.AtithmeticCalutorImpl.add(int , int ))")
    @Before("execution( public * atguigu.spring.aop.impl.AtithmeticCalutorImpl.*(int , int ))")
    public void beforeMethod(JoinPoint joinPoint)
    {
        String methodname = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("前置事务通知:" + "这个方法名为：" + methodname + "方法的参数为：" + args);
    }

    //无论该方法是否出现异常都会出现此通知
    //后置通知不能访问方法的返回结果
    @After("execution( public * atguigu.spring.aop.impl.AtithmeticCalutorImpl.*(int, int ))")
    public void AfterMethod(JoinPoint joinPoint)
    {
        String methodname = joinPoint.getSignature().getName();
        System.out.println("这个方法名为：" + methodname + "结束了");
    }

    @AfterReturning(value = "execution( public * atguigu.spring.aop.impl.AtithmeticCalutorImpl.*(int, int ))",
    returning = "result")
    public void AfterReturning(JoinPoint joinPoint , Object result)
    {
        String methodname = joinPoint.getSignature().getName();
        System.out.println("这个方法名为：" + methodname + "结束了,并且返回值为：" + result);
    }

    @AfterThrowing(value = "execution( public * atguigu.spring.aop.impl.AtithmeticCalutorImpl.*(int, int ))"
    ,throwing = "ex")
    //这里的异常类型要匹配
    public void AfterThrowing(JoinPoint joinPoint , Exception ex)
    {
        String methodname = joinPoint.getSignature().getName();
        System.out.println("这个方法名为：" + methodname + "出错了,并且异常为：" + ex);
    }
    */
    @Around("execution(public * atguigu.spring.aop.impl.AtithmeticCalutorImpl.*(int, int ))")

    public Object AroundMethord(ProceedingJoinPoint pjp){

        Object result = null;
        String MethodName = pjp.getSignature().getName();

        try {
            //前置通知
            System.out.println("这个方法的名称时： " + MethodName + "这个方法的参数是： " + Arrays.asList(pjp.getArgs()));
            result = pjp.proceed();
            //后置通知
            System.out.println("这个带方法" + MethodName + "结束了" + "result：" + result);

        } catch (Throwable throwable)
        {

            System.out.println("异常通知为：" + throwable);
            throw new RuntimeException(throwable);
        }
        finally {
            System.out.println("这个带方法" + MethodName + "走的很安详..." );
        }
         return result;
    }

}
