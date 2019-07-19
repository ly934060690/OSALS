package edu.zut.cs.software.osals.nlp.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRelation;
import org.springframework.stereotype.Repository;

@Repository("NlpEntityRelation")
public interface NlpEntityRelationDao extends GenericDao<NlpEntityRelation,Long> {


}
