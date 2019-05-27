package com.hyh.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @Author: hyh
 * @Description: 事件对象
 * @Date:Created in 17:00 2019/5/18
 * @Modified By:
 */
public class MailSendEvent extends ApplicationContextEvent{

    public String getTo() {
        return to;
    }

    private String to;

    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public MailSendEvent(ApplicationContext source,String to) {
        super(source);
        this.to=to;
    }
}
