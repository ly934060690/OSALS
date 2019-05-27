package com.hyh.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: hyh
 * @Description: 启动容器，并调用mailSender Bean发送一封邮件
 * @Date:Created in 17:27 2019/5/18
 * @Modified By:
 */
public class MailStart {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("Send-resourses.xml");
        MailSender mailSender=(MailSender) ctx.getBean("mailSender");
        mailSender.sendMail("aaa@bbb.com");
    }
}
