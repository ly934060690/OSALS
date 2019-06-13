package edu.zut.cs.software.osals.nlp.service;

import com.hankcs.hanlp.seg.common.Term;
import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.nlp.domain.NlpWordTagging;
import me.midday.lexical.Word;

import java.util.List;

public interface NlpWordTaggingManager extends GenericManager<NlpWordTagging, Long> {

    //HanLP
    List<Term> normWord(String text);

    /**
     * FoolNLTK
     * Participle : cutWord
     * POS Tagging : posTagging
     */
    List<List<Word>> foolCutWord(String text);

    List<List<Word>> foolPosTagging(String text);

    /**
     * Stanford CoreNlp
     * POS Tagging : posTagging
     */
    List<Word> stanfordPosTagging(String text);

}
