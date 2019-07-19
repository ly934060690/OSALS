package edu.zut.cs.software.osals.nlp.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpTextClassify;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NlpTextClassifyDaoTest extends GenericDaoTestCase<Long, NlpTextClassify,NlpTextClassifyDao> {
    NlpTextClassifyDao nlpTextClassifyDao;

    @Autowired
    public void setNLPDao(NlpTextClassifyDao nlpTextClassifyDao) {
        this.nlpTextClassifyDao = nlpTextClassifyDao;
        this.dao = this.nlpTextClassifyDao;
    }

    @Test
    public void findAll() {
        List<NlpTextClassify> nlpList = this.dao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("findAll() - List<Hanlp> hanlpList={}", nlpList); //$NON-NLS-1$
        }
    }
}
