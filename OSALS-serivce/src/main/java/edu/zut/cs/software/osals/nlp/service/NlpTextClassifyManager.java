package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.nlp.domain.NlpTextClassify;

public interface NlpTextClassifyManager extends GenericManager<NlpTextClassify,Long> {

    //THUCTC
    //String thuctc(String text);
    //EasyDL
    String EasyDL(String text) throws Exception;
    //Fudanlp
    //String Fudanlp(String text) throws Exception;
}
