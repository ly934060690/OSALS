package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpDependencyRelation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hyh
 * @Description:
 * @Date:Created in 16:05 2019/6/13
 * @Modified By:
 */
public class NlpDependencyRelationManagerTestCase extends GenericManagerTestCase<Long, NlpDependencyRelation,NlpDependencyRelationManager> {

    public NlpDependencyRelationManagerTestCase() {
        super(NlpDependencyRelation.class);
    }
    NlpDependencyRelationManager nlpDependencyRelationManager;

    @Autowired
    public void setHanlpManager(NlpDependencyRelationManager nlpDependencyRelationManager) {
        this.nlpDependencyRelationManager = nlpDependencyRelationManager;
        this.manager = this.nlpDependencyRelationManager;
    }
}
