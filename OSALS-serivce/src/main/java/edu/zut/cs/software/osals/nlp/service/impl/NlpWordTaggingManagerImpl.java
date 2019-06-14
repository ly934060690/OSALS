package edu.zut.cs.software.osals.nlp.service.impl;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.dao.NlpWordTaggingDao;
import edu.zut.cs.software.osals.nlp.domain.NlpWordTagging;
import edu.zut.cs.software.osals.nlp.service.NlpWordTaggingManager;
import me.midday.FoolNLTK;
import me.midday.lexical.LexicalAnalyzer;
import me.midday.lexical.Word;
import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HanlpManagerImpl
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/6/11 9:10'
 * @Version 1.0
 */
@Component
@Transactional
public class NlpWordTaggingManagerImpl extends GenericManagerImpl<NlpWordTagging, Long> implements NlpWordTaggingManager {

    NlpWordTaggingDao nlpWordTaggingDao;

    @Autowired
    public void setHanLPDao(NlpWordTaggingDao nlpWordTaggingDao) {
        this.nlpWordTaggingDao = nlpWordTaggingDao;
        this.dao = this.nlpWordTaggingDao;
    }

    @Override
    public List<Term> normWord(String text) {
        List<Term> termList = StandardTokenizer.segment(text);
        return termList;
    }

    /**
     * FoolNLTK
     * Participle : cutWord
     * POS Tagging : posTagging
     *
     * @param text
     */
    @Override
    public List<List<Word>> foolCutWord(String text) {
        LexicalAnalyzer lexicalAnalyzer = FoolNLTK.getLSTMLexicalAnalyzer();
        List<List<Word>> result = lexicalAnalyzer.cut(text);
        return result;
    }

    @Override
    public List<List<Word>> foolPosTagging(String text) {
        LexicalAnalyzer lexicalAnalyzer = FoolNLTK.getLSTMLexicalAnalyzer();
        List<List<Word>> result = lexicalAnalyzer.pos(text);
        return result;
    }

    /**
     * Stanford CoreNlp
     * POS Tagging : posTagging
     *
     * @param text
     */
    @Override
    public List<Word> stanfordPosTagging(String text) {
        List<Word> wordList = new ArrayList<>();
        Annotation document = new Annotation(text);
        StanfordCoreNLP corenlp = new StanfordCoreNLP("StanfordCoreNLP-chinese.properties");
        corenlp.annotate(document);
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String cutword = token.get(CoreAnnotations.TextAnnotation.class);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                Word word = new Word(cutword, pos);
                wordList.add(word);
            }
        }
        return wordList;
    }

    /**
     * Ansj
     * POS Tagging : posTagging
     *
     * @param text
     */
    @Override
    public List<org.ansj.domain.Term> ansjPosTagging(String text) {
        Result result = BaseAnalysis.parse(text);
        List<org.ansj.domain.Term> resultTerms = result.getTerms();
        return resultTerms;
    }

}
