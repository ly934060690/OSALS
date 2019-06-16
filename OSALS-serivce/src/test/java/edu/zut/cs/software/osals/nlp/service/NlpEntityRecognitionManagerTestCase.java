package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRecognition;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class NlpEntityRecognitionManagerTestCase extends GenericManagerTestCase<Long, NlpEntityRecognition,NlpEntityRecognitionManager> {

    public NlpEntityRecognitionManagerTestCase(Class<NlpEntityRecognition> persistentClass) {
        super(persistentClass);
    }
    NlpEntityRecognitionManager nlpEntityRecognitionManager;
    @Autowired
    public void setHanlpManager(NlpEntityRecognitionManager nlpEntityRecognitionManager) {
        this.nlpEntityRecognitionManager=nlpEntityRecognitionManager;
        this.manager=this.nlpEntityRecognitionManager;
    }

}
