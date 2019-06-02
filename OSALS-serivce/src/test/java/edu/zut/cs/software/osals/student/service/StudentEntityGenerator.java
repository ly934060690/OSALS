package edu.zut.cs.software.osals.student.service;

import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.osals.student.domain.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 无事物回滚
 * Software17级学生信息录入MYSQL数据库中
 * @author 研哥哥
 *
 */
public class StudentEntityGenerator extends GenericGenerator {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(StudentEntityGenerator.class.getName());

	@Autowired
	StudentManager studentManager;
	
	private static FileInputStream fileInputStream;
    
    private static XSSFWorkbook hssfWorkbook;
    
    private static XSSFSheet hssfSheet;
    
    private static Integer rowNumber = 0;
    private static Integer cellNumber = 0;
    
	@Test
	public void testSaveStudent() {

		List<Student> all = new ArrayList<Student>();
		
		/**
		 * 利用poi读取excel
		 */
		URL url = StudentEntityGenerator.class.getClassLoader().getResource("Software17_Student_JavaEE.xlsx");
		try {
			fileInputStream = new FileInputStream(url.getFile());
            hssfWorkbook = new XSSFWorkbook(fileInputStream);

            hssfSheet = hssfWorkbook.getSheet("Sheet1");

            for(Row row : hssfSheet) {
            	if(rowNumber == 0) {
            		for(Cell cell : row) {
	                    System.out.print(cell + "\t");
	                    if(cellNumber++ == 5) {
	                    	System.out.print('\t');
	                    }
	                }
            	} else {
            		Student student = new Student();
	                for(Cell cell : row) {
	                	if(cellNumber == 1) {
	                		student.setGrade(String.valueOf(cell));
	                	} else if(cellNumber == 2) {
	                		student.setMajor(String.valueOf(cell));
	                	} else if(cellNumber == 3) {
	                		student.setSclass(String.valueOf(cell));
	                	} else if(cellNumber == 5) {
	                		student.setSno(String.valueOf(cell));
	                	} else if(cellNumber == 6) {
	                		student.setName(String.valueOf(cell));
	                	} else if(cellNumber == 7) {
	                		student.setSex(String.valueOf(cell));
	                	} 
	                	cellNumber++;
	                    System.out.print(cell + "\t");
	                }
	                this.studentManager.save(student);
	                all.add(student);
            	}
            	
                rowNumber++;
                cellNumber = 0;
                System.out.println();
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Student> all={}", all); //$NON-NLS-1$
		}
		
	}
	
	@Test
	public void testSaveAllStudent() {
//		this.studentManager.save(all);
	}
	
	@Test
	public void testFindAll() {
		List<Student> allStudent = this.studentManager.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Student> allStudent={}", allStudent); //$NON-NLS-1$
		}
	}
}
