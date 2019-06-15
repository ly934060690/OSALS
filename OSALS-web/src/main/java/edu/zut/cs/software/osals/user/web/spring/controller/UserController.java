package edu.zut.cs.software.osals.user.web.spring.controller;


import edu.zut.cs.software.osals.admin.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class UserController extends HttpServlet {

    @RequestMapping(value = "/response", method = RequestMethod.GET)
    @ResponseBody
    public User response(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        User user = new User();
        user.setUsername("李博文222");
        return user;
    }

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    @ResponseBody
    public Object request(@RequestBody Object object,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println(object);
        return object;
    }

}
