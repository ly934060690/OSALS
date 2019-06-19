package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpKeywordExtraction;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: LBW
 * @Date: 2019/6/17
 * @Description: edu.zut.cs.software.osals.nlp.service
 * @version: 1.0
 */
public class NlpKeywordExtractionManagerTestCase  extends GenericManagerTestCase<Long, NlpKeywordExtraction,NlpKeywordExtractionManager> {

    //这里要把这个函数设置为空参数 否则会报：Test class should have exactly one public zero-argument constructor
    public NlpKeywordExtractionManagerTestCase() {
        super(NlpKeywordExtraction.class);
    }

    NlpKeywordExtractionManager nlpKeywordExtractionManager;

    @Autowired
    public void setNlpKeywordExtractionManager(NlpKeywordExtractionManager nlpKeywordExtractionManager) {
        this.nlpKeywordExtractionManager = nlpKeywordExtractionManager;
        this.manager = this.nlpKeywordExtractionManager;
    }

    @Test
    public void testHanLP() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String text = null;
//        text = br.readLine();
        String text = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
        nlpKeywordExtractionManager.KeywordList(text);
    }

    @Test
    public void testAnsj()
    {
        String text = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
        nlpKeywordExtractionManager.KeyWordComputer(text);
    }
}
