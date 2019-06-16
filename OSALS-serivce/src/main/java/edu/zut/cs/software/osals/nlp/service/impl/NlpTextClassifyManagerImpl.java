package edu.zut.cs.software.osals.nlp.service.impl;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.dao.NlpTextClassifyDao;
import edu.zut.cs.software.osals.nlp.domain.NlpTextClassify;
import edu.zut.cs.software.osals.nlp.service.NlpTextClassifyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class NlpTextClassifyManagerImpl extends GenericManagerImpl<NlpTextClassify,Long> implements NlpTextClassifyManager {

    NlpTextClassifyDao nlpTextClassifyDao;
    @Autowired
    public void setHanLPDao(NlpTextClassifyDao nlpTextClassifyDao) {
        this.nlpTextClassifyDao = nlpTextClassifyDao;
        this.dao = this.nlpTextClassifyDao;
    }
}
