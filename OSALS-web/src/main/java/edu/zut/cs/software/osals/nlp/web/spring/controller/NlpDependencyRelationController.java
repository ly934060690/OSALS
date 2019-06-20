package edu.zut.cs.software.osals.nlp.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpDependencyRelation;
import edu.zut.cs.software.osals.nlp.service.NlpDependencyRelationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: hyh
 * @Description: NlpDependenceRelation Controller
 * @Date:Created in 16:11 2019/6/13
 * @Modified By:
 */
@Controller
@RequestMapping("/nlp")
public class NlpDependencyRelationController  extends GenericController<NlpDependencyRelation, Long, NlpDependencyRelationManager> {

    NlpDependencyRelationManager hanlpManager;

    private NlpDependencyRelation nlp=new NlpDependencyRelation();

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
        return "Hello, This is NlpDependencyRelation nlp!";
    }

    @ResponseBody
    @GetMapping(value = "text/{text}", produces = "application/json;charset=utf-8")
    public String getDependencyRelation(@PathVariable("text") String text){

        /**
         * StanfordParser 返回依存关系，标注指代
         */
        nlp=this.manager.stanfordTextNlp(text);
        this.manager.save(nlp);
        return nlp.getRelation()+"\n"+nlp.getAnnotated();
    }

    @ResponseBody
    @PostMapping(value = "request", produces = "application/json;charset=utf-8")
    public void getText(@RequestBody Map<String, Object> map) {
        String text = (String) map.get("text");
        nlp=this.manager.stanfordTextNlp(text);
        this.manager.save(nlp);
        System.out.println(nlp.getRelation()+"\n"+nlp.getAnnotated());
    }

    @ResponseBody
    @GetMapping(value = "responsedr", produces = "application/json;charset=utf-8")
    public NlpDependencyRelation response(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return nlp;
    }
}
