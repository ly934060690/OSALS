package edu.zut.cs.software.osals.nlp.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpAbstractExtraction;
import edu.zut.cs.software.osals.nlp.service.NlpAbstractExtractionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
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
        this.manager.save(nlpAbstractExtraction);
        System.out.println(text);
    }

    @ResponseBody
    @GetMapping(value = "response", produces = "application/json;charset=utf-8")
    public NlpAbstractExtraction response(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return nlpAbstractExtraction;
    }
    /**
     * 这里是打开关键词提取的页面后就直接执行了getall方法
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody
    List<NlpAbstractExtraction> getAll(){
        List<NlpAbstractExtraction> all = this.nlpAbstractExtractionManager.findAll();
        return all;
    }
    /**
     * 这里是删除，依据了在数据库中的id的值来查找 这里暂时没有继续完善
     * @param id
     * @return nlpAbstractExtraction
     */
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody NlpAbstractExtraction  deleteOne(@PathVariable(value = "id") Long id) {
        NlpAbstractExtraction nlpAbstractExtraction = this.nlpAbstractExtractionManager.findById(id);
        this.nlpAbstractExtractionManager.deleteById(id);
        return nlpAbstractExtraction;
    }

    /**
     * 这里对应前端的部分是新增
     * @param nlpAbstractExtraction
     * @return nlpAbstractExtraction
     */
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody NlpAbstractExtraction saveOne( NlpAbstractExtraction nlpAbstractExtraction){
        this.nlpAbstractExtractionManager.save(nlpAbstractExtraction);
        return nlpAbstractExtraction;
    }
}
