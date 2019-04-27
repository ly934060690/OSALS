package edu.zut.cs.software.test.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;

public class WriterSheet {
	//创建一个excel(里面装一个99乘法表)
    public static void main(String []args) throws Exception {
        //在内存中创建一个Excel文件
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        //给Excel文件创建一张 Sheet1表
        Sheet sheet = workbook.createSheet("qq");//table --》下面的Sheet1名
        //创建行
        for (int i = 1; i <= 9; i++) {
            Row row; //类似于以前的tr
            row = sheet.createRow(i - 1);
            //为一行创建列-->格子
            for (int j = 1; j <= i; j++) {
                Cell cell = row.createCell(j - 1);
                //在格子中添加相应的值
                cell.setCellValue(i + "*" + j + "=" + (i * j));
            }
        }
        //文件输出流--》把内存中的excel文件写到磁盘中
        FileOutputStream fos = new FileOutputStream("D:\\Java\\demos.xls");
        workbook.write(fos);
        fos.close();
    }
}
