package edu.zut.cs.software.osals.nlp.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpDependencyRelation;
import edu.zut.cs.software.osals.nlp.service.NlpDependencyRelationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: hyh
 * @Description:
 * @Date:Created in 16:11 2019/6/13
 * @Modified By:
 */
@Controller
@RequestMapping("/nlpdr")
public class NlpDependencyRelationController  extends GenericController<NlpDependencyRelation, Long, NlpDependencyRelationManager> {

    NlpDependencyRelationManager hanlpManager;

    @Autowired
    public void setHanlpManager(NlpDependencyRelationManager hanlpManager) {
        this.hanlpManager = hanlpManager;
        this.manager = this.hanlpManager;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String index() {
        String result = "index";
        return result;
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is NlpDependencyRelation Hanlp!";
    }

}
