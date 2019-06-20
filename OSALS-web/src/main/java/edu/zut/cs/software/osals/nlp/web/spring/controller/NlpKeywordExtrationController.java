package edu.zut.cs.software.osals.nlp.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpKeywordExtraction;
import edu.zut.cs.software.osals.nlp.service.NlpKeywordExtractionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: LBW
 * @Date: 2019/6/18
 * @Description: edu.zut.cs.software.osals.nlp.web.spring.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/nlpke")
public class NlpKeywordExtrationController extends GenericController<NlpKeywordExtraction, Long, NlpKeywordExtractionManager> {

    NlpKeywordExtractionManager nlpKeywordExtractionManager;

    NlpKeywordExtraction nlpKeywordExtraction = new NlpKeywordExtraction();


    @Autowired
    public void setNlpKeywordExtractionManager(NlpKeywordExtractionManager nlpKeywordExtractionManager)
    {
       this.nlpKeywordExtractionManager = nlpKeywordExtractionManager;
       this.manager = this.nlpKeywordExtractionManager;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String index() {
        String result = "index";
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "request", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String gettext(@RequestBody Map<String, Object> map) throws IOException {
        String text = (String) map.get("text");

        String KeywordList= nlpKeywordExtractionManager.KeywordList(text);
        String KeyWordComputer =  nlpKeywordExtractionManager.KeyWordComputer(text);

        nlpKeywordExtraction.setWord_1(KeywordList);//Hanlp
        nlpKeywordExtraction.setWord_2(KeyWordComputer);//Ansj
        this.manager.save(nlpKeywordExtraction);
        System.out.println("从前端传来的数据为：" );
        System.out.println(text);
        return text;
    }

    @ResponseBody
    @GetMapping(value = "response", produces = "application/json;charset=utf-8")
    public NlpKeywordExtraction response(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return nlpKeywordExtraction;
    }

}
