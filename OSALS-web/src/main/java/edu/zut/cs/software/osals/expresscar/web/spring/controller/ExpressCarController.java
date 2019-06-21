package edu.zut.cs.software.osals.expresscar.web.spring.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.expresscar.domain.Enwrap;
import edu.zut.cs.software.osals.expresscar.domain.ExpressCar;
import edu.zut.cs.software.osals.expresscar.service.ExpressCarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

/**
 * @Author: hyh
 * @Description: ExpressCar Controller
 * @Date:Created in 20:32 2019/6/3
 * @Modified By:
 */
@Controller
@RequestMapping("/expressCar")
public class ExpressCarController extends GenericController<ExpressCar,Long, ExpressCarManager> {

    ExpressCarManager expressCarManager;

    @Autowired
    public void setExpressCarManager(ExpressCarManager expressCarManager){
        this.expressCarManager=expressCarManager;
        this.manager=this.expressCarManager;
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is ExpressCar!";
    }

    @ResponseBody
    @GetMapping(value = "all", produces = "application/json;charset=utf-8")
    public String findAllExpressCar() {
        List<ExpressCar> list = this.manager.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JSON.toJSONString(pageInfo);
    }

}
