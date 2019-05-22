package edu.zut.cs.software.osals.enwrap.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.enwrap.domain.Enwrap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: hyh
 * @Description: EnwrapDao测试类
 * @Date:Created in 20:34 2019/5/16
 * @Modified By:
 */
public class EnwrapDaoTest extends GenericDaoTestCase<Long, Enwrap, EnwrapDao> {

    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(EnwrapDaoTest.class.getName());

    @Autowired
    EnwrapDao enwrapDao;

    @Test
    public void testFindAll() {
        List<Enwrap> all = this.enwrapDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Enwrap> all={}", all); //$NON-NLS-1$
        }

    }

}
