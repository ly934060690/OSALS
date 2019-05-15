package edu.zut.cs.software.OSALS.Post_station.dao;


import edu.zut.cs.software.OSALS.Post_station.domain.Post_station;
import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

public class Post_stationDaoTest extends GenericTreeDaoTestCase<Long , Post_station,Post_stationDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(Post_stationDaoTest.class.getName());

    Post_stationDao post_stationDao;

    @Autowired
    public void setPost_stationDao(Post_stationDao post_stationDao) {
        this.post_stationDao = post_stationDao;
        //this.dao = this.post_stationDao;
    }

    @Test
    @Rollback(false)
    public void testGetRoot() {
        int root_size = 10;
        for (int i = 0; i < root_size; i++) {
            Post_station post_station = new Post_station();
            post_station.setName("post_station" + i);
            for (int j = 0; j < 10; j++) {
                Post_station p = new Post_station();
                p.setName("post_station" + i + "_" + j);
                p.setParent(post_station);
            }
            this.post_stationDao.save(post_station);
        }

        List<Post_station> roots = this.post_stationDao.getRoot();
        //assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Post_station> roots={}", roots); //$NON-NLS-1$
        }
    }
}
