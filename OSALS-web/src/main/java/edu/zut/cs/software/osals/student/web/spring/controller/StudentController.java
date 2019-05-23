package edu.zut.cs.software.osals.student.web.spring.controller;

import com.alibaba.fastjson.JSON;
import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.student.domain.Student;
import edu.zut.cs.software.osals.student.service.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 * 修正中  2019-5-11 16:02:48
 * @author 研哥哥
 *
 */
@Controller
@RequestMapping("/stu")
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

	/**
	 * /stu/main
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/main")
	public String index() {
		String result = "index";
//		通过视图解析器得到真正的视图 /html/index.html
		return result;
	}

	@ResponseBody//标识转换成JSON处理
	@GetMapping(value = "all",produces = "application/json;charset=utf-8")
	public List<Student> findAllStudent(){
		return this.manager.findAll();
	}

	@ResponseBody
	@GetMapping(value = "ly", produces = "application/json;charset=utf-8")
	public String ly() {
		return "Hello, Ly";
	}

	/**
	 * 传统方式  getBySno.action?sno=201708044226
	 * @param sno
	 * @return
	 */
	@ResponseBody
	@GetMapping(value = "getBySno",produces = "application/json;charset=utf-8")
	public String getStudentDemo(@RequestParam("sno") String sno) {

		return JSON.toJSONString(this.manager.findBySno(sno));
	}

	/**
	 * restful 风格  sno/201708044226
	 * @param sno
	 * @return
	 */
	@ResponseBody
//	@RequestMapping(value = "sno/{sno}", method = RequestMethod.GET, produces = "application/json")
	@GetMapping(value = "sno/{sno}",produces = "application/json;charset=utf-8")
	public String getStudent(@PathVariable String sno) {
		return JSON.toJSONString(this.studentManager.findBySno(sno));
	}

	/**
	 * restful 风格  id/1l
	 * @param id
	 * @return
	 */
	@ResponseBody
	@GetMapping(value = "id/{id}",produces = "application/json;charset=utf-8")
	public String getStudent(@PathVariable("id") Long id) {
		return "id";
//		return JSON.toJSONString(this.studentManager.findById(id));
	}
	
}
