package edu.zut.cs.software.test.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ListSheet {

    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;
    private static HSSFWorkbook hssfWorkbook1;
    private static HSSFWorkbook hssfWorkbook2;
    private static HSSFSheet hssfSheet1;
    private static HSSFSheet hssfSheet2;
    private static HSSFRow hssfRow;
    private static HSSFCell hssfCell;
    private static Integer rowNumber = 0;
    private static Integer cellNumber = 0;

    public static void main(String []args) {
        String filePath1 = "D:\\Java\\1819计算机学院软件172班_JavaEE课程练习 (1).xls";
        String filePath2 = "D:\\Java\\demo.xls";
        try {
            fileInputStream = new FileInputStream(filePath1);
            hssfWorkbook1 = new HSSFWorkbook(fileInputStream);
            hssfWorkbook2 = new HSSFWorkbook();

            hssfSheet1 = hssfWorkbook1.getSheet("Sheet1");
            hssfSheet2 = hssfWorkbook2.createSheet("Test");

            for(Row row : hssfSheet1) {
                hssfRow = hssfSheet2.createRow(rowNumber++);
//                hssfCell = hssfRow.createCell(cellNumber++);
//                hssfCell.setCellValue(12.0);
                for(Cell cell : row) {
                    hssfRow.createCell(cellNumber++).setCellValue(String.valueOf(cell));
                    System.out.print(cell + "\t");
                }
                cellNumber = 0;
                System.out.println();
            }
            fileOutputStream = new FileOutputStream(filePath2);
            hssfWorkbook2.write(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
