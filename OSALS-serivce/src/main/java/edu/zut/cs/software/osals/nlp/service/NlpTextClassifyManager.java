package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.nlp.dao.NlpTextClassifyDao;
import edu.zut.cs.software.osals.nlp.domain.NlpTextClassify;

import java.util.List;

public interface NlpTextClassifyManager extends GenericManager<NlpTextClassify,Long> {

    //THUCTC
    //String thuctc(String text);
    //EasyDL
    String EasyDL(String text) throws Exception;
    //Fudanlp
    //String Fudanlp(String text) throws Exception;


    public NlpTextClassify save(NlpTextClassifyDao nlpTextClassifyDao);

    public void deleteById(Long id);

    public List<NlpTextClassify> findAll();

    public NlpTextClassify findById(Long id);
}
