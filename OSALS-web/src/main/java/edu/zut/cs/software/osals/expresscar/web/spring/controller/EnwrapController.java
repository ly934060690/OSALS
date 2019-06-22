package edu.zut.cs.software.osals.expresscar.web.spring.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.expresscar.domain.Enwrap;
import edu.zut.cs.software.osals.expresscar.domain.ExpressCar;
import edu.zut.cs.software.osals.expresscar.service.EnwrapManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: hyh
 * @Description: Enwrap Controller
 * @Date:Created in 20:33 2019/6/3
 * @Modified By:
 */
@Controller
@RequestMapping("/enwrap")
public class EnwrapController extends GenericController<Enwrap,Long, EnwrapManager> {

    EnwrapManager enwrapManager;

    @Autowired
    public void setEnwrapManager(EnwrapManager enwrapManager){
        this.enwrapManager=enwrapManager;
        this.manager=this.enwrapManager;
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is Enwrap!";
    }

    @ResponseBody
    @GetMapping(value = "all", produces = "application/json;charset=utf-8")
    public String findAllEnwrap() {
        List<Enwrap> list = this.manager.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return JSON.toJSONString(pageInfo);
    }

}
