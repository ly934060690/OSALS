package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.nlp.domain.NlpAbstractExtraction;

public interface NlpAbstractExtractionManager extends GenericManager<NlpAbstractExtraction,Long> {

    String AbstractExtractionHanlp(String text);

    String AbstractExtractionAnsj(String text);
}
