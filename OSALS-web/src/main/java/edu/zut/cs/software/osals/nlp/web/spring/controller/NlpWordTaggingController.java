package edu.zut.cs.software.osals.nlp.web.spring.controller;

import com.alibaba.fastjson.JSON;
import com.hankcs.hanlp.seg.common.Term;
import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.osals.nlp.domain.NlpWordTagging;
import edu.zut.cs.software.osals.nlp.service.NlpWordTaggingManager;
import me.midday.lexical.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HanlpController
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/6/11 17:40
 * @Version 1.0
 */
@Controller
@RequestMapping("/nlpwt")
public class NlpWordTaggingController extends GenericController<NlpWordTagging, Long, NlpWordTaggingManager> {

    NlpWordTaggingManager hanlpManager;

    private String text;

    @Autowired
    public void setHanlpManager(NlpWordTaggingManager hanlpManager) {
        this.hanlpManager = hanlpManager;
        this.manager = this.hanlpManager;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String index() {
        String result = "index";
        return result;
    }

    @ResponseBody
    @GetMapping(value = "text/{text}", produces = "application/json;charset=utf-8")
    public String getNormWord(@PathVariable("text") String text) {

        List<Term> result = this.manager.normWord(text);
        List<List<Word>> foolPosTagging = this.manager.foolPosTagging(text);
        List<Word> stanfordPosTagging = this.manager.stanfordPosTagging(text);
        List<org.ansj.domain.Term> ansjPosTagging = this.manager.ansjPosTagging(text);

        NlpWordTagging hanlp = new NlpWordTagging();
        hanlp.setText(text);
        hanlp.setWord_1(result.toString());
        hanlp.setWord_2(foolPosTagging.toString());
        hanlp.setWord_3(stanfordPosTagging.toString());
        hanlp.setWord_4(ansjPosTagging.toString());
        this.manager.save(hanlp);

        String string = "";
        for(Term term : result) {
            string += (term.word + "\t");
        }
        string += '\n';
        for(Term term : result) {
            string += (term.nature + "\t");
        }
        string += '\n';
        for(List<Word> words : foolPosTagging) {
            for(Word word : words) {
                string += (word.getContent() + '\t');
            }
        }
        string += '\n';
        for(List<Word> words : foolPosTagging) {
            for(Word word : words) {
                string += (word.getPos() + '\t');
            }
        }
        string += '\n';
        for(Word word : stanfordPosTagging) {
            string += (word.getContent() + '\t');
        }
        string += '\n';
        for(Word word : stanfordPosTagging) {
            string += (word.getPos() + '\t');
        }
        string += '\n';
        for(org.ansj.domain.Term term : ansjPosTagging) {
            string += (term.getRealName() + '\t');
        }
        string += '\n';
        for(org.ansj.domain.Term term : ansjPosTagging) {
            string += (term.getNatureStr() + '\t');
        }
        return string;
    }

    @ResponseBody
    @PostMapping(value = "request", produces = "application/json;charset=utf-8")
    public String getText(@RequestBody Map<String, Object> map) {
        text = (String) map.get("text");
        System.out.print("text : ");
        System.out.println(text);
        return text;
    }

    @ResponseBody
    @GetMapping(value = "responseHanLP", produces = "application/json;charset=utf-8")
    public String responseHanLP(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Term> result = this.manager.normWord(text);
        return result.toString();
    }
    @ResponseBody
    @GetMapping(value = "responseStanfordNlp", produces = "application/json;charset=utf-8")
    public String responseStanfordNlp(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Word> stanfordPosTagging = this.manager.stanfordPosTagging(text);
        return stanfordPosTagging.toString();
    }

    @ResponseBody
    @GetMapping(value = "response", produces = "application/json;charset=utf-8")
    public NlpWordTagging response(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Term> result = this.manager.normWord(text);
        List<List<Word>> foolPosTagging = this.manager.foolPosTagging(text);
        List<Word> stanfordPosTagging = this.manager.stanfordPosTagging(text);
        List<org.ansj.domain.Term> ansjPosTagging = this.manager.ansjPosTagging(text);

        NlpWordTagging nlpWordTagging = new NlpWordTagging();
        nlpWordTagging.setText(text);
        nlpWordTagging.setWord_1(result.toString());
        nlpWordTagging.setWord_2(foolPosTagging.toString());
        nlpWordTagging.setWord_3(stanfordPosTagging.toString());
        nlpWordTagging.setWord_4(ansjPosTagging.toString());
        this.manager.save(nlpWordTagging);

        return nlpWordTagging;
    }
}
