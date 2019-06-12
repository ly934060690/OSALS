package edu.zut.cs.software.osals.nlp.service;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpWordTagging;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName HanlpManagerTestCase
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/6/11 17:22
 * @Version 1.0
 */
public class NlpWordTaggingManagerTestCase extends GenericManagerTestCase<Long, NlpWordTagging, NlpWordTaggingManager> {

    public NlpWordTaggingManagerTestCase() {
        super(NlpWordTagging.class);
    }
    NlpWordTaggingManager nlpWordTaggingManager;

    @Autowired
    public void setHanlpManager(NlpWordTaggingManager nlpWordTaggingManager) {
        this.nlpWordTaggingManager = nlpWordTaggingManager;
        this.manager = this.nlpWordTaggingManager;
    }

    @Test
    public void test1() {
        System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包！"));
    }

    @Test
    public void testNormWord() {
        List<Term> termList = this.manager.normWord("商品和服务");
        for(Term term : termList) {
            System.out.println(term.word + " " + term.nature);
            System.out.println(term);
            System.out.println(term.toString());
        }
        if (logger.isInfoEnabled()) {
            logger.info("testNormWord() - List<Term> termList={}", termList); //$NON-NLS-1$
        }
    }

}
