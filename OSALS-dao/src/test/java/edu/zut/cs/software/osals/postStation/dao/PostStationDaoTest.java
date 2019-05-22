package edu.zut.cs.software.osals.postStation.dao;

import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import edu.zut.cs.software.osals.postStation.domain.PostStation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostStationDaoTest extends GenericTreeDaoTestCase<Long , PostStation, PostStationDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(PostStationDaoTest.class.getName());

    PostStationDao postStationDao;

    @Autowired
    public void setPost_stationDao(PostStationDao postStationDao) {
        this.postStationDao = postStationDao;
        this.dao = this.postStationDao;
    }

    @Test
    public void testGetRoot() {
        int root_size = 10;
        for (int i = 0; i < root_size; i++) {
            PostStation postStation = new PostStation();
            postStation.setName("postStation" + i);
            for (int j = 0; j < 10; j++) {
                PostStation p = new PostStation();
                p.setName("postStation" + i + "_" + j);
                p.setParent(postStation);
            }
            this.postStationDao.save(postStation);
        }

        List<PostStation> roots = this.postStationDao.getRoot();
        //assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Post_station> roots={}", roots); //$NON-NLS-1$
        }
    }
}
