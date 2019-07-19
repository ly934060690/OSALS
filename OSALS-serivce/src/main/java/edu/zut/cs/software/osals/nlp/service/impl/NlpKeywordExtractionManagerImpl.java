package edu.zut.cs.software.osals.nlp.service.impl;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.dao.NlpKeywordExtractionDao;
import edu.zut.cs.software.osals.nlp.domain.NlpKeywordExtraction;
import edu.zut.cs.software.osals.nlp.service.NlpKeywordExtractionManager;
import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

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
    public NlpKeywordExtraction findById(Long id)
    {
        return nlpKeywordExtractionDao.getOne(id);
    }
    @Override
    public List<NlpKeywordExtraction> findAll()
    {
        return nlpKeywordExtractionDao.findAll();
    }
    @Override
    public void deleteById(Long id)
    {
        nlpKeywordExtractionDao.deleteById(id);
    }
    @Override
    public NlpKeywordExtraction save(NlpKeywordExtraction nlpKeywordExtraction)
    {
        return nlpKeywordExtractionDao.save( nlpKeywordExtraction);
    }

    /**
     * 不是很明白这里不加 ，为啥报错
     * @param nlpKeywordExtractionDao
     * @return
     */
    @Override
    public NlpKeywordExtraction save(NlpKeywordExtractionDao nlpKeywordExtractionDao) {
        return null;
    }

    @Override
    public String  KeywordList(String text) throws IOException {

        System.out.println("下面调用了HanLP的extractKeyword方法！");
        //        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
        List<String> keywordList = HanLP.extractKeyword(text, 5);
        System.out.println("下面输出了键入文本的关键词：");
        System.out.println(keywordList);
        return keywordList.toString();
    }


    @Override
    public void tfidfAnalyzer() {
        System.out.println("下面调用了jieba的tfidfAnalyzer.analyze方法！");
        //TFIDFAnalyzer tfidfAnalyzer=new TFIDFAnalyzer();
        //tfidfAnalyzer
    }

    @Override
    public String KeyWordComputer(String content)
    {
        System.out.println("下面调用了ansj的computeArticleTfidf方法！");
        //String content = "北京英富森软件股份有限公司是在北京市海淀区注册的高新技术企业、双软企业。“信息中国”（information china简称“infcn” ）是“英富森”的核心目标与战略。英富森公司的成立依托于凌云实验室的部分成果和理念，主要以信息管理与信息服务、知识管理与知识服务为基本方向，侧重于信息的整合、组织、发现和利用。通过先进的信息技术和服务理念，帮助行业客户建立企业级信息服务与知识服务平台，实现客户的企业级信息与知识的应用与发现。 公司来源于信息行业，依托于高校和科研院所，服务于行业客户。英富森凝聚了一支专业、高效、快乐、融洽的优秀团队，锻造出了一支服务型、管理型、创新型与开拓型的团队。" ;
        KeyWordComputer kwc = new KeyWordComputer(3,new NlpAnalysis());
        System.out.println("下面输出了键入文本的关键词：");
        System.out.println(kwc.computeArticleTfidf(content));
        return kwc.computeArticleTfidf(content).toString();
    }
}
