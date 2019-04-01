package edu.zut.cs.software.ActiveMQ.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

//消息消费者2
public class client_3 {
    private ConnectionFactory factory;
    private Connection connection;
    private Session session;
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    public client_3() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.start();
        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);


    }
    public void receive() throws Exception {
        Destination topic = session.createTopic("Topic001") ;
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new client_3.Listener());
    }

    class Listener implements MessageListener {
        @Override
        public void onMessage(Message message) {
            try {
                TextMessage tm = (TextMessage) message;
                System.out.println("client_2 Received message: " + tm.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
