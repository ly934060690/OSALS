package com.hyh.event;

import org.springframework.context.ApplicationListener;

/**
 * @Author: hyh
 * @Description: 事件监听器
 * @Date:Created in 17:07 2019/5/18
 * @Modified By:
 */
public class MailSenderListener implements ApplicationListener<MailSendEvent> {

    //MailSendEvent事件进行处理
    public void onApplicationEvent(MailSendEvent event) {
        MailSendEvent mse=(MailSendEvent) event;
        System.out.println("MailSendListener:向"+mse.getTo()+"发送完一封邮件");
    }


}
