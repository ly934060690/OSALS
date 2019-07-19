package edu.zut.cs.software.osals.student.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
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
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	StudentDao studentdao;

	@Autowired
	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
		this.dao = this.studentdao;
	}

	/**
	 * 事务回滚false这个注释别取消掉，我所写的实体都别动
	 */
	@Test
//	@Rollback(false)
	public void testSaveStudent() {
		Student student = new Student();
		student.setSno("201708044226");
		student.setName("刘研");
		student.setMajor("软件工程");
		student.setGrade("2017");
		student.setSclass("软件172");
		student.setSex("男");
		this.dao.save(student);
	}

	@Test
	public void testFindById() {
		Student student1 = new Student();
		this.entity = this.dao.save(student1);
		Optional<Student> student = this.dao.findById(this.entity.getId());
		if (logger.isInfoEnabled()) {
		    logger.info("testFindById() - Optional<Student> student={}", student); //$NON-NLS-1$
		}
	}

	@Test
	public void testFindAll() {
		List<Student> studentList = this.dao.findAll();
		if (logger.isInfoEnabled()) {
		    logger.info("testFindAll() - List<Student> studentList={}", studentList); //$NON-NLS-1$
		}
	}
}
