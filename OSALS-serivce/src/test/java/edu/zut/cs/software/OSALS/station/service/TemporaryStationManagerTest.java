package edu.zut.cs.software.OSALS.station.service;

import edu.zut.cs.software.OSALS.temporaryStation.domain.TemporaryStation;
import edu.zut.cs.software.OSALS.temporaryStation.service.TemporaryStationManager;
import edu.zut.cs.software.base.service.GenericManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = {"classpath:/applicationContext-service.xml"})
public class TemporaryStationManagerTest extends GenericManagerTestCase<Long, TemporaryStation, TemporaryStationManager> {

    private static final Logger logger = LogManager.getLogger(TemporaryStationManagerTest.class.getName());

    TemporaryStationManager temporaryStationManager;

    public TemporaryStationManagerTest() {
        super(TemporaryStation.class);
    }

    @Autowired
    public void setUserManager(TemporaryStationManager temporaryStationManager) {
        this.temporaryStationManager = temporaryStationManager;
        this.manager = this.temporaryStationManager;
    }

    @Test
    public void testSave() {
        logger.debug("This is a test method for AOP");
        List<TemporaryStation> temporaryStationList = new ArrayList<TemporaryStation>();
        for (int i = 0;i<10;i++) {
            TemporaryStation temporaryStation = new TemporaryStation();
            temporaryStationList.add(temporaryStation);

        }
        this.temporaryStationManager.save(temporaryStationList);
    }
}
