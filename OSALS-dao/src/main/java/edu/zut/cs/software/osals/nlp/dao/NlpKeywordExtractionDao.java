package edu.zut.cs.software.osals.nlp.dao;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.nlp.domain.NlpKeywordExtraction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/6/16
 * @Description: edu.zut.cs.software.osals.nlp.dao
 * @version: 1.0
 */
@Repository("nlpKeywordExtractionDao")
public interface NlpKeywordExtractionDao extends GenericDao<NlpKeywordExtraction , Long> {

}
