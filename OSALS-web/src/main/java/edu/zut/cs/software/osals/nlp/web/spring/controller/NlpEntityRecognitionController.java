//package edu.zut.cs.software.osals.nlp.web.spring.controller;
//
//
//import edu.zut.cs.software.base.web.spring.controller.GenericController;
//import edu.zut.cs.software.osals.nlp.domain.NlpEntityRecognition;
//import edu.zut.cs.software.osals.nlp.service.NlpEntityRecognitionManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/nlperg")
//public class NlpEntityRecognitionController extends GenericController<NlpEntityRecognition,Long, NlpEntityRecognitionManager> {
//
//    NlpEntityRecognition nlpEntityRecognition=new NlpEntityRecognition();
//    NlpEntityRecognitionManager nlpEntityRecognitionManager;
//
//    @Autowired
//    public void setNlpEntityRecognitionManager(NlpEntityRecognitionManager nlpEntityRecognitionManager) {
//        this.nlpEntityRecognitionManager = nlpEntityRecognitionManager;
//        this.manager=this.nlpEntityRecognitionManager;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "request", produces = "application/json;charset=utf-8")
//        public void getText(@RequestBody Map<String, Object> map) {
//        String text = (String) map.get("text");
//        String Stanford_result=nlpEntityRecognitionManager.Stanford(text);
//        String HanLP_result=nlpEntityRecognitionManager.HanLP(text);
//        nlpEntityRecognition.setSentence(text);
//        nlpEntityRecognition.setStanford(Stanford_result);
//        nlpEntityRecognition.setHanLP(HanLP_result);
//        this.manager.save(nlpEntityRecognition);
//        System.out.println("从前端传来的数据为：" );
//        System.out.println(text);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "response", produces = "application/json;charset=utf-8")
//    public NlpEntityRecognition response( HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        return nlpEntityRecognition;
//    }
//
//    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
//    public @ResponseBody NlpEntityRecognition saveOne( NlpEntityRecognition nlpEntityRecognition){
//        this.nlpEntityRecognitionManager.save(nlpEntityRecognition);
//        return nlpEntityRecognition;
//    }
//
//    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
//    public @ResponseBody List<NlpEntityRecognition> getAll(){
//        List<NlpEntityRecognition> all = this.nlpEntityRecognitionManager.findAll();
//        return all;
//    }
//
//}
