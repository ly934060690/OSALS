package edu.zut.cs.software.osals.student.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.student.domain.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StudentManagerTestCase extends GenericManagerTestCase<Long, Student, StudentManager> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(StudentManagerTestCase.class.getName());

	
	StudentManager studentManager;

	public StudentManagerTestCase() {
		super(Student.class);
	}

	@Autowired
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
		this.manager = this.studentManager;
	}

	@Before
	public void testBefore() {
		Student student = new Student();
		student.setSno("201708044226");
		student.setName("刘研");
		student.setMajor("软件工程");
		student.setGrade("2017");
		student.setSclass("软件172");
		student.setSex("男");
		this.entity = this.manager.save(student);
	}
	
	@Test
	public void testGetAll() {
		List<Student> all = this.studentManager.getAll();
		if (logger.isInfoEnabled()) {
			logger.info("testGetAll() - List<Student> all={}", all); //$NON-NLS-1$
		}

		assertNotNull(all);
		assertEquals(71, all.size());

	}

	@Test
	public void testFindBySno() {
		String sno = this.entity.getSno();
		List<Student> result = this.studentManager.findBySno(sno);
		assertEquals(sno, result.get(0).getSno());
	}

	@Test
	public void testFindByName() {
		List<Student> result = this.studentManager.findByName("刘");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals("刘研", result.get(0).getName());
	}

	@Test
	public void testDeleteBySno() {
		Boolean delete = this.manager.deleteBySno("201708044226");
		assertEquals(true, delete);
	}

	@Test
	public void testDeleteById() {
		Long id = this.entity.getId();
		Boolean delete = this.manager.deleteById(id);
		assertEquals(true, delete);
	}

	@Test
	public void testUpdate() {
		Long id = this.entity.getId();
		Student student = this.manager.findById(id);
		student.setSno("201808064724");
		student.setName("梁颖");
		student.setMajor("计算机");
		student.setGrade("2018");
		student.setSclass("计算机187");
		student.setSex("女");
		student.setDateModified(new Date());
		this.manager.save(student);
		Student student1 = this.manager.findById(id);
		if (logger.isInfoEnabled()) {
		    logger.info("testUpdate() - Student student1={}", student1); //$NON-NLS-1$
		}
	}

}
