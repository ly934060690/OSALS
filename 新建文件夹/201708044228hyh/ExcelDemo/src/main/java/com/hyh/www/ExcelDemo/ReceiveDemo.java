package com.hyh.www.ExcelDemo;

import com.hyh.www.ExcelDemo.JDBCOperation;

//从消息中间件中接收信息,并保存到数据库中

public class ReceiveDemo {
	public static void main(String[] args) {
		ConsumerDemo cd=new ConsumerDemo();
		cd.getMessage();
		int num=cd.getCount()/8,mark=0;
		while((num--)>0) {
		    mark=JDBCOperation.insert(cd.getExcelCell(),mark);	
		}
		//JDBCOperation.getAll();
	}
}
