package edu.zut.cs.software.osals.nlp.web.spring.controller;


import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRelation;
import edu.zut.cs.software.osals.nlp.service.NlpEntityRelationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/nlper")
public class NlpEntityRelationController extends GenericController<NlpEntityRelation,Long, NlpEntityRelationManager> {
    NlpEntityRelationManager nlpEntityRelationManager;

    @Autowired
    public void setNlpEntityRelationManager(NlpEntityRelationManager nlpEntityRelationManager) {
        this.nlpEntityRelationManager = nlpEntityRelationManager;
    this.manager=this.nlpEntityRelationManager;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String index() {
        String result = "index";
        return result;
    }
    @ResponseBody
    @GetMapping(value = "hello",produces = "application/json;charset=utf-8")
    public String Hello(){
        return "hello nlp web!";
    }
}
