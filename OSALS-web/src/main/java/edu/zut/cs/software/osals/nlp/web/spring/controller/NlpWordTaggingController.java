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

import java.util.List;

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

        NlpWordTagging hanlp = new NlpWordTagging();
        hanlp.setText(text);
        hanlp.setWord_1(result.toString());
        hanlp.setWord_2(foolPosTagging.toString());
        hanlp.setWord_3(stanfordPosTagging.toString());
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
        return string;
    }
}
