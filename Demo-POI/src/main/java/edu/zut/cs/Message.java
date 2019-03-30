package edu.zut.cs;

import java.sql.SQLException;

import javax.jms.JMSException;

public class Message {
public static void main(String[] args) throws JMSException, SQLException {
		
		//P2P
		Producer pd=new Producer();
		Consumer cd=new Consumer();
		pd.sendMessage();	
		cd.getMessage();
		
		//sub/pub
	    /*
		new ConsumerThread().start();
		new ProducerThread().start();
		*/
	}
}

class ProducerThread extends Thread{

	@Override
	public void run() {
		Producer cd=new Producer();
		cd.sendMessage();
	}
	
}

class ConsumerThread extends Thread{

	@Override
	public void run() {
		Consumer cd=new Consumer();
		try {
			cd.getMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
