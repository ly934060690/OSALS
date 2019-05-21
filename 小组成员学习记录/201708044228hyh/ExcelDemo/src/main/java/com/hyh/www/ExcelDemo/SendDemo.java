package com.hyh.www.ExcelDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;

//从Excel中读取数据并发送到消息中间件

public class SendDemo {
	
	public static void main(String[] args) throws Exception {
		try {	
			File excelFile=new File("C:\\Users\\17905\\Desktop\\j2ee\\Software17_Student_JavaEE.xlsx");//创建文件对象
			FileInputStream in=new FileInputStream(excelFile);//文件流
			ExcelUtil.checkExcelVaild(excelFile);//判断文件是否是Excel文件
			Workbook workbook=ExcelUtil.getWorkbook(in,excelFile);
			ExcelUtil.disPlayRow(workbook);
			ProducerDemo cd=new ProducerDemo();
			cd.sendMessageExcel(ExcelUtil.getCellNum()*ExcelUtil.getRowNum(), ExcelUtil.getExcelCell());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
