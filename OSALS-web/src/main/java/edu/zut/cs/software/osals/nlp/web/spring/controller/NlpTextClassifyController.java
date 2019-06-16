package edu.zut.cs.software.osals.nlp.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpTextClassify;
import edu.zut.cs.software.osals.nlp.service.NlpTextClassifyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class NlpTextClassifyController extends GenericController<NlpTextClassify,Long, NlpTextClassifyManager> {
    NlpTextClassifyManager nlpTextClassifyManager;

    @Autowired
    public void setHanlpManager(NlpTextClassifyManager nlpTextClassifyManager) {
        this.nlpTextClassifyManager = nlpTextClassifyManager;
        this.manager = this.nlpTextClassifyManager;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String index() {
        String result = "index";
        return result;
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is NlpTextClassify NLP!";
    }



}
