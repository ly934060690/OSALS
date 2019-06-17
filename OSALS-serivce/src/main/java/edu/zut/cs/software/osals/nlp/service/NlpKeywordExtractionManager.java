package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.nlp.domain.NlpKeywordExtraction;
import edu.zut.cs.software.osals.nlp.domain.NlpTextClassify;

import java.io.IOException;

/**
 * @Auther: LBW
 * @Date: 2019/6/17
 * @Description: edu.zut.cs.software.osals.nlp.service
 * @version: 1.0
 */

public interface NlpKeywordExtractionManager extends GenericManager<NlpKeywordExtraction,Long> {

    /**
     * NLP 关键词提取
     * http://www.hankcs.com/nlp/hanlp.html
     */
    public void keywordList(String text) throws IOException;
}
