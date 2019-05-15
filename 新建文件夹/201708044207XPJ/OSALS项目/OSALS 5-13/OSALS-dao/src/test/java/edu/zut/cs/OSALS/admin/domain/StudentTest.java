package edu.zut.cs.OSALS.admin.domain;

import edu.zut.cs.OSALS.admin.dao.StudentDao;
import edu.zut.cs.OSALS.base.dao.GenericDaoTestCase;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class StudentTest extends GenericDaoTestCase<Long, Student, StudentDao> {
    @Autowired
    StudentDao studentDao;


    public String[][] GetExcell(){
        FileInputStream fileInputStream = null;
        String arr[][] = new String[0][];
        try {
            fileInputStream = new FileInputStream("E:\\QQ接收文件\\1819计算机学院软件172班_JavaEE课程练习 (version 1).xls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //2007版本的excel，用.xlsx结尾
            //XSSFWorkbook wookbook = new XSSFWorkbook(file);//得到工作簿
            //2003版本的excel，用.xls结尾
            Workbook wookbook = new HSSFWorkbook(fileInputStream);//得到工作簿

            //得到一个工作表
            Sheet sheet = wookbook.getSheetAt(0);

            //获得表头
            Row rowHead = sheet.getRow(0);


            //获得数据的总行数
            int totalRowNum = sheet.getLastRowNum();
/*
            //获得第i行对象
            Row row = sheet.getRow(1);

            //获得获得第i行第0列的 String类型对象
            Cell cell = row.getCell((short)0);
            int id = (int) cell.getNumericCellValue();
*/
            Row row;
            Cell cell;
            arr= new String[totalRowNum+1][7];
            //表头
//            for (int i=1;i<=6;i++) {
//                arr[0][i]= String.valueOf(rowHead.getCell(i));
//                System.out.print(arr[0][i]+'\t');
//            }
//            System.out.println();
            //内容
            for(int i=1;i<=totalRowNum;i++) {
                row = sheet.getRow(i);
                for (int j = 1; j <= 6; j++) {
                    cell = row.getCell(j);
                    arr[i][j] =cell.getStringCellValue();
                    //System.out.print(arr[i][j]+'\t');
                }
                //System.out.println();
            }
            //System.out.println(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Test
    @Rollback(false)
    public void Save() {
        String arr[][] = GetExcell();
        Student student;
        for(int i=0;i<39;i++) {
            student = new Student();
            student.setSdept(arr[i][1]);
            student.setMajor(arr[i][2]);
            student.setClass_num(arr[i][3]);
            student.setStudent_num(arr[i][4]);
            student.setName(arr[i][5]);
            student.setSsex(arr[i][6]);
            studentDao.save(student);
        }

    }
}