package edu.zut.cs.software.osals.admin.web.spring.comtroller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.admin.domain.User;
import edu.zut.cs.software.osals.admin.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/5/21 22:44
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends GenericController<User, Long, UserManager> {

    UserManager userManager;

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
        this.manager = this.userManager;
    }

    @RequestMapping("/index")
    public String index() {
        return "user/index";
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is User!";
    }
}
