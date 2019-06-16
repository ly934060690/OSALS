package edu.zut.cs.software.osals.nlp.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRecognition;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class NlpEntityRecognitionTest extends GenericDaoTestCase<Long, edu.zut.cs.software.osals.nlp.domain.NlpEntityRecognition,NlpEntityRecognitionDao> {

    NlpEntityRecognitionDao nlpEntityRecognitionDao;
    @Autowired
    public void setNlpEntityRecognitionDao(NlpEntityRecognitionDao nlpEntityRecognitionDao)
    {
        this.nlpEntityRecognitionDao=nlpEntityRecognitionDao;
        this.dao=this.nlpEntityRecognitionDao;
    }

    @Test
    @Rollback(false)
    public void TestEntityRecoginition()
    {
        NlpEntityRecognition nlpEntityRecognition=new NlpEntityRecognition();
        nlpEntityRecognition.setSentence("巴希尔强调，政府坚决主张通过和平和政治途径结束目前的武装冲突，在全国实现和平。");
        nlpEntityRecognition.setPer("巴希尔");
        nlpEntityRecognition.setLoc("全国");
        nlpEntityRecognition.setOrg("政府");
        this.nlpEntityRecognitionDao.save(nlpEntityRecognition);
        if (logger.isInfoEnabled()) {
            logger.info("TestEntityRecoginition() - NlpEntityRecognition nlpEntityRecognition={}", nlpEntityRecognition); //$NON-NLS-1$
        }
    }

}
