package edu.zut.cs.software.ActiveMQ.topic;

/*import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//消息生产者
public class client_1 {

    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private Connection connection = null;
    private MessageProducer producer;
    private Session session;
    public client_1() throws JMSException
    {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        //创建从工厂连接中得到的对象
        connection = connectionFactory.createConnection();
        connection.start();
        //fasle：参数表示为非事务类型；AUTO_ACNOWLEDGE：消息自动确认
        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
       Destination destination = session.createTopic("MyQueue");
        producer = session.createProducer(destination);
        //设置消息非持久化
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

    }
    public void sendMessage() throws JMSException {
        Destination destination = session.createTopic("MyQueue");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String nowTime = df.format(new Date());
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("D:\\JAVA\\socket.txt"));
            String contentLine = reader.readLine();
            while(contentLine!=null)
            {
                //向activemq 发送东西
                TextMessage msg = session.createTextMessage(" 生产者的消息数据------时刻："+nowTime+"编号："+contentLine);
                System.out.println("向topic中发送消息："+contentLine);
                // 8. 发布消息
                producer.send(destination,msg);
                contentLine = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            connection.close();
        }
    }



}*/

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class client_1 {
    private ConnectionFactory factory;
    private Connection connection;
    private Session session;
    private MessageProducer producer;

    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    public client_1() {
        try {
            //factory = new ActiveMQConnectionFactory("ljq", "ljq", "failover:(tcp://localhost:61616)?Randomize=false");
            ConnectionFactory factory = new ActiveMQConnectionFactory(BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String nowTime = df.format(new Date());
        BufferedReader reader = null;
        Destination destination = session.createTopic("Ygg");
        reader = new BufferedReader(new FileReader("D:\\Java\\Java_Practice__SC\\JDBC_IO_Tcp_ActiveMq_Demo\\src\\Txt"));
        String contentLine = reader.readLine();
        while (contentLine != null) {
            TextMessage msg = session.createTextMessage(" 生产者的消息数据------时刻：" + nowTime + "编号：" + contentLine);
            System.out.println("向topic中发送消息：" + contentLine);
            producer.send(destination, msg);
            contentLine = reader.readLine();
        }
        if (connection != null) {
            connection.close();
        }
    }
}


