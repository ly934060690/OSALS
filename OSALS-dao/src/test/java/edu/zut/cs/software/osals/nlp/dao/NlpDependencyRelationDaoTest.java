package edu.zut.cs.software.osals.nlp.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpDependencyRelation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: hyh
 * @Description: NlpDependencyRelationDao Test
 * @Date:Created in 11:33 2019/6/13
 * @Modified By:
 */
public class NlpDependencyRelationDaoTest extends GenericDaoTestCase<Long, NlpDependencyRelation, NlpDependencyRelationDao> {

    NlpDependencyRelationDao nlpDependencyRelationDao;

    @Autowired
    public void setHanLPDao(NlpDependencyRelationDao nlpDependencyRelationDao ) {
        this.nlpDependencyRelationDao = nlpDependencyRelationDao;
        this.dao = this.nlpDependencyRelationDao;
    }

    @Test
    public void findAll() {
        List<NlpDependencyRelation> nlpList = this.dao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("findAll() - List<NlpDependencyRelation> nlpList={}", nlpList); //$NON-NLS-1$
        }
    }
}
