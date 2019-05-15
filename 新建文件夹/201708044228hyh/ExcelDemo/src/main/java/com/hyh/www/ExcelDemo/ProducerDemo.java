package com.hyh.www.ExcelDemo;

//生产者

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ProducerDemo {
	private static ConnectionFactory connFactory;
	private static Connection conn;
	private static Session session;
	private static Destination destination;
	private static MessageProducer producer;
	
	ProducerDemo(){
		try {
			connFactory=new ActiveMQConnectionFactory("admin","admin","tcp://127.0.0.1:61618");//创建链接工厂
			conn=connFactory.createConnection();//获取链接
			conn.start();
			session=conn.createSession(true, Session.AUTO_ACKNOWLEDGE);//创建session会话
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage() {
		boolean result=false;
		try {
			
			destination=session.createQueue("testQueue");//创建一个消息队列p2p型
			//destination=session.createTopic("testTopic");//pub/sub型
			producer=session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);//消息持久化
			if(null!=session&&null!=producer) {
				String message="hello javaee!";
				int count=11;
				System.out.println("Producer开始生产消息！");
				while((count--)>1) {
					Thread.sleep(500);
					producer.send(session.createTextMessage("message "+count+" : "+message));
					System.out.println("Producer:"+"message "+count+" : "+message);
					session.commit();
					result=true;
				}
			}
		} catch (JMSException e2) {
			// TODO Auto-generated catch block
			try {
				session.rollback();    //回滚
			} catch (JMSException e) {
				e.printStackTrace();
			}     
			e2.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			try {
				producer.close();
				session.close();
				conn.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(result?"Producer:消息发送成功！\n":"Producer:消息发送失败！\n");
	}
	
	public void sendMessageExcel(int count,String[] excelCell) {
		boolean result=false;
		try {
			
			destination=session.createQueue("testQueue");//创建一个消息队列p2p型
			//destination=session.createTopic("testTopic");//pub/sub型
			producer=session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);//消息持久化
			if(null!=session&&null!=producer) {
				System.out.println("Producer开始生产消息！");
				int n=0;
				while(n<count) {
					Thread.sleep(25);
					producer.send(session.createTextMessage(excelCell[n]));
					System.out.println("Producer:"+excelCell[n]);
					n++;
					session.commit();
					result=true;
				}
			}
		} catch (JMSException e2) {
			// TODO Auto-generated catch block
			try {
				session.rollback();    //回滚
			} catch (JMSException e) {
				e.printStackTrace();
			}     
			e2.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			try {
				producer.close();
				session.close();
				conn.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(result?"Producer:消息发送成功！\n":"Producer:消息发送失败！\n");
	}
	
	public static void main(String[] args) {
		ProducerDemo cd=new ProducerDemo();
		cd.sendMessage();
	}	
}
