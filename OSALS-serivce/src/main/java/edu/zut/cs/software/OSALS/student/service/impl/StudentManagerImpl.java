package edu.zut.cs.software.OSALS.student.service.impl;

import edu.zut.cs.software.OSALS.student.dao.StudentDao;
import edu.zut.cs.software.OSALS.student.domain.Student;
import edu.zut.cs.software.OSALS.student.service.StudentManager;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
//@Transactional
//@Service("studentManager")
/**
 * 
 * 注释有无的区别
 * @Transactional
 * @Service("studentManager")
 * @author 研哥哥
 *
 */
@Service("studentManager")
@Transactional
public class StudentManagerImpl extends GenericManagerImpl<Student, Long> implements StudentManager {
	/**
	 * Logger for this class
	 */
	
	StudentDao studentDao;
	
	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
		this.dao = this.studentDao;
	}
	
	private static FileInputStream fileInputStream;
    
    private static XSSFWorkbook hssfWorkbook;
    
    private static XSSFSheet hssfSheet;
    
    private static Integer rowNumber = 0;
    private static Integer cellNumber = 0;

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		List<Student> all = new ArrayList<Student>();
		
		/**
		 * 利用poi读取excel
		 */
<<<<<<< HEAD
<<<<<<< HEAD
		URL url = StudentManagerImpl.class.getClassLoader().getResource("Software17_Student_JavaEE.xlsx");
=======
		String filePath = "D:\\JAVA\\仓库\\OSALS\\doc\\Software17_Student_JavaEE.xlsx";
>>>>>>> 2af7140035cf9999cfc029137d7a871d6ab46541
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
		return all;
	}

	@Override
	public Student findByStudentname(String studentname) {
		// TODO Auto-generated method stub
		return null;
	}

}
