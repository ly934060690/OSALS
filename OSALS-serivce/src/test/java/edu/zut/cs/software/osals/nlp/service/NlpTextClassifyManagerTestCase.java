package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpTextClassify;
import org.springframework.beans.factory.annotation.Autowired;

public class NlpTextClassifyManagerTestCase extends GenericManagerTestCase<Long, NlpTextClassify,NlpTextClassifyManager> {
    public NlpTextClassifyManagerTestCase() {
        super(NlpTextClassify.class);
    }
    NlpTextClassifyManager nlpTextClassifyManager;

    @Autowired
    public void setnlpManager(NlpTextClassifyManager nlpTextClassifyManager) {
        this.nlpTextClassifyManager = nlpTextClassifyManager;
        this.manager = this.nlpTextClassifyManager;
    }
}
