package com.hyh.www.ExcelDemo;

//消费者

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ConsumerDemo {
	public int getCount() {
		return count;
	}

	public String[] getExcelCell() {
		return excelCell;
	}

	private ConnectionFactory connFactory;
	private Connection conn;
	private Session session;
	private Destination destination;
	private MessageConsumer consumer;
	private String[] excelCell=new String[3000];
	private int count=0;
	
	ConsumerDemo(){
		try {
			connFactory=new ActiveMQConnectionFactory("admin","admin","tcp://127.0.0.1:61618");
			conn=connFactory.createConnection();
			conn.start();
			session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void getMessage() {
		try {
			destination=session.createQueue("testQueue");//p2p
			//destination=session.createTopic("testTopic");//sub/pub
			consumer=session.createConsumer(destination);
			System.out.println("Consumer开始接收消息！");
			String ms=null;
			while(true) {
				Thread.sleep(25);
				TextMessage msg=(TextMessage)consumer.receive(5000);
				if(msg!=null) {
					ms=msg.getText();
					System.out.println("Consumer:"+ms);
					excelCell[count++]=ms;
				}else {
					break;
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			try {
				consumer.close();
				session.close();
				conn.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ConsumerDemo cd=new ConsumerDemo();
		cd.getMessage();
	}
}

