package edu.zut.cs.software.osals.student.service;

import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.osals.student.dao.StudentDao;
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
import java.util.Date;
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
    
	@Test
	public void testSaveStudent() {
		List<Student> all = this.studentManager.getAll();
		this.studentManager.save(all);
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Student> all={}", all); //$NON-NLS-1$
		}
	}
	
	@Test
	public void testFindAll() {
		List<Student> allStudent = this.studentManager.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Student> allStudent={}", allStudent); //$NON-NLS-1$
		}
	}

	/**
	 * Problem : First Update Version 0 --> 1
	 * But new Student() : Version is 0
	 * It can be understood that version 0 is lower than version 1
	 * If the entity version number is obtained to be the latest version number, the Update operation will succeed!
	 */
	@Test
	public void testUpdate() {
		Student student = new Student();
		student.setId(211l);
		student.setSno("201503040113");
		student.setName("米文通");
		student.setSex("男");
		student.setMajor("软件工程");
		student.setGrade("2017");
		student.setSclass("软件171");
		student.setDateModified(new Date());
		this.studentManager.save(student);
	}

	/**
	 * Succeed : Version
	 * Optimistic locking
	 */
	@Test
	public void testFindAndUpdate() {
		Student student = this.studentManager.findById(211l);
		student.setDateModified(new Date());
		this.studentManager.save(student);
	}
}
