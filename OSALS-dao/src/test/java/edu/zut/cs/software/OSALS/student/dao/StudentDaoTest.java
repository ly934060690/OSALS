package edu.zut.cs.software.OSALS.student.dao;

<<<<<<< HEAD
import com.sun.org.apache.xml.internal.security.Init;
import edu.zut.cs.software.OSALS.admin.dao.UserDaoTest;
import edu.zut.cs.software.base.dao.GenericDaoTestCase;
=======
>>>>>>> 5af8b31b1ad6c39089c1995608547f8fb98c749e
import edu.zut.cs.software.OSALS.student.domain.Student;
import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 研哥哥
 *
 */
public class StudentDaoTest extends GenericDaoTestCase<Long, Student, StudentDao> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(StudentDaoTest.class.getName());
	
	@Autowired
    StudentDao studentdao;
	
	private static FileInputStream fileInputStream;
	private static InputStream inputStream;

    private static XSSFWorkbook hssfWorkbook;
    
    private static XSSFSheet hssfSheet;
    
    private static Integer rowNumber = 0;
    private static Integer cellNumber = 0;
    
	@Test
	@Rollback(false)
	public void test() {
		
		List<Student> all = new ArrayList<Student>();
		
		/**
		 * 利用poi解析xlsx
		 */
<<<<<<< HEAD
        URL url = UserDaoTest.class.getClassLoader().getResource("Software17_Student_JavaEE.xlsx");
=======
<<<<<<< HEAD
		String filePath = "D:\\Java\\Software17_Student_JavaEE.xlsx";
=======
		String filePath = "D:\\java\\OSALS\\doc\\Software17_Student_JavaEE.xlsx";
>>>>>>> 24fe0a085de6dce6c2ee2ed9910e7d4fee84b589
>>>>>>> 5af8b31b1ad6c39089c1995608547f8fb98c749e
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
	                		student.setCLASS(String.valueOf(cell));
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
	                this.studentdao.save(student);
	                this.studentdao.flush();
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
//		if (logger.isInfoEnabled()) {
//			logger.info("test() - List<Student> all={}", all); //$NON-NLS-1$
//		}
		List<Student> allStudent = this.studentdao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Student> allStudent={}", allStudent); //$NON-NLS-1$
		}
		
	}
	
}
