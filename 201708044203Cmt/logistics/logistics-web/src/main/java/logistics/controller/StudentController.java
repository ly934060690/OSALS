package logistics.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import logistics.entity.Student;
import logistics.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "stu")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @ResponseBody
    @RequestMapping(value = "getAll",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public List<Student> getAllStu()
    {
        return studentService.getAllStudent();
    }

    @ResponseBody
//    @RequestMapping(value = "getStuById",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @GetMapping(value = "getStuById",produces = "application/json;charset=UTF-8")
    public Student getStuById(@RequestBody String msg)
    {
        Map map = (Map) JSONObject.parse(msg);
        Integer id = Integer.valueOf((String)map.get("id"));
        String name = (String) map.get("name");
        System.out.println("前台数据name的值为："+name);
        return studentService.getStuById(id);
    }

    @ResponseBody
    @PostMapping(value = "saveStu",produces="application/json;charset=UTF-8")
    public  Integer saveAllStudent(@RequestBody String msg)
    {
        List<Student> list = new ArrayList<>();
        Student stu = JSONObject.parseObject(msg,Student.class);
        list.add(stu);
        return studentService.saveAllStudent(list);
    }

    @ResponseBody
    @DeleteMapping(value = "deleteStu",produces = "application/json;charset=UTF-8")
    public Integer deleteStuById(@RequestBody String msg){
        Map map=(Map) JSONObject.parse(msg);
        Integer id = Integer.valueOf((String)map.get("id"));
        return studentService.deleteStuById(id);
    }

    @ResponseBody
    @PostMapping(value = "updateStu",produces = "application/json;charset=UTF-8")
    public  Integer updateStuById(@RequestBody String msg){
        Student stu=JSONObject.parseObject(msg,Student.class);
        return studentService.updateStuById(stu);
    }
}
