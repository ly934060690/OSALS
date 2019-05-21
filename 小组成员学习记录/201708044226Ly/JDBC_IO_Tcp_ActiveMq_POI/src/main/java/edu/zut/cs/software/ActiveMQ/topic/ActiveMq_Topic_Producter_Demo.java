package edu.zut.cs.software.ActiveMQ.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;


public class ActiveMq_Topic_Producter_Demo {
    private static final String userName = ActiveMQConnection.DEFAULT_USER;
    private static final String passWord = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String broker_Url = ActiveMQConnection.DEFAULT_BROKER_URL;

    AtomicInteger atomicInteger = new AtomicInteger(0);
    ConnectionFactory connectionFactory;
    Connection connection;
    Session session;
    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<MessageProducer>();

    public void init() {
        connectionFactory = new ActiveMQConnectionFactory(userName, passWord, broker_Url);
            try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String topicName, String message) {
        try {
            //MessageProducer messageProducer = session.createProducer(null);

            Destination destination = session.createTopic(topicName);

            MessageProducer messageProducer = null;

            if(threadLocal.get() != null) {
                messageProducer = threadLocal.get();
            } else {
                messageProducer = session.createProducer(destination);
                threadLocal.set(messageProducer);
            }

            Integer number = atomicInteger.getAndIncrement();
            TextMessage textMessage = session.createTextMessage(message);
            System.out.println(Thread.currentThread().getName() +
                    message + ",number:" + number);
            messageProducer.send(textMessage);
            //session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
