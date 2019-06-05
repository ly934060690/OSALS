package zut.cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zut.cs.domain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/5/29
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
@Controller
@RequestMapping("/gx")
public class HelloController
{

    @RequestMapping(path = "/hello" , method = {RequestMethod.GET})
    public String Sayhello()
    {
        System.out.println("你好骚啊！！！");
        return "success";
    }
    /*
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String Addpreson(String Name)
    {
        String a = Name;
        System.out.println(a);
        return "AddedSuccessed";
    }

*/
    @RequestMapping(value = "/addnumber" , method = RequestMethod.GET)
    public String Addnumber(String number)
    {
        System.out.println(number);
        return "success";
    }

    //超级暴力传参方式！
    @RequestMapping(value = "/addstudent" , method = RequestMethod.POST)
    public String AddStudent(Student student)
    {
        System.out.println(student);
        return "AddedSuccessed";
    }
    /*
    @RequestMapping(value = "/ShowUserListJson")
    public String ShowUserListJson(ModelMap mm)
    {
        List<Student> students = new ArrayList<Student>();

        //students.
        mm.addAttribute("students" , students);
        return "studentListJson";
    }
    */

    @RequestMapping(value = "/addlbw" )
    public String Addlbw(Model model)
    {
        Student student = new Student();
        student.setName("LBW");
        student.setNumbers("100");
        model.addAttribute("student" , student);
        return "AddedSuccessed";
    }

}
