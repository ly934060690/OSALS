package edu.zut.cs.software.osals.nlp.service;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpWordTagging;
import me.midday.FoolNLTK;
import me.midday.lexical.AnalysisResult;
import me.midday.lexical.Entity;
import me.midday.lexical.LexicalAnalyzer;
import me.midday.lexical.Word;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HanlpManagerTestCase
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/6/11 17:22
 * @Version 1.0
 */
public class NlpWordTaggingManagerTestCase extends GenericManagerTestCase<Long, NlpWordTagging, NlpWordTaggingManager> {

    public NlpWordTaggingManagerTestCase() {
        super(NlpWordTagging.class);
    }
    NlpWordTaggingManager nlpWordTaggingManager;

    @Autowired
    public void setHanlpManager(NlpWordTaggingManager nlpWordTaggingManager) {
        this.nlpWordTaggingManager = nlpWordTaggingManager;
        this.manager = this.nlpWordTaggingManager;
    }

    @Test
    public void test1() {
        System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包！"));
    }

    @Test
    public void testNormWord() {
        List<Term> termList = this.manager.normWord("商品和服务");
        for(Term term : termList) {
            System.out.println(term.word + " " + term.nature);
            System.out.println(term);
            System.out.println(term.toString());
        }
        if (logger.isInfoEnabled()) {
            logger.info("testNormWord() - List<Term> termList={}", termList); //$NON-NLS-1$
        }
    }

    @Test
    public void test2() {
        String text = "北京欢迎你";
        List<List<Word>> words = this.manager.foolCutWord(text);

        System.out.println(words);
        for(List<Word> ws: words){
            ws.forEach(System.out::println);
        }

        // POS Tagging
        List<List<Word>> posWords = this.manager.foolPosTagging(text);
        System.out.println(posWords);
        for(List<Word> ws: posWords){
            ws.forEach(System.out::println);
        }

        LexicalAnalyzer lexicalAnalyzer = FoolNLTK.getLSTMLexicalAnalyzer();
        // Named Entity Recognition
        List<List<Entity>>  entities = lexicalAnalyzer.ner(text);

        for(List<Entity> ents :entities){
            ents.forEach(System.out::println);
        }


        // Participle, POS Tagging, Named Entity Recognition
        List<AnalysisResult>  results = lexicalAnalyzer.analysis(text);
        results.forEach(System.out::println);


        // Multi-lined Input Version

        System.out.println();
        System.out.println("多文本：");
        List<String> docs = new ArrayList<>();
        docs.add(text);
        docs.add(text);
        // Participle
        List<List<Word>> dWords = lexicalAnalyzer.cut(docs);
        for(List<Word> ws: dWords){
            ws.forEach(System.out::println);
        }
        // POS Tagging
        List<List<Word>> dPosWords = lexicalAnalyzer.pos(docs);
        for(List<Word> ws: dPosWords){
            ws.forEach(System.out::println);
        }
        // Named Entity Recognition
        List<List<Entity>>  dEntities = lexicalAnalyzer.ner(docs);

        for(List<Entity> ents :dEntities){
            ents.forEach(System.out::println);
        }

        // Participle, POS Tagging, Named Entity Recognition
        List<AnalysisResult>  dResults = lexicalAnalyzer.analysis(docs);
        dResults.forEach(System.out::println);

    }


}
