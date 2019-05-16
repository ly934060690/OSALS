package edu.zut.cs.software.OSALS.Temporary_station.dao;

import edu.zut.cs.software.OSALS.Temporary_station.domain.Temporary_station;
import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

public class Temporary_stationDaoTest extends GenericDaoTestCase<Long, Temporary_station, Temporary_stationDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(Temporary_stationDaoTest.class.getName());

    @Autowired
    Temporary_stationDao temporary_stationDao;

    @Test
    public void save(){
        Temporary_station temporary_station = new Temporary_station();
        temporary_station.setName("名门豪苑");
        temporary_station.setNumber("11001");
        temporary_stationDao.save(temporary_station);
    }

    @Test
    public void testFindAll() {
        List<Temporary_station> all = this.temporary_stationDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Commodity> all={}", all); //$NON-NLS-1$
        }

    }
}
