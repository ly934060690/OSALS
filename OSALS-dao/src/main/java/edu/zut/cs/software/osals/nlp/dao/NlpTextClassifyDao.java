package edu.zut.cs.software.osals.nlp.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.nlp.domain.NlpTextClassify;
import org.springframework.stereotype.Repository;

@Repository("nlpTextClassifyDao")
public interface NlpTextClassifyDao extends GenericDao<NlpTextClassify,Long> {
}
