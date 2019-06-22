package edu.zut.cs.software.osals.nlp.service.impl;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.domain.NlpAbstractExtraction;
import edu.zut.cs.software.osals.nlp.service.NlpAbstractExtractionManager;
import org.ansj.app.summary.SummaryComputer;
import org.ansj.app.summary.pojo.Summary;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class NlpAbstractExtractionManagerImpl extends GenericManagerImpl<NlpAbstractExtraction,Long> implements NlpAbstractExtractionManager {

    @Override
    public String AbstractExtractionHanlp(String text) {
        List<String> sentenceList = HanLP.extractSummary(text, 3);
        return sentenceList.toString();
    }

    @Override
    public String AbstractExtractionAnsj(String text) {
        SummaryComputer summaryComputer = new SummaryComputer(100, "", text);
        Summary summary = summaryComputer.toSummary();
        return summary.getSummary();
    }


}
