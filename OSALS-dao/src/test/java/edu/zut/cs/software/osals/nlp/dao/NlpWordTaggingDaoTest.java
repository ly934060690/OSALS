package edu.zut.cs.software.osals.nlp.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpWordTagging;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName HanLPDaoTest
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/6/11 11:37
 * @Version 1.0
 */
public class NlpWordTaggingDaoTest extends GenericDaoTestCase<Long, NlpWordTagging, NlpWordTaggingDao> {

    NlpWordTaggingDao nlpWordTaggingDao;

    @Autowired
    public void setHanLPDao(NlpWordTaggingDao nlpWordTaggingDao) {
        this.nlpWordTaggingDao = nlpWordTaggingDao;
        this.dao = this.nlpWordTaggingDao;
    }

    @Test
    public void findAll() {
        List<NlpWordTagging> hanlpList = this.dao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("findAll() - List<Hanlp> hanlpList={}", hanlpList); //$NON-NLS-1$
        }
    }
}
