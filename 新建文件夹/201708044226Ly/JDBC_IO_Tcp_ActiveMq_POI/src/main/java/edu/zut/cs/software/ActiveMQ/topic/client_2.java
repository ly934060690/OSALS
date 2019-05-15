package edu.zut.cs.software.ActiveMQ.topic;

/*import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

//消息消费者1
public class client_2 {
    private ConnectionFactory factory;
    private Connection connection;
    private Session session;
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    public client_2() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.start();
        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);


    }
    public void receive() throws Exception {
        Destination topic = session.createTopic("Topic001") ;
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new Listener());
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

}*/
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class client_2 {
   /* private ConnectionFactory factory;
    private Connection connection;
    private Session session;

    public client_2() {
        try {
            factory = new ActiveMQConnectionFactory("ljq", "ljq", "failover:(tcp://localhost:61616)?Randomize=false");
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receive() throws Exception {
        Destination topic = session.createTopic("Topic001") ;
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new Listener());
    }

    class Listener implements MessageListener {
        @Override
        public void onMessage(Message message) {
            try {
                TextMessage tm = (TextMessage) message;
                System.out.println("Subscriber1 Received message: " + tm.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }*/
   private ConnectionFactory factory;
    private Connection connection;
    private Session session;
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    public client_2() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.start();
        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);


    }
    public void receive() throws Exception {
        Destination topic = session.createTopic("Ygg") ;
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new client_2.Listener());
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
