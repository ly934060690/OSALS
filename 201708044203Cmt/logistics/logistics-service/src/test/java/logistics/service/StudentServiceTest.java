package logistics.service;

import logistics.entity.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ContextConfiguration(locations = {"classpath:spring/applicationContext-service.xml",
        "classpath*:spring/applicationContext-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class StudentServiceTest {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Test
    public void getAllStudentTest() {
        List<Student> list = studentService.getAllStudent();
        for (Student student : list) {
            System.out.println(student);
        }

    }

    @Test
    @Commit
    public void saveAllStudentTest() {
        List<Student> list = new ArrayList<>();
        Student stu = new Student();
        stu.setStuNum("201708044110");
        stu.setStuName("hhhh");
        stu.setStuSex(1);
        stu.setStuClass("20170804401");
        list.add(stu);
        stu = new Student();
        stu.setStuNum("201708044222");
        stu.setStuName("www");
        stu.setStuSex(0);
        stu.setStuClass("20170804401");
        list.add(stu);

        Integer result = studentService.saveAllStudent(list);
        System.out.println(result);

    }

    @Test
    public void getStuByIdTest(){
        Student student=studentService.getStuById(21695);
        System.out.println(student);
    }

    @Test
    public void deleteStuByIdTest()
    {
       studentService.deleteStuById(21695);
    }

    @Test
    @Commit
    public void updateStuTest()
    {
        Student student=new Student();
        student.setId(21659);
        student.setStuNum("201705084814");
        student.setStuName("小明");
        student.setStuSex(0);
        student.setStuClass("201708001");
        studentService.updateStuById(student);
    }
    @Test
    public void poiWriteTest() throws IOException {
        String[] cloName = {"id", "学号", "姓名", "性别", "班级号"};
        String file = "student.xlsx";
        //获取学生信息
        List<Student> studentList = studentService.getAllStudent();

        //新建一个workbook对象
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建sheet
        XSSFSheet sheet = workbook.createSheet();
        //创建Row
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell;
        //创建第一行表头
        for (int i = 0; i < cloName.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(cloName[i]);
        }
        int k = 1;
        //写入学生数据
        for (Student student : studentList) {
            row = sheet.createRow(k++);
            for (int i = 0; i < cloName.length; i++) {
                cell = row.createCell(i);
                switch (i) {
                    case 0:
                        cell.setCellValue(student.getId());
                        break;
                    case 1:
                        cell.setCellValue(student.getStuNum());
                        break;
                    case 2:
                        cell.setCellValue(student.getStuName());
                        break;
                    case 3:
                        cell.setCellValue(student.getStuSex());
                        break;
                    case 4:
                        cell.setCellValue(student.getStuClass());
                        break;
                }
            }

        }
        //创建一个文件输出流，将表格内容写入
        FileOutputStream out = new FileOutputStream("C:\\Users\\CuiMengtin\\Desktop\\" + file);
        workbook.write(out);
        out.close();
    }

    @Test
    @Commit
    public void poiReadTest() throws IOException {
        List<Student> list = new ArrayList<>();
        Student student;

        String file = "student.xlsx";
        FileInputStream input = new FileInputStream("C:\\Users\\CuiMengtin\\Desktop\\" + file);
        //使用输入流初始化workbook对象
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        input.close();
        //得到第一张表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //创建一个RowIterator对象
        Iterator<Row> rowIterator = sheet.rowIterator();

        rowIterator.next();
        while (rowIterator.hasNext()) {
            XSSFRow row = (XSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            student = new Student();
            while (cellIterator.hasNext()) {
                XSSFCell cell = (XSSFCell) cellIterator.next();
                switch (cell.getColumnIndex()) {
                    case 1:
                        student.setStuNum(cell.getStringCellValue());
                        break;
                    case 2:
                        student.setStuName(cell.getStringCellValue());
                        break;
                    case 3:
                        student.setStuSex((int) cell.getNumericCellValue());
                        break;
                    case 4:
                        student.setStuClass(cell.getStringCellValue());
                        break;
                }
            }
            list.add(student);
        }
        if (list.size() > 0) {
            studentService.saveAllStudent(list);
        }
    }


}
