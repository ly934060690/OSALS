package edu.zut.cs.software.osals.nlp.service.impl;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.dao.NlpDependencyRelationDao;
import edu.zut.cs.software.osals.nlp.domain.NlpDependencyRelation;
import edu.zut.cs.software.osals.nlp.service.NlpDependencyRelationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * @Author:
 * @Description:
 * @Date:Created in 11:50 2019/6/13
 * @Modified By:
 */
@Component
@Transactional
public class NlpDependencyRelationManagerImpl extends GenericManagerImpl<NlpDependencyRelation, Long> implements NlpDependencyRelationManager {

    NlpDependencyRelationDao nlpDependencyRelationDao;

    @Autowired
    public void setHanLPDao(NlpDependencyRelationDao nlpDependencyRelationDao) {
        this.nlpDependencyRelationDao = nlpDependencyRelationDao;
        this.dao = this.nlpDependencyRelationDao;
    }

}
