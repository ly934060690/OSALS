package edu.zut.cs.software.ActiveMQ.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

public class ActiverMq_Topic_Consumer_Demo {

    private Socket socket;
    private static final String userName = ActiveMQConnection.DEFAULT_USER;
    private static final String passWord = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String broker_Url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public ActiverMq_Topic_Consumer_Demo(Socket socket) {
        this.socket = socket;
    }

    AtomicInteger atomicInteger = new AtomicInteger(0);
    ConnectionFactory connectionFactory;
    Connection connection;
    Session session;
    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<MessageConsumer>();

    public void init() {
        connectionFactory = new ActiveMQConnectionFactory(userName, passWord, broker_Url);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void getMessage(String topicName) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            Destination destination = session.createTopic(topicName);
            //MessageConsumer messageConsumer = session.createConsumer(destination);

            MessageConsumer messageConsumer = null;
            if(threadLocal.get() != null) {
                messageConsumer = (MessageConsumer) threadLocal.get();
            } else {
                messageConsumer = session.createConsumer(destination);
                threadLocal.set(messageConsumer);
            }

            //messageConsumer.setMessageListener(new ActiverMq_Topic_Consumer_Demo.Listener());

            while (true) {
                //Thread.sleep(1000);
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if(textMessage != null) {
                    textMessage.acknowledge();
                    System.out.println(Thread.currentThread().getName() +
                            "接收到: " + textMessage.getText() + "-->" + atomicInteger.getAndIncrement());
                    writer.println(textMessage.getText());
                    System.out.println("TcpServerThread_Send_OK!");
                } else {
                    break;
                }
            }

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //思考while循环与Listener的千秋之处
    class Listener implements MessageListener {
        @Override
        public void onMessage(Message message) {
            try {
                PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
                TextMessage textMessage = (TextMessage) message;
                System.out.println(Thread.currentThread().getName() +
                        "接收到: " + textMessage.getText() + "-->" + atomicInteger.getAndIncrement());
                writer.println(textMessage.getText());
                System.out.println("TcpServerThread_Send_OK!");
            } catch (JMSException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}