package edu.zut.cs.software.osals.nlp.service;

import com.hankcs.hanlp.seg.common.Term;
import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.nlp.domain.NlpWordTagging;

import java.util.List;

public interface NlpWordTaggingManager extends GenericManager<NlpWordTagging, Long> {

    List<Term> normWord(String text);

}
