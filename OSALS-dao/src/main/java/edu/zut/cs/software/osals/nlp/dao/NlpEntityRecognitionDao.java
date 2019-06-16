package edu.zut.cs.software.osals.nlp.dao;


import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRecognition;
import org.springframework.stereotype.Repository;

@Repository("nlpEntityRecognition")
public interface NlpEntityRecognitionDao extends GenericDao<NlpEntityRecognition,Long> {

}
