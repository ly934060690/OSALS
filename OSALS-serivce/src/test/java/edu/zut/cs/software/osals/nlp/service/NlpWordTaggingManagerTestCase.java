package edu.zut.cs.software.osals.nlp.service;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.huaban.analysis.jieba.JiebaSegmenter;
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

    /**
     * HanLP
     * POS tagging : PosTagging
     * -- 01
     */
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
        for(List<Word> ws: words) {
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

        for(List<Entity> ents :entities) {
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

    /**
     * Stanford pos tagging
     * -- 03
     */
    @Test
    public void testStanfordPosTagging() {
        String text = "克林顿说，华盛顿将逐步落实对韩国的经济援助。"
                + "金大中对克林顿的讲话报以掌声：克林顿总统在会谈中重申，他坚定地支持韩国摆脱经济危机。";
        List<Word> wordList = this.manager.stanfordPosTagging(text);
        if (logger.isInfoEnabled()) {
            logger.info("testStanfordPosTagging() - List<Word> wordList={}", wordList.toString()); //$NON-NLS-1$
        }
    }

    @Test
    public void test4() {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String[] sentences =
                new String[] {"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。", "我不喜欢日本和服。", "雷猴回归人间。",
                        "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", "结果婚的和尚未结过婚的"};
        for (String sentence : sentences) {
            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
        }
    }

    /**
     * Ansj -- 04
     * POS tagging : PosTagging
     */
    @Test
    public void testAnsjPosTagging() {
        String text = "腾讯公司的员工非常多，有40678个员工，老板是马化腾";
        List<org.ansj.domain.Term> termList = this.manager.ansjPosTagging(text);
        if (logger.isInfoEnabled()) {
            logger.info("testAnsjPosTagging() - List<org.ansj.domain.Term> termList={}", termList.toString()); //$NON-NLS-1$
        }
    }

    /**
     * FNLP
     */
//    @Test
//    public void testFNLPPosTagging() throws LoadModelException {
//        // 创建中文处理工厂对象，并使用“models”目录下的模型文件初始化
//        CNFactory factory = CNFactory.getInstance("models");
//
//        // 使用分词器对中文句子进行分词，得到分词结果
//        String[] words = factory.seg("关注自然语言处理、语音识别、深度学习等方向的前沿技术和业界动态。");
//
//        // 打印分词结果
//        for(String word : words) {
//            System.out.print(word + " ");
//        }
//        System.out.println();
//    }

}
