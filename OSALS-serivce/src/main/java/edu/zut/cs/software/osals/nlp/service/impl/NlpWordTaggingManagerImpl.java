package edu.zut.cs.software.osals.nlp.service.impl;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.dao.NlpWordTaggingDao;
import edu.zut.cs.software.osals.nlp.domain.NlpWordTagging;
import edu.zut.cs.software.osals.nlp.service.NlpWordTaggingManager;
import me.midday.FoolNLTK;
import me.midday.lexical.LexicalAnalyzer;
import me.midday.lexical.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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

}
