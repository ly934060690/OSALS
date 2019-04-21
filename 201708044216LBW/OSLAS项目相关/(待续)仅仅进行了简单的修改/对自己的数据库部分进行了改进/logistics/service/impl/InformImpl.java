package edu.zut.cs.lbw.logistics.service.impl;

import edu.zut.cs.lbw.logistics.service.Inform;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/11
 * @Description: edu.zut.cs.lbw.logistics.service.impl
 * @version: 1.0
 */
@Aspect
@Component
public class InformImpl implements Inform
{
    @Around("execution( public * edu.zut.cs.lbw.logistics.service.impl.EntrePotImpl.*( ))")
    @Override
    public Object AroundMethod(ProceedingJoinPoint pjp)
    {
        Object result = null;
        String MethodName = pjp.getSignature().getName();

        try
        {
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
