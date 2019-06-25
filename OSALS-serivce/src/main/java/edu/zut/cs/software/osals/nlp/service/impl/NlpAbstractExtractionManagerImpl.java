package edu.zut.cs.software.osals.nlp.service.impl;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.dao.NlpAbstractExtractionDao;
import edu.zut.cs.software.osals.nlp.dao.NlpKeywordExtractionDao;
import edu.zut.cs.software.osals.nlp.domain.NlpAbstractExtraction;
import edu.zut.cs.software.osals.nlp.domain.NlpKeywordExtraction;
import edu.zut.cs.software.osals.nlp.service.NlpAbstractExtractionManager;
import org.ansj.app.summary.SummaryComputer;
import org.ansj.app.summary.pojo.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class NlpAbstractExtractionManagerImpl extends GenericManagerImpl<NlpAbstractExtraction,Long> implements NlpAbstractExtractionManager {

    NlpAbstractExtractionDao nlpAbstractExtractionDao;

    @Autowired
    public void setNlpAbstractExtractionDao(NlpAbstractExtractionDao nlpAbstractExtractionDao) {
        this.nlpAbstractExtractionDao = nlpAbstractExtractionDao;
        this.dao = this.nlpAbstractExtractionDao;
    }

    @Override
    public NlpAbstractExtraction findById(Long id)
    {
        return nlpAbstractExtractionDao.getOne(id);
    }
    @Override
    public List<NlpAbstractExtraction> findAll()
    {
        return nlpAbstractExtractionDao.findAll();
    }
    @Override
    public void deleteById(Long id)
    {
        nlpAbstractExtractionDao.deleteById(id);
    }
    @Override
    public NlpAbstractExtraction save(NlpAbstractExtraction nlpKeywordExtraction)
    {
        return nlpAbstractExtractionDao.save(nlpKeywordExtraction);
    }
    @Override
    public String AbstractExtractionHanlp(String text) {
        List<String> sentenceList = HanLP.extractSummary(text, 3);
        return sentenceList.toString();
    }

    @Override
    public NlpAbstractExtraction save(NlpAbstractExtractionDao nlpAbstractExtractionDao) {
        return null;
    }
    @Override
    public String AbstractExtractionAnsj(String text) {
        SummaryComputer summaryComputer = new SummaryComputer(100, "", text);
        Summary summary = summaryComputer.toSummary();
        return summary.getSummary();
    }


}
