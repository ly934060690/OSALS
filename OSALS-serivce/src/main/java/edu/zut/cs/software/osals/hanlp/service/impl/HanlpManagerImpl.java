package edu.zut.cs.software.osals.hanlp.service.impl;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.hanlp.dao.HanlpDao;
import edu.zut.cs.software.osals.hanlp.domain.Hanlp;
import edu.zut.cs.software.osals.hanlp.service.HanlpManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName HanlpManagerImpl
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/6/11 9:10'
 * @Version 1.0
 */
@Component
@Transactional
public class HanlpManagerImpl extends GenericManagerImpl<Hanlp, Long> implements HanlpManager {

    HanlpDao hanlpDao;

    @Autowired
    public void setHanLPDao(HanlpDao hanlpDao) {
        this.hanlpDao = hanlpDao;
        this.dao = this.hanlpDao;
    }

    @Override
    public List<Term> normWord(String text) {
        List<Term> termList = StandardTokenizer.segment(text);
        return termList;
    }
}
