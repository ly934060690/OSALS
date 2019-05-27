package com.hyh.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author: hyh
 * @Description: 事件发送器
 * @Date:Created in 17:15 2019/5/18
 * @Modified By:
 */
public class MailSender implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
    *@Description: ApplicationContextAware接口方法，以便容器启动时注入容器实例
    *@Date: 17:18 2019/5/18
    */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public void sendMail(String to){
        System.out.println("MailSender:模拟发送邮件.....");
        MailSendEvent mse=new MailSendEvent(this.applicationContext,to);
        //向容器中所有事件监听器发送时间
        applicationContext.publishEvent(mse);
    }

}
