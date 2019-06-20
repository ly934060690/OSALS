package edu.zut.cs.software.osals.nlp.web.spring.controller;


import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRecognition;
import edu.zut.cs.software.osals.nlp.service.NlpEntityRecognitionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/nlpEntityRecognition")
public class NlpEntityRecognitionController extends GenericController<NlpEntityRecognition,Long, NlpEntityRecognitionManager> {

    NlpEntityRecognitionManager nlpEntityRecognitionManager;
    @Autowired
    public void setNlpEntityRecognitionManager(NlpEntityRecognitionManager nlpEntityRecognitionManager)
    {
        this.nlpEntityRecognitionManager=nlpEntityRecognitionManager;
        this.manager=this.nlpEntityRecognitionManager;
    }
//    @RequestBody
//    @GetMapping(value = "")
}
