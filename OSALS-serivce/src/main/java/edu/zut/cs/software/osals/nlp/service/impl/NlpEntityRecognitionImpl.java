package edu.zut.cs.software.osals.nlp.service.impl;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.dao.NlpEntityRecognitionDao;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRecognition;
import org.springframework.beans.factory.annotation.Autowired;

public class NlpEntityRecognitionImpl extends GenericManagerImpl<NlpEntityRecognition,Long> {
    NlpEntityRecognitionDao nlpEntityRecognitionDao;
    @Autowired
    public void setNlpEntityRecognitionDao(NlpEntityRecognitionDao nlpEntityRecognitionDao)
    {
        this.nlpEntityRecognitionDao=nlpEntityRecognitionDao;
        this.dao=this.nlpEntityRecognitionDao;
    }

}
