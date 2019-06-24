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

        nlpKeywordExtraction.setText(text);
        nlpKeywordExtraction.setWord_1(KeywordList);//Hanlp
        nlpKeywordExtraction.setWord_2(KeyWordComputer);//Ansj
        nlpKeywordExtraction.setWord_4(KeywordList);//嘿嘿
        nlpKeywordExtraction.setWord_3(KeyWordComputer);//嘿嘿
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

    /**
     * 这里是打开关键词提取的页面后就直接执行了getall方法
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody List<NlpKeywordExtraction> getAll(){
        List<NlpKeywordExtraction> all = this.nlpKeywordExtractionManager.findAll();
        return all;
    }

    /**
     * 这里是删除，依据了在数据库中的id的值来查找 这个已经ok了
     * @param id
     * @return nlpKeywordExtraction
     */
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody NlpKeywordExtraction  deleteOne(@PathVariable(value = "id") Long id) {
        NlpKeywordExtraction nlpKeywordExtraction = this.nlpKeywordExtractionManager.findById(id);
        this.nlpKeywordExtractionManager.deleteById(id);
        return nlpKeywordExtraction;
    }

    /**
     * 这里对应前端的部分是新增
     * @param nlpKeywordExtraction
     * @return nlpKeywordExtraction
     */
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody NlpKeywordExtraction saveOne( NlpKeywordExtraction nlpKeywordExtraction){
        this.nlpKeywordExtractionManager.save(nlpKeywordExtraction);
        return nlpKeywordExtraction;
    }

}
