package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.nlp.dao.NlpKeywordExtractionDao;
import edu.zut.cs.software.osals.nlp.domain.NlpKeywordExtraction;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/6/17
 * @Description: edu.zut.cs.software.osals.nlp.service
 * @version: 1.0
 */

public interface NlpKeywordExtractionManager extends GenericManager<NlpKeywordExtraction,Long> {


    public NlpKeywordExtraction save(NlpKeywordExtractionDao nlpKeywordExtractionDao);

    public void deleteById(Long id);

    public List<NlpKeywordExtraction> findAll();

    public NlpKeywordExtraction findById(Long id);


    /**
     * NLP 关键词提取
     * http://www.hankcs.com/nlp/hanlp.html
     */
    public String KeywordList(String text) throws IOException;

    /**
     * Jieba 关键词提取
     * http://maven.apache.org
     */
    public void tfidfAnalyzer();

    /**
     * Ansj 关键词提取
     *https://github.com/NLPchina/ansj_seg
     * @param content
     */
    public  String  KeyWordComputer(String content);
}
