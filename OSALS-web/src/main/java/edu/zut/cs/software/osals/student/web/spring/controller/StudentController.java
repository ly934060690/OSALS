package edu.zut.cs.software.osals.student.web.spring.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.student.domain.Student;
import edu.zut.cs.software.osals.student.service.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

	@ResponseBody//标识转换成JSON处理
	@GetMapping(value = "allToString",produces = "application/json;charset=utf-8")
	public String findAllStudentToString(){
		List<Student> studentList = this.manager.findAll();
		PageInfo pageInfo = new PageInfo(studentList);
		return JSON.toJSONString(pageInfo);
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
//	@RequestMapping(value = "sno/{sno}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@GetMapping(value = "sno/{sno}",produces = "application/json;charset=utf-8")
	public List<Student> getStudent(@PathVariable String sno) {
//		return JSON.toJSONString(this.studentManager.findBySno(sno));
		return this.studentManager.findBySno(sno);
	}

	/**
	 * restful 风格  id/1l
	 * @param id
	 * @return
	 */
	@ResponseBody
	@GetMapping(value = "id/{id}",produces = "application/json;charset=utf-8")
	public Student getStudent(@PathVariable("id") Long id) {
		Student result = this.studentManager.findById(id);
//		System.out.println(result);
		return result;
	}

	@ResponseBody
	@PostMapping(value = "save", produces = "application/json;charset=utf-8")
	public Boolean save(@RequestBody String msg) {
		Student student = JSONObject.parseObject(msg, Student.class);
		System.out.println(student);
		this.manager.save(student);
		return true;
	}

	@ResponseBody
	@PostMapping(value = "update", produces = "application/json;charset=utf-8")
	public Boolean update(@RequestBody String msg) {
		Map map = (Map) JSONObject.parse(msg);
		Student student = JSONObject.parseObject(msg, Student.class);
		Long id = Long.valueOf((String) map.get("id"));
		student.setId(id);
		student.setDateModified(new Date());
		this.manager.save(student);
		return true;
	}

	@ResponseBody
	@DeleteMapping(value = "deleteBySno", produces = "application/json;charset=utf-8")
	public Boolean deleteBySno(@RequestBody String msg) {
		Map map = (Map) JSONObject.parse(msg);
		String sno = String.valueOf(map.get("sno"));
		return this.manager.deleteBySno(sno);
	}

	@ResponseBody
	@DeleteMapping(value = "deleteById", produces = "application/json;charset=utf-8")
	public Boolean deleteById(@RequestBody String msg) {
		Map map = (Map) JSONObject.parse(msg);
		Long id = Long.valueOf((String) map.get("id"));
		return this.manager.deleteById(id);
	}
	
}
