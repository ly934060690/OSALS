package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.nlp.dao.NlpAbstractExtractionDao;
import edu.zut.cs.software.osals.nlp.dao.NlpKeywordExtractionDao;
import edu.zut.cs.software.osals.nlp.domain.NlpAbstractExtraction;
import edu.zut.cs.software.osals.nlp.domain.NlpKeywordExtraction;

import java.util.List;

public interface NlpAbstractExtractionManager extends GenericManager<NlpAbstractExtraction,Long> {

    public NlpAbstractExtraction save(NlpAbstractExtractionDao nlpAbstractExtractionDao);

    public void deleteById(Long id);

    public List<NlpAbstractExtraction> findAll();

    public NlpAbstractExtraction findById(Long id);

    String AbstractExtractionHanlp(String text);

    String AbstractExtractionAnsj(String text);


}
