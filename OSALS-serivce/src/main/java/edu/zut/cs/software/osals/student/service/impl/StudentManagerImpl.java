package edu.zut.cs.software.osals.student.service.impl;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.student.dao.StudentDao;
import edu.zut.cs.software.osals.student.domain.Student;
import edu.zut.cs.software.osals.student.service.StudentManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//@Transactional
//@Service("studentManager")
/**
 * 
 * 注释有无的区别
 * @Transactional
 * @Service("studentManager")
 *
 * @Service("studentManager") Or @Component
 */
@Component
@Transactional
@Service("studentManager")
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
		List<Student> all = new ArrayList<Student>();
		/**
		 * 利用poi读取excel
		 */
		URL url = StudentManagerImpl.class.getClassLoader().getResource("Software17_Student_JavaEE.xlsx");
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
	                }
	                all.add(student);
            	}
                rowNumber++;
                cellNumber = 0;
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
	public List<Student> findBySno(String sno) {
		Student queryObject = new Student();
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		queryObject.setSno(sno);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase(true).withMatcher("sno", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Student> example = Example.of(queryObject, exampleMatcher);
		List<Student> result = this.dao.findAll(example);
		return result;
	}

	@Override
	public List<Student> findByName(String name) {
		Student queryObject = new Student();
		queryObject.setName(name);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith()).withIgnorePaths("dateCreated", "dateModified");
		Example<Student> example = Example.of(queryObject, exampleMatcher);
		List<Student> result = this.dao.findAll(example);
		return result;
	}

	@Override
	public Boolean deleteById(Long id) {
		Optional<Student> student = this.dao.findById(id);
		/**
		 * Problem:
		 * Judge is null
		 * return false
		 */
		if(student.equals(null)) {
			return false;
		} else {
			this.dao.delete(student.get());
			return true;
		}
	}

	@Override
	public Boolean deleteBySno(String sno) {
		List<Student> studentList = this.findBySno(sno);
		if(studentList.size() == 0) {
			return false;
		}
		else {
			for(int i = 0; i < studentList.size(); i++) {
				this.dao.delete(studentList.get(i));
			}
			return true;
		}
	}


}
