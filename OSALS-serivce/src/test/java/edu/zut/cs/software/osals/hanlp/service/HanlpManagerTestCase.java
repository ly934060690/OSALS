package edu.zut.cs.software.osals.hanlp.service;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.hanlp.domain.Hanlp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @ClassName HanlpManagerTestCase
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/6/11 17:22
 * @Version 1.0
 */
public class HanlpManagerTestCase extends GenericManagerTestCase<Long, Hanlp, HanlpManager> {

    public HanlpManagerTestCase() {
        super(Hanlp.class);
    }
    HanlpManager hanlpManager;

    @Autowired
    public void setHanlpManager(HanlpManager hanlpManager) {
        this.hanlpManager = hanlpManager;
        this.manager = this.hanlpManager;
    }

    @Test
    public void test1() {
        System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包！"));
    }

    @Test
    public void testNormWord() {
        List<Term> termList = this.manager.normWord("商品和服务");
        if (logger.isInfoEnabled()) {
            logger.info("testNormWord() - List<Term> termList={}", termList); //$NON-NLS-1$
        }
    }

    @Test
    public void test() {
        String string = "D:\\Java\\IdeaProjects\\demo.txt";
        File file = new File(string);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("\nLy_Love_Ly" + '\n');
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
