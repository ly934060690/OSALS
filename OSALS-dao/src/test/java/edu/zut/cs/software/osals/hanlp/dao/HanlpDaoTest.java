package edu.zut.cs.software.osals.hanlp.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.hanlp.domain.Hanlp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Table;
import java.util.List;

/**
 * @ClassName HanLPDaoTest
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/6/11 11:37
 * @Version 1.0
 */
public class HanlpDaoTest extends GenericDaoTestCase<Long, Hanlp, HanlpDao> {

    HanlpDao hanlpDao;

    @Autowired
    public void setHanLPDao(HanlpDao hanlpDao) {
        this.hanlpDao = hanlpDao;
        this.dao = this.hanlpDao;
    }

    @Test
    public void findAll() {
        List<Hanlp> hanlpList = this.dao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("findAll() - List<Hanlp> hanlpList={}", hanlpList); //$NON-NLS-1$
        }
    }
}
