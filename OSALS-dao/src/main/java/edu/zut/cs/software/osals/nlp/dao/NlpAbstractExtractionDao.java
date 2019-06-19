package edu.zut.cs.software.osals.nlp.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.nlp.domain.NlpAbstractExtraction;
import org.springframework.stereotype.Repository;

@Repository("nlpAbstractExtractionDao")
public interface NlpAbstractExtractionDao extends GenericDao<NlpAbstractExtraction, Long> {
}
