package edu.zut.cs.software.osals.poststation.dao;


import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.poststation.domain.TemporaryStation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TemporaryStationDaoTest extends GenericDaoTestCase<Long, TemporaryStation, TemporaryStationDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(TemporaryStationDaoTest.class.getName());

    @Autowired
    TemporaryStationDao temporaryStationDao;

    @Test
    public void save(){
        TemporaryStation temporaryStation = new TemporaryStation();
        temporaryStation.setEntityName("名门豪苑");
        temporaryStation.setEntityName("11001");
        temporaryStationDao.save(temporaryStation);
    }

    @Test
    public void testFindAll() {
        List<TemporaryStation> all = this.temporaryStationDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Commodity> all={}", all); //$NON-NLS-1$
        }

    }
}
