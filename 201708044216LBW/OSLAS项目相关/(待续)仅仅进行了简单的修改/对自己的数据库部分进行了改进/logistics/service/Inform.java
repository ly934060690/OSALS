package edu.zut.cs.lbw.logistics.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Auther: LBW
 * @Date: 2019/4/11
 * @Description: edu.zut.cs.lbw.logistics.service
 * @version: 1.0
 */
public interface Inform   //这个为EntrePotImpl提供前置通知
{

    public Object AroundMethod(ProceedingJoinPoint pjp);
}
