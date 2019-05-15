package com.hyh.www.ExcelDemo;

//≤‚ ‘p2p,sub/pub

import javax.jms.JMSException;

public class MessageManage {

	public static void main(String[] args) throws JMSException {
		
		//P2P
		ProducerDemo pd=new ProducerDemo();
		ConsumerDemo cd=new ConsumerDemo();
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
		ProducerDemo cd=new ProducerDemo();
		cd.sendMessage();
	}
	
}

class ConsumerThread extends Thread{

	@Override
	public void run() {
		ConsumerDemo cd=new ConsumerDemo();
		cd.getMessage();
	}
	
}

