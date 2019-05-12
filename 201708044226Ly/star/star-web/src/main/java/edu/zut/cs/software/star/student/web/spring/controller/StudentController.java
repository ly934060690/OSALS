package edu.zut.cs.software.star.student.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.star.student.domain.Student;
import edu.zut.cs.software.star.student.service.StudentManager;

/**
 * 
 * 修正中  2019-5-11 16:02:48
 * @author 研哥哥
 *
 */
@Controller
@RequestMapping("/student")
public class StudentController extends GenericController<Student, Long, StudentManager> {

	StudentManager studentManager;
	
	/**
	 * 自动 注入/植入/绑定
	 * @param studentManager
	 */
	@Autowired
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
		this.manager = this.studentManager;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/student/index";
		return result;
	}
	
}
