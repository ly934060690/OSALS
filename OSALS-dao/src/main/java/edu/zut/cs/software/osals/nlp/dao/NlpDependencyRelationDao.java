package edu.zut.cs.software.osals.nlp.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.nlp.domain.NlpDependencyRelation;
import org.springframework.stereotype.Repository;

/**
 * @Author: hyh
 * @Description:
 * @Date:Created in 11:08 2019/6/13
 * @Modified By:
 */
@Repository("nlpDependencyRelationDao")
public interface NlpDependencyRelationDao extends GenericDao<NlpDependencyRelation, Long> {
}
