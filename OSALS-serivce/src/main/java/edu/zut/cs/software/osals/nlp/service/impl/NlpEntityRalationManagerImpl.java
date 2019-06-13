package edu.zut.cs.software.osals.nlp.service.impl;


import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.dao.NlpEntityRelationDao;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRelation;

import edu.zut.cs.software.osals.nlp.service.NlpEntityRelationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class NlpEntityRalationManagerImpl extends GenericManagerImpl<NlpEntityRelation,Long> implements NlpEntityRelationManager {
 NlpEntityRelationDao nlpEntityRelationDao;

 @Autowired
    public void setNlpEntityRelationDao(NlpEntityRelationDao nlpEntityRelationDao) {
        this.nlpEntityRelationDao = nlpEntityRelationDao;
        this.dao=this.nlpEntityRelationDao;
    }
}
