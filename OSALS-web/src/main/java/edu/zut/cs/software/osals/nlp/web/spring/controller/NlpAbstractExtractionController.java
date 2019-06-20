package edu.zut.cs.software.osals.nlp.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpAbstractExtraction;
import edu.zut.cs.software.osals.nlp.service.NlpAbstractExtractionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
@RequestMapping("/nlpae")
public class NlpAbstractExtractionController extends GenericController<NlpAbstractExtraction, Long, NlpAbstractExtractionManager> {

    NlpAbstractExtractionManager nlpAbstractExtractionManager;

    NlpAbstractExtraction nlpAbstractExtraction = new NlpAbstractExtraction();

    @Autowired
    public void setNlpAbstractExtractionManager(NlpAbstractExtractionManager nlpAbstractExtractionManager){
        this.nlpAbstractExtractionManager = nlpAbstractExtractionManager;
        this.manager = this.nlpAbstractExtractionManager;
    }

    @ResponseBody
    @PostMapping(value = "request", produces = "application/json;charset=utf-8")
    public void getText(@RequestBody Map<String, Object> map) {
        String text = (String) map.get("text");
        nlpAbstractExtraction.setText(text);
        nlpAbstractExtraction.setText1(this.nlpAbstractExtractionManager.AbstractExtractionHanlp(text));
        nlpAbstractExtraction.setText2(this.nlpAbstractExtractionManager.AbstractExtractionAnsj(text));
        System.out.println(text);
    }

    @ResponseBody
    @GetMapping(value = "response", produces = "application/json;charset=utf-8")
    public NlpAbstractExtraction response(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return nlpAbstractExtraction;
    }
}
