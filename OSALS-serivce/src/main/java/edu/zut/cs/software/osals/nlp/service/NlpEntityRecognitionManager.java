package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.nlp.dao.NlpEntityRecognitionDao;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRecognition;

import java.util.List;

public interface NlpEntityRecognitionManager extends GenericManager<NlpEntityRecognition,Long> {

    public  NlpEntityRecognition save(NlpEntityRecognition nlpEntityRecognition);
    public String getEntityRecognition(String Sentence);
    public String Stanford(String Sentence);
    public String HanLP(String Sentence);
    public List<NlpEntityRecognition> findAll();
}
