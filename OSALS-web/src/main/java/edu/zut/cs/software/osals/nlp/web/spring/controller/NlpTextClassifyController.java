package edu.zut.cs.software.osals.nlp.web.spring.controller;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpTextClassify;
import edu.zut.cs.software.osals.nlp.service.NlpTextClassifyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/nlptc")
public class NlpTextClassifyController extends GenericController<NlpTextClassify,Long, NlpTextClassifyManager> {
    NlpTextClassifyManager nlpTextClassifyManager;
    NlpTextClassify nlpTextClassify = new NlpTextClassify();
    @Autowired
    public void setHanlpManager(NlpTextClassifyManager nlpTextClassifyManager) {
        this.nlpTextClassifyManager = nlpTextClassifyManager;
        this.manager = this.nlpTextClassifyManager;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/main")
//    public String index() {
//        String result = "index";
//        return result;
//    }
//
//    @ResponseBody
//    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
//    public String hello() {
//        return "Hello, This is NlpTextClassify NLP!";
//    }

    @ResponseBody
    @RequestMapping(value = "text/{text}", produces = "application/json;charset=utf-8")
    public NlpTextClassify  getText(@PathVariable("text") String text) throws Exception {
        //String text = (String) map.get("text");
        nlpTextClassify.setText(text);
        //nlpTextClassify.setClassify1(this.nlpTextClassifyManager.thuctc(text));
        nlpTextClassify.setClassify1(this.nlpTextClassifyManager.EasyDL(text));
        nlpTextClassify.setClassify2(this.nlpTextClassifyManager.EasyDL(text));
        nlpTextClassify.setClassify3(this.nlpTextClassifyManager.EasyDL(text));
        nlpTextClassify.setClassify4(this.nlpTextClassifyManager.EasyDL(text));
        //nlpTextClassify.setClassify3(this.nlpTextClassifyManager.Fudanlp(text));
        return nlpTextClassify;
    }
    @ResponseBody
    @PostMapping(value = "request", produces = "application/json;charset=utf-8")
    public void getText(@RequestBody Map<String, Object> map) throws Exception {
        String text = (String) map.get("text");
        nlpTextClassify.setText(text);
        nlpTextClassify.setClassify1(this.nlpTextClassifyManager.EasyDL(text));
        nlpTextClassify.setClassify2(this.nlpTextClassifyManager.EasyDL(text));
        nlpTextClassify.setClassify3(this.nlpTextClassifyManager.EasyDL(text));
        nlpTextClassify.setClassify4(this.nlpTextClassifyManager.EasyDL(text));
        this.nlpTextClassifyManager.save(nlpTextClassify);
        System.out.println(text);
    }

    @ResponseBody
    @RequestMapping(value = "response", produces = "application/json;charset=utf-8")
    public NlpTextClassify response(HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return nlpTextClassify;
    }
    /**
     * 这里是打开关键词提取的页面后就直接执行了getall方法
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody
    List<NlpTextClassify> getAll(){
        List<NlpTextClassify> all = this.nlpTextClassifyManager.findAll();
        return all;
    }

    /**
     * 这里是删除，依据了在数据库中的id的值来查找 这里暂时没有继续完善
     * @param id
     * @return nlpKeywordExtraction
     */
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody NlpTextClassify  deleteOne(@PathVariable(value = "id") Long id) {
        NlpTextClassify nlpTextClassify = this.nlpTextClassifyManager.findById(id);
        this.nlpTextClassifyManager.deleteById(id);
        return nlpTextClassify;
    }

    /**
     * 这里对应前端的部分是新增
     * @param
     * @return nlpKeywordExtraction
     */
    @RequestMapping(path = "/save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody NlpTextClassify saveOne( NlpTextClassify nlpTextClassify){
        this.nlpTextClassifyManager.save(nlpTextClassify);
        return nlpTextClassify;
    }
}
