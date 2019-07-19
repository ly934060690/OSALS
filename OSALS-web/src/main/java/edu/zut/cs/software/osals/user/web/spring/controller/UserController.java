package edu.zut.cs.software.osals.user.web.spring.controller;


import edu.zut.cs.software.osals.admin.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController extends HttpServlet {

    @RequestMapping(value = "/response", method = RequestMethod.GET)
    @ResponseBody
    public User response(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        User user = new User();
        user.setUsername("李博文");
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/request", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String gettext(@RequestBody Map<String, Object> map) {
        String text = (String) map.get("text");
        System.out.println("从前端传来的数据为：");
        System.out.println(text);
        return text;
    }

}
