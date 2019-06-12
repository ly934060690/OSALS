package edu.zut.cs.software.osals.nlp.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.nlp.domain.NlpWordTagging;
import org.springframework.stereotype.Repository;

@Repository("nlpWordTaggingDao")
public interface NlpWordTaggingDao extends GenericDao<NlpWordTagging, Long> {

}
