package edu.zut.cs.software.osals.nlp.service.impl;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.dao.NlpKeywordExtractionDao;
import edu.zut.cs.software.osals.nlp.dao.NlpWordTaggingDao;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRelation;
import edu.zut.cs.software.osals.nlp.domain.NlpKeywordExtraction;
import edu.zut.cs.software.osals.nlp.service.NlpEntityRelationManager;
import edu.zut.cs.software.osals.nlp.service.NlpKeywordExtractionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: LBW
 * @Date: 2019/6/17
 * @Description: edu.zut.cs.software.osals.nlp.service.impl
 * @version: 1.0
 */
@Component
@Transactional
public class NlpKeywordExtractionManagerImpl extends GenericManagerImpl<NlpKeywordExtraction,Long> implements NlpKeywordExtractionManager {

    NlpKeywordExtractionDao nlpKeywordExtractionDao;

    @Autowired
    public void setHanLPDao(NlpKeywordExtractionDao nlpKeywordExtractionDao) {
        this.nlpKeywordExtractionDao = nlpKeywordExtractionDao;
        this.dao = this.nlpKeywordExtractionDao;
    }

    @Override
    public void keywordList(String text) throws IOException {

        System.out.println("下面调用了HanLP的extractKeyword方法！");
        //        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
        List<String> keywordList = HanLP.extractKeyword(text, 5);
        System.out.println("下面输出了键入文本的关键词：");
        System.out.println(keywordList);
    }
}
