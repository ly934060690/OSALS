package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpAbstractExtraction;


public class NlpAbstractExtractionManagerTestCase extends GenericManagerTestCase<Long, NlpAbstractExtraction,NlpAbstractExtractionManager> {

    public NlpAbstractExtractionManagerTestCase(){
        super(NlpAbstractExtraction.class);
    }
}
