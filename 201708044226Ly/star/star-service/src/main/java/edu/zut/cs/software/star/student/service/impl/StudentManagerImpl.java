package edu.zut.cs.software.star.student.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.star.student.dao.StudentDao;
import edu.zut.cs.software.star.student.domain.Student;
import edu.zut.cs.software.star.student.service.StudentManager;

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
		String filePath = "D:\\Java\\doc\\Software17_Student_JavaEE.xlsx";
		try {
            fileInputStream = new FileInputStream(filePath);
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
